package com.use.demo.infrastructure.mapper;

import com.use.demo.infrastructure.dataobject.ShopNoteDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopNoteMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ShopNoteDO row);

    ShopNoteDO selectByPrimaryKey(Integer id);

    List<ShopNoteDO> selectAll();

    List<ShopNoteDO> selectPage(@Param("noteType") String noteType,
                                @Param("note") String note,
                                @Param("offset") int offset,
                                @Param("limit") int limit);

    long countByQuery(@Param("noteType") String noteType, @Param("note") String note);

    int updateByPrimaryKey(ShopNoteDO row);
}


