package com.use.demo.infrastructure.converter;

import com.use.demo.domain.entity.ShopNote;
import com.use.demo.infrastructure.dataobject.ShopNoteDO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopNoteDOConverter {
    ShopNote toDomain(ShopNoteDO data);

    ShopNoteDO toDataObject(ShopNote domain);
}
