package cn.biga.mapper;

import cn.biga.entity.SsoManagerRoleRelation;

public interface SsoManagerRoleRelationMapper {
    int insert(SsoManagerRoleRelation record);

    int insertSelective(SsoManagerRoleRelation record);
}