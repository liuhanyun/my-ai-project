package com.use.demo.adapter.web;

import com.use.demo.client.cmd.ShopNoteCreateCmd;
import com.use.demo.client.cmd.ShopNoteUpdateCmd;
import com.use.demo.common.PageResult;
import com.use.demo.client.co.ShopNoteCO;
import com.use.demo.client.query.ShopNoteQuery;
import com.use.demo.client.service.ShopNoteService;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop-notes")
public class ShopNoteController {
    private final ShopNoteService shopNoteService;

    public ShopNoteController(ShopNoteService shopNoteService) {
        this.shopNoteService = shopNoteService;
    }

    @PostMapping
    public ShopNoteCO create(@RequestBody ShopNoteCreateCmd cmd) {
        return shopNoteService.create(cmd);
    }

    @GetMapping("/{id}")
    public ShopNoteCO findById(@PathVariable Integer id) {
        return shopNoteService.findById(id);
    }

    @GetMapping
    public PageResult<ShopNoteCO> findPage(@ModelAttribute ShopNoteQuery query) {
        return shopNoteService.findPage(query);
    }

    @PutMapping("/{id}")
    public ShopNoteCO update(@PathVariable Integer id, @RequestBody ShopNoteUpdateCmd cmd) {
        return shopNoteService.update(id, cmd);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        shopNoteService.delete(id);
    }
}
