package com.use.demo.domain.gateway;

import com.use.demo.common.Page;
import com.use.demo.domain.entity.ShopNoteCondition;
import com.use.demo.domain.entity.ShopNote;
import java.util.List;

public interface ShopNoteGateway {
    ShopNote create(ShopNote shopNote);

    ShopNote findById(Integer id);

    Page<ShopNote> findPage(ShopNoteCondition condition);

    ShopNote update(Integer id, ShopNote shopNote);

    void delete(Integer id);
}
