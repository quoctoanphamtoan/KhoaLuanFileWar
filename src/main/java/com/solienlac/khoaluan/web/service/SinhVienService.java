package com.solienlac.khoaluan.web.service;

import com.solienlac.khoaluan.web.common.dto.ThongTinSinhVienDto;
import com.solienlac.khoaluan.web.common.dto.param.PutSinhVienParam;

public interface SinhVienService {
    ThongTinSinhVienDto xemThongTin(Integer id);
    Integer chinhSuaSinhVien(Integer id,PutSinhVienParam putSinhVienParam);


}
