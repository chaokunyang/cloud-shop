package com.chaokunyang.shop.admin.web;

import com.chaokunyang.shop.admin.service.CarouselService;
import com.chaokunyang.shop.model.Carousel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 轮播控制器
 *
 * @author yangck
 * @create 2017-02-16 17:57
 */
@Controller
@RequestMapping("/carousel")
public class CarouselController {

    @Autowired
    CarouselService carouselService;

    @RequestMapping(method = RequestMethod.POST)
    public String create(@RequestBody Carousel carousel) {
        carouselService.save(carousel);
        return "redirect:/";
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@RequestBody Carousel carousel) {
        carouselService.save(carousel);
        return "redirect:/";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String delete(@PathVariable Long id) {
        carouselService.delete(id);
        return "redirect:/";
    }
}
