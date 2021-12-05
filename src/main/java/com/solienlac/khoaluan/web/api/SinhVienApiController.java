package com.solienlac.khoaluan.web.api;

import com.solienlac.khoaluan.web.common.dto.GetDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.GetThongBaoSinhVien;
import com.solienlac.khoaluan.web.common.dto.ThongTinSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.param.PutSinhVienParam;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import com.solienlac.khoaluan.web.service.SinhVienService;
import com.solienlac.khoaluan.web.service.ThongBaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/sinhvien")
public class SinhVienApiController {
    private final DonXinNghiHocService donXinNghiHocService;
    private final SinhVienService sinhVienService;
    private final ThongBaoService thongBaoService;

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


    @GetMapping("/{idSinhVien}/thongbaos")
    public GetThongBaoSinhVien getDonXinNghiHoc(@PathVariable("idSinhVien") Integer idSinhVien,
                                                @PageableDefault(size = 10, page = 1, direction = Sort.Direction.ASC) Pageable pageable){
        return thongBaoService.getThongBaoSinhVien(pageable,idSinhVien);


    }

}
