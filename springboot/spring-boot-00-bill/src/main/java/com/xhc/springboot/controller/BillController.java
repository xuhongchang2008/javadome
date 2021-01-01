package com.xhc.springboot.controller;

import com.xhc.springboot.entities.Bill;
import com.xhc.springboot.entities.BillProvider;
import com.xhc.springboot.entities.Provider;
import com.xhc.springboot.mapper.BillMapper;
import com.xhc.springboot.mapper.ProviderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 帐单的控制层
 * @Auther: xhc
 */
@Controller
public class BillController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    BillMapper billMapper;

    @Autowired
    ProviderMapper providerMapper;

    @GetMapping("/bills")
    public String list(Map<String, Object> map, BillProvider bp) {
        logger.info("帐单列表查询。。。" + bp);
        //获取所有供应商，
        List<Provider> providers = providerMapper.getProviders(null);
        //查询帐单
        Collection<BillProvider> billProviders = billMapper.getBills(bp);

        map.put("providers", providers);
        map.put("billProviders", billProviders);
        //回显
        map.put("billName", bp.getBillName());
        map.put("pid", bp.getPid());
        map.put("pay", bp.getPay());

        return "bill/list";
    }

    /**
     * type = null 进入查看详情页面view.html，
     * type=update 则是进入update.html
     * @param bid 帐单id
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/bill/{bid}")
    public String view(@PathVariable("bid") Integer bid,
                       @RequestParam(value="type", defaultValue = "view") String type,
                       Map<String, Object> map) {
        logger.info("查询" + bid + "的帐单详细信息");

        BillProvider billProvider = billMapper.getBillByBid(bid);
        map.put("billProvider", billProvider);

        //查询所有供应商
        if("update".equals(type)) {
            map.put("providers", providerMapper.getProviders(null));
        }

        // type = null 则进入view.html， type=update 则是进入update.html
        return "bill/" + type;
    }

    //修改
    @PutMapping("/bill")
    public String update(Bill bill) {
        logger.info("更改订单信息。。。");
        //更新操作
        billMapper.updateBill(bill);

        return "redirect:bills";
    }

    //前往添加 页面
    @GetMapping("/bill")
    public String toAddPage(Map<String, Object> map) {
        map.put("providers", providerMapper.getProviders(null));
        return "bill/add";
    }


    //添加数据
    @PostMapping("/bill")
    public String add(Bill bill) {
        logger.info("添加帐单数据" + bill);
        //保存数据操作
        billMapper.addBill(bill);

        return "redirect:/bills";
    }

    //删除
    @DeleteMapping("/bill/{bid}")
    public String delete(@PathVariable("bid") Integer bid) {
        logger.info("删除操作, bid=" + bid);
        billMapper.deleteBillByBid(bid);

        return "redirect:/bills";
    }
}
