package com.chaokunyang.shop.service;

import com.chaokunyang.shop.model.Carousel;
import com.chaokunyang.shop.service.fallback.CarouselServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 轮播服务
 *
 * @author yangck
 * @create 2017-02-16 17:29
 */
@FeignClient(value = "carousel-service", fallback = CarouselServiceFallback.class)
public interface CarouselService {

    @RequestMapping(value = "/carousel", method = RequestMethod.GET)
    List<Carousel> carousels(@RequestParam("usedFor") String usedFor);

    @RequestMapping(value = "/carousel/{id}", method = RequestMethod.GET)
    Carousel get(@PathVariable("id") Long id);

    @RequestMapping(value = "/carousel", method = RequestMethod.POST)
    Carousel save(@RequestBody Carousel carousel);

    @RequestMapping(value = "carousel/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable Long id);
}
