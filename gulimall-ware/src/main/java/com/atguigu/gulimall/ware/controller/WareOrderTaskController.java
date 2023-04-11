package com.atguigu.gulimall.ware.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.atguigu.gulimall.ware.entity.WareOrderTaskEntity;
import com.atguigu.gulimall.ware.service.WareOrderTaskService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * 库存工作单(WareOrderTask)表控制层
 *
 * @author makejava
 * @since 2023-04-11 21:23:38
 */
@RestController
@RequestMapping("wareOrderTask")
public class WareOrderTaskController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private WareOrderTaskService wareOrderTaskService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param wareOrderTask 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<WareOrderTaskEntity> page, WareOrderTaskEntity wareOrderTask) {
        return success(this.wareOrderTaskService.page(page, new QueryWrapper<>(wareOrderTask)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.wareOrderTaskService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param wareOrderTask 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody WareOrderTaskEntity wareOrderTask) {
        return success(this.wareOrderTaskService.save(wareOrderTask));
    }

    /**
     * 修改数据
     *
     * @param wareOrderTask 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody WareOrderTaskEntity wareOrderTask) {
        return success(this.wareOrderTaskService.updateById(wareOrderTask));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.wareOrderTaskService.removeByIds(idList));
    }
}

