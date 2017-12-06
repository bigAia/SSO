package cn.biga.service;

import cn.biga.entity.SsoManager;
import cn.biga.mapper.SsoManagerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 */
@Service
public class ManagerService {
    @Autowired
    private SsoManagerMapper managerMapper;

    @Autowired(required = false)
    private MessageDigestPasswordEncoder passwordEncoder;

    private String SALT = "spring-securoty!";

    public SsoManager getManagerByUsername(String username){
        return managerMapper.selectByAccountName(username);
    }



    /**
     * 加密密码
     * @param managerDO
     * @return
     */
    public SsoManager passwordEncoder(SsoManager managerDO){
        String saltPassword = passwordEncoder.encodePassword(managerDO.getPassword(),SALT);
        managerDO.setPassword(saltPassword);
        return managerDO;
    }

}
