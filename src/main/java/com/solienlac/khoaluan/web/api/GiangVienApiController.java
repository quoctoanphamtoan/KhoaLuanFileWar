package com.solienlac.khoaluan.web.api;

import com.solienlac.khoaluan.web.service.GiangVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/giangvien")
public class GiangVienApiController {
    private final GiangVienService gIangVienService;
    @GetMapping("test")
    public String test(){
        return "giang vien";
    }

}
