package com.xhc.springboot.mapper;

import com.xhc.springboot.entities.Bill;
import com.xhc.springboot.entities.BillProvider;


import java.util.List;

/**
 * @Auther: xhc
 */
//@Mapper 或 @MapperScan("com.xhc.springboot.mapper")
public interface BillMapper {

    List<BillProvider> getBills(Bill bill);

    BillProvider getBillByBid(Integer bid);

    int addBill(Bill bill);

    int updateBill(Bill bill);

    int deteleBillByBid(Integer bid);

}
