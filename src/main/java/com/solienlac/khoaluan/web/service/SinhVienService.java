package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.GetSinhVienLopHoc;
import com.solienlac.khoaluan.web.common.dto.ThongTinSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.param.PutSinhVienParam;
import org.springframework.data.domain.Pageable;

public interface SinhVienService {
    ThongTinSinhVienDto xemThongTin(Integer id);
    Integer chinhSuaSinhVien(Integer id,PutSinhVienParam putSinhVienParam);
    GetSinhVienLopHoc getSinhVienLopHoc(Pageable pageable,Integer idLopHoc);


}
