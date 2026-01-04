package com.use.demo.application.service.impl;

import com.use.demo.application.mapper.ShopNoteDTOConverter;
import com.use.demo.client.cmd.ShopNoteCreateCmd;
import com.use.demo.client.cmd.ShopNoteUpdateCmd;
import com.use.demo.client.co.ShopNoteCO;
import com.use.demo.client.query.ShopNoteQuery;
import com.use.demo.client.service.ShopNoteService;
import com.use.demo.domain.entity.ShopNote;
import com.use.demo.domain.gateway.ShopNoteGateway;
import com.use.demo.common.PageResult;
import com.use.demo.common.Page;
import com.use.demo.domain.entity.ShopNoteCondition;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class ShopNoteServiceImpl implements ShopNoteService {
    private final ShopNoteGateway shopNoteGateway;
    private final ShopNoteDTOConverter shopNoteDTOConverter;

    public ShopNoteServiceImpl(ShopNoteGateway shopNoteGateway, ShopNoteDTOConverter shopNoteDTOConverter) {
        this.shopNoteGateway = shopNoteGateway;
        this.shopNoteDTOConverter = shopNoteDTOConverter;
    }

    @Override
    public ShopNoteCO create(ShopNoteCreateCmd cmd) {
        ShopNote domain = shopNoteDTOConverter.toDomain(cmd);
        return shopNoteDTOConverter.toCO(shopNoteGateway.create(domain));
    }

    @Override
    public ShopNoteCO findById(Integer id) {
        ShopNote domain = shopNoteGateway.findById(id);
        return domain == null ? null : shopNoteDTOConverter.toCO(domain);
    }

    @Override
    public PageResult<ShopNoteCO> findPage(ShopNoteQuery query) {
        ShopNoteCondition condition = shopNoteDTOConverter.toCondition(query);
        Page<ShopNote> page = shopNoteGateway.findPage(condition);
        List<ShopNoteCO> records = page.getRecords()
            .stream()
            .map(shopNoteDTOConverter::toCO)
            .collect(Collectors.toList());

        PageResult<ShopNoteCO> result = new PageResult<>();
        result.setTotal(page.getTotal());
        result.setPage(page.getPage());
        result.setSize(page.getSize());
        result.setRecords(records);
        return result;
    }

    @Override
    public ShopNoteCO update(Integer id, ShopNoteUpdateCmd cmd) {
        ShopNote domain = shopNoteDTOConverter.toDomain(cmd);
        return shopNoteDTOConverter.toCO(shopNoteGateway.update(id, domain));
    }

    @Override
    public void delete(Integer id) {
        shopNoteGateway.delete(id);
    }
}

