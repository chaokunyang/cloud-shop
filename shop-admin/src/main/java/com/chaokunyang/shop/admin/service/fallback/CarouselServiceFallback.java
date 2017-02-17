package com.chaokunyang.shop.admin.service.fallback;

import com.chaokunyang.shop.admin.service.CarouselService;
import com.chaokunyang.shop.model.Carousel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangck
 * @create 2017-02-16 17:32
 */
@Component
public class CarouselServiceFallback implements CarouselService {

    private Logger logger = LogManager.getLogger(getClass());

    @Override
    public List<Carousel> carousels(String usedFor) {
        logger.error("CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public Carousel get(Long id) {
        logger.error("CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public Carousel save(Carousel carousel) {
        logger.error("CAROUSEL-SERVICE unavailable");
        return null;
    }

    @Override
    public void delete(Long id) {
        logger.error("CAROUSEL-SERVICE unavailable");
    }
}
