package com.library.proxies;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "zuul-server",contextId = "bookPropertiesProxy")
@RibbonClient(name = "microservice-books")
@RequestMapping("/microservice-books/properties")
public interface IBooksPropertiesProxy {


    @GetMapping("/renewalNumber")
    Integer renewalNumber();

    @GetMapping("/renewalDay")
    Integer renewalDay();
}
