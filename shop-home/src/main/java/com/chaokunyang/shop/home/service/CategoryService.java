package com.chaokunyang.shop.home.service;

import com.chaokunyang.shop.commons.api.Error;
import com.chaokunyang.shop.commons.api.ServiceUnAvailableException;
import com.chaokunyang.shop.model.Category;
import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author yangck
 * @create 2017-02-15 17:40
 */
@Service
public class CategoryService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCategoryFallback")
    public Category getCategory(Long id) {
        return restTemplate.getForEntity("http://CATEGORY-SERVICE/category/" + id, Category.class).getBody();
    }

    public void getCategoryFallback() {
        throw new ServiceUnAvailableException("CATEGORY-SERVICE");
    }
}
