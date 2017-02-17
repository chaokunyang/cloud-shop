package com.chaokunyang.shop.carousel;

import com.chaokunyang.shop.carousel.model.Carousel;
import com.chaokunyang.shop.carousel.service.CarouselService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by yangck on 2017/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(CarouselApplication.class)
public class CarouselApplicationTest {

    @Autowired
    private CarouselService carouselService;

    @Test
    public void carouselTestData() {
        carouselService.save(new Carousel(null, "home", 0L, "http://static.ubtoc.com/img/index/carousel-01.jpg", "", "http://mall.ubtob.com/product#/kinds/100", null, "轮播1"));
        carouselService.save(new Carousel(null, "home", 100L, "http://static.ubtoc.com/img/index/carousel-01.jpg", null, "http://mall.ubtob.com/product#/kinds/100", null, "轮播2"));
        carouselService.save(new Carousel(null, "home", 200L, "http://static.ubtoc.com/img/index/carousel-01.jpg", null, "http://mall.ubtob.com/product#/kinds/100", null, "轮播3"));
        carouselService.save(new Carousel(null, "home", 300L, "http://static.ubtoc.com/img/index/carousel-01.jpg", null, "http://mall.ubtob.com/product#/kinds/100", null, "轮播4"));
    }

}