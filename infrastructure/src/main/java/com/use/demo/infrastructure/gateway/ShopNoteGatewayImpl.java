package com.use.demo.infrastructure.gateway;

import com.use.demo.domain.entity.ShopNote;
import com.use.demo.domain.gateway.ShopNoteGateway;
import com.use.demo.infrastructure.converter.ShopNoteDOConverter;
import com.use.demo.infrastructure.dataobject.ShopNoteDO;
import com.use.demo.infrastructure.mapper.ShopNoteMapper;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShopNoteGatewayImpl implements ShopNoteGateway {
    private final ShopNoteMapper shopNoteMapper;
    private final ShopNoteDOConverter shopNoteDOConverter;

    public ShopNoteGatewayImpl(ShopNoteMapper shopNoteMapper, ShopNoteDOConverter shopNoteDOConverter) {
        this.shopNoteMapper = shopNoteMapper;
        this.shopNoteDOConverter = shopNoteDOConverter;
    }

    @Override
    public ShopNote create(ShopNote shopNote) {
        ShopNoteDO data = shopNoteDOConverter.toDataObject(shopNote);
        shopNoteMapper.insert(data);
        return shopNoteDOConverter.toDomain(data);
    }

    @Override
    public ShopNote findById(Integer id) {
        ShopNoteDO data = shopNoteMapper.selectByPrimaryKey(id);
        return data == null ? null : shopNoteDOConverter.toDomain(data);
    }

    @Override
    public List<ShopNote> findAll() {
        return shopNoteMapper.selectAll()
            .stream()
            .map(shopNoteDOConverter::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public ShopNote update(Integer id, ShopNote shopNote) {
        ShopNoteDO data = shopNoteDOConverter.toDataObject(shopNote);
        data.setId(id);
        shopNoteMapper.updateByPrimaryKey(data);
        return shopNoteDOConverter.toDomain(data);
    }

    @Override
    public void delete(Integer id) {
        shopNoteMapper.deleteByPrimaryKey(id);
    }
}
