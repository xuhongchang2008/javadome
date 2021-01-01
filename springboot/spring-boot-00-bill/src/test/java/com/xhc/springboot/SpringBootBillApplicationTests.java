package com.xhc.springboot;

import com.xhc.springboot.entities.Bill;
import com.xhc.springboot.entities.BillProvider;
import com.xhc.springboot.entities.Provider;
import com.xhc.springboot.entities.User;
import com.xhc.springboot.mapper.BillMapper;
import com.xhc.springboot.mapper.ProviderMapper;
import com.xhc.springboot.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBillApplicationTests {

    @Autowired
    ProviderMapper providerMapper;
    @Test
    public void contextLoads() {
        List<Provider> providers = providerMapper.getProviders(null);
        System.out.println(providers.get(0));

        Provider provider = providerMapper.getProviderByPid(1);
        System.out.println(provider);

        provider.setProviderCode("P_11111");
        int size = providerMapper.updateProvider(provider);
        System.out.println(size);

        providerMapper.addProvider(new Provider(null, "PR-AA", "xhc供应商111", "小张", "18888666981", "深圳软件园", "0911-0123456", "品质A"));

        providerMapper.deleteProviderByPid(5);
    }

    @Autowired
    BillMapper billMapper;
    @Test
    public void testBill() {
        BillProvider b = new BillProvider();
        b.setBillName("com");
        b.setPid(1);
//        b.setPay(1);

        List<BillProvider> billProviders = billMapper.getBills(b);
        System.out.println(billProviders.get(0));

        Bill bill = billMapper.getBillByBid(1);
        System.out.println(bill);

        bill.setBillCode("B_11111");
        int size = billMapper.updateBill(bill);
        System.out.println(size);

        billMapper.addBill(new Bill(null, "Bi-AA11", "粮油aaa", "斤", 80,480.8, new Provider(2002, "PR-BB", "xhc供应商222", "小李", "18888666982", "深圳软件园", "0911-0123453", "品质B"), 1));

        billMapper.deleteBillByBid(6);
    }

    @Autowired
    UserMapper userMapper;
    @Test
    public void testUser() {
        User u = new User();
//        u.setUsername("zhang");

        List<User> users = userMapper.getUsers(u);
        System.out.println(users.get(0));

        User user = userMapper.getUserById(1);
        System.out.println(user);

        user.setUsername("admin");
        int size = userMapper.updateUser(user);
        System.out.println(size);

        billMapper.deleteBillByBid(4);
    }

}
