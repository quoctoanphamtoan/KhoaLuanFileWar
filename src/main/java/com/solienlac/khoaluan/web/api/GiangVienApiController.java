package com.solienlac.khoaluan.web.api;

import com.solienlac.khoaluan.web.common.dto.GetDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.GetLop;
import com.solienlac.khoaluan.web.common.dto.param.PostSmsCanhBao;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import com.solienlac.khoaluan.web.service.GiangVienService;
import com.solienlac.khoaluan.web.service.LopService;
import com.solienlac.khoaluan.web.service.SmsSenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/solienlacdientu/v1/giangvien")
public class GiangVienApiController {
    private final GiangVienService gIangVienService;
    private final LopService lopService;
    private final SmsSenderService service;
    private final DonXinNghiHocService donXinNghiHocService;
    @GetMapping("test")
    public String test(){
        return "giang vien";
    }

    /*
     *Lấy danh sách tất cả lớp học của giảng viên theo mã giảng viên(idGiangVien)
     * Giá trị trả về bao gồm:
     *      tenLop;
            tenChuyenNganh;
            siSo;
     */
    @GetMapping("/{idGiangVien}/danhsachlophoc")
    public ResponseEntity<GetLop> getLops(@PathVariable("idGiangVien") Integer idGiangVien, @PageableDefault(size = 10, page = 2, direction = Sort.Direction.ASC) Pageable pageable){
        return ResponseEntity.ok(lopService.getLop(pageable,idGiangVien));
    }


      /*
        Gởi tin nhắn cảnh báo cho sinh viên và phụ huynh
      */
    @PostMapping("/canhbao")
    @ResponseStatus(HttpStatus.CREATED)
    public Integer smsCanhBaoSinhVien(@RequestBody PostSmsCanhBao thongTinCanhBao) throws IllegalAccessException {
        return service.senderSms(thongTinCanhBao);
    }

    @PutMapping("/donnghihoc/{idGiangVien}/{idDonNghiHoc}")
    @ResponseStatus(HttpStatus.OK)
    public Integer duyetDonNghiHoc(@PathVariable("idGiangVien") Integer idGiangVien,
                                   @PathVariable("idDonNghiHoc") Integer idDonNghiHoc){
        return donXinNghiHocService.duyetDonXinNghiHoc(idGiangVien,idDonNghiHoc);
    }

    @GetMapping("/idGiangVien/list-donxinnghihoc")
    public GetDonXinNghiHoc getDonXinNghiHoc(@PathVariable("idGiangVien") Integer idGiangVien,
                                             @PageableDefault(size = 10, page = 1, direction = Sort.Direction.ASC) Pageable pageable){
        return donXinNghiHocService.getDonXinNghiHoc(pageable,idGiangVien);


    }


}
