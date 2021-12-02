package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.DonXinNghiHocDto;
import com.solienlac.khoaluan.web.common.dto.GetDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.dto.param.PostDonXinNghiHoc;
import com.solienlac.khoaluan.web.common.page.PaginationMeta;
import com.solienlac.khoaluan.web.domain.DonXinNghiHoc;
import com.solienlac.khoaluan.web.domain.LopHocPhan;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.repository.DonXinNghiHocCustomRepository;
import com.solienlac.khoaluan.web.repository.DonXinNghiHocRepository;
import com.solienlac.khoaluan.web.repository.LopHocPhanRepository;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.DonXinNghiHocService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DonXinNghiHocServiceImpl implements DonXinNghiHocService {
    private final DonXinNghiHocRepository donXinNghiHocRepository;
    private final LopHocPhanRepository lopHocPhanRepository;
    private final SinhVienRepository sinhVienRepository;
    private final DonXinNghiHocCustomRepository donXinNghiHocCustomRepository;


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

    @Override
    public GetDonXinNghiHoc getDonXinNghiHoc(Pageable pageable, Integer idGiangVien) {
        List<DonXinNghiHocDto> list = new ArrayList<>();
        Page<DonXinNghiHoc> page = donXinNghiHocCustomRepository.listDonXinNghiHoc(pageable,idGiangVien);
        page.getContent().forEach(donXinNghiHoc -> {
            list.add(new DonXinNghiHocDto(donXinNghiHoc));
        });
        PaginationMeta paginationMeta = PaginationMeta.createPagination(page);
        return new GetDonXinNghiHoc(list,paginationMeta);
    }


}
