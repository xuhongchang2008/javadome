package com.xhc.springboot.mapper;

import com.xhc.springboot.entities.Provider;


import java.util.List;

/**
 * @Auther: xhc
 */
//@Mapper 或 @MapperScan("com.xhc.springboot.mapper")
public interface ProviderMapper {

    List<Provider> getProviders(Provider provider);

    Provider getProviderByPid(Integer pid);

    int addProvider(Provider provider);

    int deleteProviderByPid(Integer pid);

    int updateProvider(Provider provider);

}
