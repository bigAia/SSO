package cn.biga.mapper;

import cn.biga.entity.SsoManager;

public interface SsoManagerMapper {
    int deleteByPrimaryKey(String id);

    int insert(SsoManager record);

    int insertSelective(SsoManager record);

    SsoManager selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SsoManager record);

    int updateByPrimaryKey(SsoManager record);

    SsoManager selectByAccountName(String accountName);
}