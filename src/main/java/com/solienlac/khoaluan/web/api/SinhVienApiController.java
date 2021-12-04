package com.solienlac.khoaluan.web.api;

import com.solienlac.khoaluan.web.common.dto.ThongTinSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.param.PutSinhVienParam;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import com.solienlac.khoaluan.web.service.SinhVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/sinhvien")
public class SinhVienApiController {
    private final DonXinNghiHocService donXinNghiHocService;
    private final SinhVienService sinhVienService;
    @PostMapping("/donxinnghihoc/{idSinhVien}/{idLopHocPhan}")
    public Integer postDonXinNghiHoc(@PathVariable("idSinhVien") Integer idSinhVien
            , @PathVariable("idLopHocPhan") Integer idLopHocPhan, @RequestBody PostDonXinNghiHoc postDonXinNghiHoc){
        return donXinNghiHocService.xinNghiHoc(idSinhVien,idLopHocPhan,postDonXinNghiHoc);
    }

    @GetMapping("/thongtin/{id}")
    public ThongTinSinhVienDto xemThongTin(@PathVariable("id") Integer id){
        return sinhVienService.xemThongTin(id);
    }

    @PutMapping("/thongtin/{id}")
    public Integer chinhSuaThongTin(@PathVariable("id") Integer id, @RequestBody PutSinhVienParam putSinhVienParam){
        return sinhVienService.chinhSuaSinhVien(id,putSinhVienParam);
    }

}
