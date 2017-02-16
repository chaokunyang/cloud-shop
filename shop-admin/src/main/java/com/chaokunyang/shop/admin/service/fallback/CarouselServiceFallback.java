package com.chaokunyang.shop.admin.service.fallback;

import com.chaokunyang.shop.admin.service.CarouselService;
import com.chaokunyang.shop.model.Carousel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author yangck
 * @create 2017-02-16 17:32
 */
public class CarouselServiceFallback implements CarouselService {
    @Override
    public Carousel get(@PathVariable("id") Long id) {
        return null;
    }

    @Override
    public Carousel save(@RequestBody Carousel carousel) {
        return null;
    }
}
