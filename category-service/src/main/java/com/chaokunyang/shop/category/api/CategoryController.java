package com.chaokunyang.shop.category.api;

import com.chaokunyang.shop.category.model.Category;
import com.chaokunyang.shop.category.service.CategoryService;
import com.chaokunyang.shop.commons.api.Error;
import com.chaokunyang.shop.commons.api.ResourceNotFoundException;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * @author yangck
 * @create 2017-02-15 15:18
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private CategoryService categoryService;

    /*@RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = "application/json")*/
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Category get(@PathVariable Long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Category category = categoryService.findOne(id);
        logger.info("/category, host:" + instance.getHost() + ", serviceId: " + instance.getServiceId() + ",category id: " + category.getId() + ",category name: " + category.getName());
        return category;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Category> save(@RequestBody Category category, UriComponentsBuilder ucb) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/category, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + ",category id:" + category.getId() + ",category name:" + category.getName());

        Category saved = categoryService.save(category);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/category/")
                .path(String.valueOf(saved.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);

        ResponseEntity<Category> responseEntity = new ResponseEntity<Category>(saved, headers, HttpStatus.CREATED);

        return responseEntity;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error resourceNotFound(ResourceNotFoundException e) {
        Long resourceId = e.getResourceId();
        return new Error(4, "Category [" + resourceId + "] not found");
    }
}
