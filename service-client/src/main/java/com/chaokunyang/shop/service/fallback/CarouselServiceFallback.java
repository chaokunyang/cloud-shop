package com.chaokunyang.shop.service.fallback;

import com.chaokunyang.shop.model.Carousel;
import com.chaokunyang.shop.service.CarouselService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yangck
 * @create 2017-02-16 17:32
 */
public class CarouselServiceFallback implements CarouselService {

    private Logger logger = LogManager.getLogger(getClass());

    @Override
    public List<Carousel> carousels(@RequestParam("usedFor") String usedFor) {
        logger.error("CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public Carousel get(@PathVariable("id") Long id) {
        logger.error("CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public Carousel save(@RequestBody Carousel carousel) {
        logger.error("CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public void delete(@PathVariable Long id) {
        logger.error("CAROUSEL-SERVICE unavailable");
    }
}
