package com.use.demo.client.service;

import com.use.demo.client.cmd.ShopNoteCreateCmd;
import com.use.demo.client.cmd.ShopNoteUpdateCmd;
import com.use.demo.common.PageResult;
import com.use.demo.client.co.ShopNoteCO;
import com.use.demo.client.query.ShopNoteQuery;
import java.util.List;

public interface ShopNoteService {
    ShopNoteCO create(ShopNoteCreateCmd cmd);

    ShopNoteCO findById(Integer id);

    PageResult<ShopNoteCO> findPage(ShopNoteQuery query);

    ShopNoteCO update(Integer id, ShopNoteUpdateCmd cmd);

    void delete(Integer id);
}
