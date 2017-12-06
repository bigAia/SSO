package cn.biga.service;

import cn.biga.entity.SsoManager;
import cn.biga.mapper.SsoRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

 /**
 * @author create biga
 * @version 1.0
 * @since 1.0
  * 查权限
 */
@Service
public class RoleService {
    @Autowired
    private SsoRoleMapper roleMapper;

    public List getRoleByManagerId(SsoManager manager){
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<String> list =  roleMapper.getRoleByManagerId(manager);
        for (String roleName: list) {
            authorities.add(new SimpleGrantedAuthority(roleName));
        }
        return authorities;
    }
}
