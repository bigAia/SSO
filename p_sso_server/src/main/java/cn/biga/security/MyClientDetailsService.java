package cn.biga.security;

import cn.biga.entity.MyClientDetails;
import cn.biga.entity.SsoAgency;
import cn.biga.service.AgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.security.oauth2.provider.NoSuchClientException;

import java.util.*;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 * 查询第三方登录信息service
 */
public class MyClientDetailsService implements ClientDetailsService {
    @Autowired
    private AgencyService agencyService;
    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
        //去数据库查询clientId
        SsoAgency agency = agencyService.getClientByClientId(s);
        MyClientDetails clientDetails =new MyClientDetails();

        if(null != agency){
            clientDetails.setClientId(agency.getClientid());
            clientDetails.setClientSecret(agency.getClientsecret());
            //跳过是否确定授权
            clientDetails.setAutoApprove(true);
            //resourceId
            clientDetails.setResourceId(stringToSet(agency.getResourceid()));
           //scope
            clientDetails.setScope(stringToSet(agency.getScope()));
            //grant_type
            clientDetails.setAuthorizedGrantTypes(stringToSet(agency.getGranttype()));
            //权限   模拟数据，使用时前往数据库查询
            clientDetails.setAuthorities(Arrays.asList(new SimpleGrantedAuthority("ROLE_CLIENT"),new SimpleGrantedAuthority("ROLE_TRUSTED_CLIENT")));
        }else{
            throw new NoSuchClientException("没有这个clientId: " + s);
        }
        return clientDetails;
    }

    public Set<String> stringToSet(String s){
        if(!"".equals(s) || null != s){
            String [] strings = s.split(",");
            Set<String> set = new HashSet<String>(Arrays.asList(strings));
            return set;
        }
        return null;
    }
}
