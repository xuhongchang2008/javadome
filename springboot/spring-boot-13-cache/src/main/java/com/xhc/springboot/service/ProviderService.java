package com.xhc.springboot.service;

import com.xhc.springboot.entities.Provider;
import com.xhc.springboot.mapper.ProviderMapper;
import com.xhc.springboot.utils.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * http://localhost:8080/updateProvider?providerCode=123&providerName=aaa&people=xxx&phone=8888&address=99&pid=4
 * @Auther: xhc
 */
@Service
public class ProviderService {

    @Autowired
    RedisClient redisClient;

    @Autowired
    ProviderMapper providerMapper;

    public Provider getProviderByPid(Integer pid){
        //1.先查询一下缓存中是否有数据
        Object obj = redisClient.get(pid);
        if(obj != null) {
            return (Provider)obj;
        }
        //2.如果缓存中没有,则查数据库,然后添加到缓存中
        Provider provider = providerMapper.getProviderByPid(pid);
        redisClient.set(pid, provider);

        return provider;
    }

    public Integer updateProvider(Provider provider) {
        int size = providerMapper.updateProvider(provider);
        if(size > 0) {
            //更新缓存数据
            redisClient.set(provider.getPid(), provider);
        }
        return size;
    }

    public Integer addProvider(Provider provider){
        int size = providerMapper.addProvider(provider);
        if(size > 0) {
            redisClient.set(provider.getPid(), provider);
        }
        return size;
    }

    public Integer deleteProviderByPid(Integer pid) {
        int size = providerMapper.deleteProviderByPid(pid);
        if(size > 0) {
            //清除key=pid缓存
            redisClient.del(pid);
        }
        return size;
    }

}
