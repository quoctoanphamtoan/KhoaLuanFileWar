package com.solienlac.khoaluan.web.domain;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SinhVien_LopHocPhan_Id implements Serializable {
    @Column(name = "idSinhVien")
    private Integer idSinhVien;

    @Column(name = "idLopHocPhan")
    private Integer idLopHocPhan;

}
