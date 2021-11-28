package com.solienlac.khoaluan.web.api;

import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/sinhvien")
public class SinhVienApiController {
    private final DonXinNghiHocService donXinNghiHocService;
    @PostMapping("/donxinnghihoc/{idSinhVien}/{idLopHocPhan}")
    public Integer postDonXinNghiHoc(@PathVariable("idSinhVien") Integer idSinhVien
            , @PathVariable("idLopHocPhan") Integer idLopHocPhan, @RequestBody PostDonXinNghiHoc postDonXinNghiHoc){
        return donXinNghiHocService.xinNghiHoc(idSinhVien,idLopHocPhan,postDonXinNghiHoc);
    }
}
