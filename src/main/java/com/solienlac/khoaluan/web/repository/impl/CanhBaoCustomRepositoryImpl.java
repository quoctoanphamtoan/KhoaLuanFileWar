package com.solienlac.khoaluan.web.repository.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.solienlac.khoaluan.web.domain.CanhBao;
import com.solienlac.khoaluan.web.domain.QCanhBao;
import com.solienlac.khoaluan.web.repository.CanhBaoCustomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class CanhBaoCustomRepositoryImpl implements CanhBaoCustomRepository {
    private final EntityManager em;
    private QCanhBao canhBao = QCanhBao.canhBao;

    @Override
    public List<CanhBao> listCanhBaoSinhVien(Integer id,Integer idGiangVien) {
        JPAQuery query = new JPAQueryFactory(em)
                .selectFrom(canhBao).where(canhBao.idSinhVien.id.eq(id),canhBao.idGiangVien.id.eq(idGiangVien));
        return query.fetch();
    }
}
