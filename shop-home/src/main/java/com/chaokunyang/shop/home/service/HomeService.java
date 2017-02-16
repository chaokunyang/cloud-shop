package com.chaokunyang.shop.home.service;

import com.chaokunyang.shop.model.Carousel;
import com.chaokunyang.shop.model.Category;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangck
 * @create 2017-02-15 17:40
 */
@Service
public class HomeService {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getCategoryFallback")
    public Category getCategory(Long id) {
//        System.out.println("getCategory");
        return restTemplate.getForEntity("http://CATEGORY-SERVICE/category/" + id, Category.class).getBody();
    }

    private Category getCategoryFallback(Long id) {
        // throw new ServiceUnAvailableException("CATEGORY-SERVICE");
        logger.error("CATEGORY-SERVICE unavailable");
        return new Category();
    }

    @HystrixCommand(fallbackMethod = "getCarousels")
    public List<Carousel> getCarousels(String usedFor) {
        return restTemplate.getForEntity("http://CAROUSEL-SERVICE/carousels?usedFor=" + usedFor, List.class).getBody();
    }

    private List<Carousel> getCarousels() {
        logger.error("CAROUSEL-SERVICE unavailable");
        return new ArrayList<>();
    }
}
