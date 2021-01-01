package com.xhc.springboot.mapper;

import com.xhc.springboot.entities.Bill;
import com.xhc.springboot.entities.BillProvider;

import java.util.List;

/**
 * 帐单管理
 * @Auther: xhc
 */
public interface BillMapper {

    //查询帐单信息，其中包含供应商id与名称
    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deleteBillByBid(Integer bid);

}
