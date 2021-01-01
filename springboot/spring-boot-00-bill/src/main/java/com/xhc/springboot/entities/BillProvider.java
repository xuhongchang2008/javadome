package com.xhc.springboot.entities;

/**
 * 继承保留帐单信息，添加供应商,
 * @Auther: xhc
 */
public class BillProvider extends Bill{
    private String providerName;

    public String getProviderName() {
        return providerName;
    }
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }
}
