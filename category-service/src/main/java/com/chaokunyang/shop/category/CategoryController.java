package com.chaokunyang.shop.category;

import com.chaokunyang.shop.category.model.Category;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangck
 * @create 2017-02-15 15:18
 */
@RestController
@RequestMapping("/")
public class CategoryController {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private CategoryRepository categoryRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Category get(Long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Category category = categoryRepository.findOne(id);
        logger.info("/get, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + "category name:" + category.getName());
        return category;
    }
}
