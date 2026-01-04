package com.use.demo.infrastructure.mapper;

import com.use.demo.infrastructure.dataobject.OrgPaymentDO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OrgPaymentMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(OrgPaymentDO row);

    OrgPaymentDO selectByPrimaryKey(Integer id);

    List<OrgPaymentDO> selectAll();

    int updateByPrimaryKey(OrgPaymentDO row);
}


