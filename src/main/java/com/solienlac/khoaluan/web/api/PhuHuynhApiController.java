package com.solienlac.khoaluan.web.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solienlacdientu/v1/phuhuynh")
public class PhuHuynhApiController {
    @GetMapping("test")
    public String test(){
        return "phu huynh";
    }

}
