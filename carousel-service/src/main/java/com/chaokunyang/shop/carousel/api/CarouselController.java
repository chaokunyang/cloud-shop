package com.chaokunyang.shop.carousel.api;

import com.chaokunyang.shop.carousel.model.Carousel;
import com.chaokunyang.shop.carousel.service.CarouselService;
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
import java.util.List;

/**
 * 轮播服务API
 *
 * @author yangck
 * @create 2017-02-16 10:41
 */
@RestController
@RequestMapping("/carousels")
public class CarouselController {

    private final Logger logger = LogManager.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private CarouselService carouselService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Carousel get(@PathVariable Long id) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/carousels, get, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + ",carousel: " + id);
        Carousel carousel = carouselService.findOne(id);
        return carousel;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Carousel> save(@RequestBody Carousel carousel, UriComponentsBuilder ucb) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/carousel, method: get, host: " + instance.getHost() + ", serviceId: " + instance.getServiceId() + "usedFor: " + carousel.getUsedFor());

        Carousel saved = carouselService.save(carousel);

        HttpHeaders headers = new HttpHeaders();
        URI locationUri = ucb.path("/carousel")
                .path(String.valueOf(carousel.getId()))
                .build()
                .toUri();
        headers.setLocation(locationUri);

        ResponseEntity<Carousel> responseEntity = new ResponseEntity<>(saved, headers, HttpStatus.CREATED);
        return responseEntity;
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<Carousel> carousels(String usedFor) {
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/carousel, get, host:" + instance.getHost() + ", serviceId:" + instance.getServiceId() + ",usedFor: " + usedFor);
        List<Carousel> carousels = carouselService.findByUsedFor(usedFor);
        return carousels;
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error resourceNotFound(ResourceNotFoundException e) {
        Long resourceId = e.getResourceId();
        return new Error(4, "Carousel [" + resourceId + "] not found");
    }
}
