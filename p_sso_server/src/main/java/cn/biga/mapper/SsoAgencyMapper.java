package cn.biga.mapper;

import cn.biga.entity.SsoAgency;

public interface SsoAgencyMapper {
    int insert(SsoAgency record);

    int insertSelective(SsoAgency record);

    SsoAgency getClientByClientId(String clientId);
}