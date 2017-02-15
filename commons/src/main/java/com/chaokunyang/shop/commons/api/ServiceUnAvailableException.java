package com.chaokunyang.shop.commons.api;

/**
 * 服务不可用异常
 * @author chaokunyang
 * @create 2017/2/15
 */
public class ServiceUnAvailableException extends RuntimeException {

    private String serviceId;

    public ServiceUnAvailableException(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceId() {
        return serviceId;
    }
}
