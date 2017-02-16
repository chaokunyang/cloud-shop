package com.chaokunyang.shop.admin.service;

import org.springframework.stereotype.Service;

/**
 * 后台管理服务
 *
 * @author yangck
 * @create 2017-02-16 16:45
 */
@Service
public class AdminService {

    //private final Logger logger = LogManager.getLogger(getClass());
    //
    //@Autowired
    //private RestTemplate restTemplate;
    //
    //@HystrixCommand(fallbackMethod = "saveCategoryFallback")
    //public Category saveCategory(Category category) {
    //    ResponseEntity<Category> responseEntity = restTemplate.postForEntity("http://CATEGORY-SERVICE/category", Category.class, null);
    //    return responseEntity.getBody();
    //}
    //
    //public Category saveCategoryFallback(Category category) {
    //    logger.error("CATEGORY-SERVICE unavailable");
    //    return new Category();
    //}
    //
    //@HystrixCommand(fallbackMethod = "getCategoryFallback")
    //public Category getCategory(Long id) {
    //    return restTemplate.getForEntity("http://CATEGORY-SERVICE/category/" + id, Category.class).getBody();
    //}
    //
    //private Category getCategoryFallback(Long id) {
    //    // throw new ServiceUnAvailableException("CATEGORY-SERVICE");
    //    logger.error("CATEGORY-SERVICE unavailable");
    //    return new Category();
    //}
    //
    //@HystrixCommand(fallbackMethod = "getCarousels")
    //public List<Carousel> getCarousels(String usedFor) {
    //    return restTemplate.getForEntity("http://CAROUSEL-SERVICE/carousels?usedFor=" + usedFor, List.class).getBody();
    //}
    //
    //private List<Carousel> getCarousels() {
    //    logger.error("CAROUSEL-SERVICE unavailable");
    //    return new ArrayList<>();
    //}

}
