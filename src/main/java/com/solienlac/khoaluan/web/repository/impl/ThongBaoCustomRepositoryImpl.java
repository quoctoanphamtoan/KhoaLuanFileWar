package com.solienlac.khoaluan.web.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solienlac.khoaluan.web.domain.*;
import com.solienlac.khoaluan.web.repository.ThongBaoCustomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Log4j2
public class ThongBaoCustomRepositoryImpl implements ThongBaoCustomRepository {
    private final QThongBao thongBao = QThongBao.thongBao;
    private final QThongBao_Lop thongBao_lop = QThongBao_Lop.thongBao_Lop;
    private final QLop lop = QLop.lop;
    private final QSinhVien sinhVien = QSinhVien.sinhVien;
    private final QLopHocPhan lopHocPhan =QLopHocPhan.lopHocPhan;
    private final QSinhVien_LopHocPhan sinhVien_lopHocPhan = QSinhVien_LopHocPhan.sinhVien_LopHocPhan;
    private final QThongBao_LopHocPhan thongBao_lopHocPhan = QThongBao_LopHocPhan.thongBao_LopHocPhan;
    private final EntityManager em;




    @Override
    public Page<ThongBao> listThongBao(Pageable pageable, Integer idSinhVien) {
        JPAQuery query = new JPAQueryFactory(em)
                .selectFrom(thongBao)
                .where(thongBao.id.in(
                        new JPAQueryFactory(em).select(thongBao_lopHocPhan.thongBao.id)
                                .from(thongBao_lopHocPhan)
                                .join(thongBao_lopHocPhan.lopHocPhan,lopHocPhan)
                                .join(lopHocPhan.sinhVien_lopHocPhans,sinhVien_lopHocPhan)
                                .join(sinhVien_lopHocPhan.sinhVien,sinhVien)
                                .where(sinhVien.id.eq(idSinhVien))

                ).or(
                        thongBao.id.in(
                                new JPAQueryFactory(em).select(thongBao_lop.thongBao.id)
                                        .from(thongBao_lop)
                                        .join(thongBao_lop.lop,lop)
                                        .join(lop.sinhViens,sinhVien)
                                        .where(sinhVien.id.eq(idSinhVien))

                        )
                ),thongBao.hienThi.eq(true))
                .orderBy(thongBao.ngayTao.desc())
                .offset(pageable.getPageNumber()*pageable.getPageSize()).limit(pageable.getPageSize());
        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);
    }

    //giang vien
    @Override
    public Page<ThongBao> thongBaoLopSinhVien(Pageable pageable, Integer idGiangVien, Integer idLop) {
        JPAQuery query = new JPAQueryFactory(em)
                .selectFrom(thongBao)
                .join(thongBao.thongBao_lops,thongBao_lop)
                .join(thongBao_lop.lop,lop)
                .where(lop.id.eq(idLop),thongBao.giangVien.id.eq(idGiangVien))
                .orderBy(thongBao.ngayTao.desc())
                .offset(pageable.getPageNumber()*pageable.getPageSize()).limit(pageable.getPageSize());
        return PageableExecutionUtils.getPage(query.fetch(), pageable, query::fetchCount);
    }
}
