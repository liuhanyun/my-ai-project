package com.use.demo.infrastructure.mapper;

import com.use.demo.infrastructure.dataobject.ShopNoteDO;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface ShopNoteMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ShopNoteDO row);

    ShopNoteDO selectByPrimaryKey(Integer id);

    List<ShopNoteDO> selectAll();

    int updateByPrimaryKey(ShopNoteDO row);
}


