package cn.biga.service;

import cn.biga.entity.SsoAgency;
import cn.biga.mapper.SsoAgencyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.Oneway;
import java.security.PrivateKey;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 * 查找clientId
 */
@Service
public class AgencyService {
    @Autowired
    private SsoAgencyMapper agencyMapper;

    public SsoAgency getClientByClientId(String clientId){
        return agencyMapper.getClientByClientId(clientId);
    }
}
