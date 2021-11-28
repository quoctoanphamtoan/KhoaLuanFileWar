package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.domain.DonXinNghiHoc;
import com.solienlac.khoaluan.web.domain.LopHocPhan;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.repository.DonXinNghiHocRepository;
import com.solienlac.khoaluan.web.repository.LopHocPhanRepository;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DonXinNghiHocServiceImpl implements DonXinNghiHocService {
    private final DonXinNghiHocRepository donXinNghiHocRepository;
    private final LopHocPhanRepository lopHocPhanRepository;
    private final SinhVienRepository sinhVienRepository;


    @Override
    public Integer xinNghiHoc(Integer idSinhVien, Integer idLopHocPhan, PostDonXinNghiHoc postDonXinNghiHoc) {
        SinhVien sinhVien  = sinhVienRepository.getOne(idSinhVien);
        LopHocPhan lopHocPhan  = lopHocPhanRepository.getOne(idLopHocPhan);
        DonXinNghiHoc donXinNghiHoc =new DonXinNghiHoc(postDonXinNghiHoc.getNoiDung(), postDonXinNghiHoc.getNgayNghi(),sinhVien,lopHocPhan );
        return  donXinNghiHocRepository.save(donXinNghiHoc).getId();
    }

    @Override
    public Integer duyetDonXinNghiHoc(Integer idGiangVien, Integer idDonXinNghiHoc) {
        DonXinNghiHoc donXinNghiHoc = donXinNghiHocRepository.getOne(idDonXinNghiHoc);
        donXinNghiHoc.duyetDonNghiHoc();
        return donXinNghiHoc.getId();
    }
}
