package com.xhc.springboot.controller;

import com.xhc.springboot.entities.Provider;
import com.xhc.springboot.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: xhc
 */
@RestController
public class ProviderController {

    @Autowired
    ProviderService providerService;

    @GetMapping("/provider/{pid}")
    public Provider getProvider(@PathVariable("pid") Integer pid) {
        return providerService.getProviderByPid(pid);
    }

    @GetMapping("/updateProvider")
    public Integer updateProvider(Provider provider){
        return providerService.updateProvider(provider);
    }

    @GetMapping("/addProvider")
    public Integer addProvider(Provider provider){
        return providerService.addProvider(provider);
    }

    @GetMapping("/deleteProvider/{pid}")
    public Integer deleteProvider(@PathVariable("pid") Integer pid) {
        providerService.deleteProviderByPid(pid);
        return pid;
    }

}
