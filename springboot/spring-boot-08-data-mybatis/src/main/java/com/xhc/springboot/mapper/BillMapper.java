package com.xhc.springboot.mapper;

import com.xhc.springboot.entities.Bill;

/**
 * @Auther: xhc
 */
//@Mapper 或 @MapperScan
public interface BillMapper {

    Bill getBillByBid(Integer bid);

    int addBill(Bill bill);



}
