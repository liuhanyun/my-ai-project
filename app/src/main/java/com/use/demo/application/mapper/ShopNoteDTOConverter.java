package com.use.demo.application.mapper;

import com.use.demo.client.cmd.ShopNoteCreateCmd;
import com.use.demo.client.cmd.ShopNoteUpdateCmd;
import com.use.demo.client.co.ShopNoteCO;
import com.use.demo.domain.entity.ShopNote;
import com.use.demo.domain.entity.ShopNoteCondition;
import com.use.demo.client.query.ShopNoteQuery;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShopNoteDTOConverter {
    ShopNote toDomain(ShopNoteCreateCmd cmd);

    ShopNote toDomain(ShopNoteUpdateCmd cmd);

    ShopNoteCO toCO(ShopNote domain);

    ShopNoteCondition toCondition(ShopNoteQuery query);
}
