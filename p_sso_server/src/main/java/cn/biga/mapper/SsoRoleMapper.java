package cn.biga.mapper;

import cn.biga.entity.SsoManager;
import cn.biga.entity.SsoRole;

import java.util.List;

public interface SsoRoleMapper {
    int insert(SsoRole record);

    int insertSelective(SsoRole record);

    List getRoleByManagerId(SsoManager manager);
}