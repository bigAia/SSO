package cn.biga.mapper;

import cn.biga.entity.SsoAgencyRoleRelation;

public interface SsoAgencyRoleRelationMapper {
    int insert(SsoAgencyRoleRelation record);

    int insertSelective(SsoAgencyRoleRelation record);
}