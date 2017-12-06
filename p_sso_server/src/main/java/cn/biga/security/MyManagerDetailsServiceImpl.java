package cn.biga.security;

import cn.biga.entity.MyUserDetails;
import cn.biga.entity.SsoManager;
import cn.biga.service.ManagerService;
import cn.biga.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

/**
 * @author create biga
 * @version 1.0
 * @since 1.0
 * 查找登录用户service
 */
public class MyManagerDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        MyUserDetails userDetail = new MyUserDetails();
        SsoManager manager = managerService.getManagerByUsername(s);
        if(null != manager){
            userDetail.setUsername(manager.getAccountname());
            userDetail.setPassword(manager.getPassword());
            userDetail.setAccountNonLocked(true);
            userDetail.setAccountNonExpired(true);
            userDetail.setCredentialsNonExpired(true);
            //加盐，没有在数据库住创建这个字段，spring-security框架匹配密码使用
            userDetail.setSalt("spring-securoty!");
            userDetail.setEnabled(manager.getEnabled());
            List list = roleService.getRoleByManagerId(manager);

            userDetail.setAuthorities(list);

        }else{
            throw new UsernameNotFoundException("没找到此用户:"+s);
        }
        return userDetail;
    }
}
