package com.use.demo.infrastructure.gateway;

import com.use.demo.common.Page;
import com.use.demo.domain.entity.ShopNote;
import com.use.demo.domain.entity.ShopNoteCondition;
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
    public Page<ShopNote> findPage(ShopNoteCondition condition) {
        int page = condition != null && condition.getPage() != null && condition.getPage() > 0 ? condition.getPage() : 1;
        int size = condition != null && condition.getSize() != null && condition.getSize() > 0 ? condition.getSize() : 20;
        int offset = (page - 1) * size;
        String noteType = condition == null ? null : condition.getNoteType();
        String note = condition == null ? null : condition.getNote();

        long total = shopNoteMapper.countByQuery(noteType, note);
        List<ShopNote> records = shopNoteMapper.selectPage(noteType, note, offset, size)
            .stream()
            .map(shopNoteDOConverter::toDomain)
            .collect(Collectors.toList());

        Page<ShopNote> result = new Page<>();
        result.setTotal(total);
        result.setPage(page);
        result.setSize(size);
        result.setRecords(records);
        return result;
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
