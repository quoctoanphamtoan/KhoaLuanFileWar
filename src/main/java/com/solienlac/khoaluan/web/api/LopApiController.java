package com.solienlac.khoaluan.web.api;

import com.solienlac.khoaluan.web.common.dto.GetLop;
import com.solienlac.khoaluan.web.service.LopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/solienlacdientu/v1/lop")
@RequiredArgsConstructor
public class LopApiController {
    private final LopService lopService;
    @GetMapping("")
    public ResponseEntity<GetLop> getLops(@PageableDefault(size = 1, page = 2, direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(lopService.getLop(pageable));
    }

}
