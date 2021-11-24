package com.solienlac.khoaluan.web.domain;

import com.solienlac.khoaluan.web.domain.common.AbstractEntity;
import com.solienlac.khoaluan.web.domain.common.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "taikhoan")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class TaiKhoan  extends AbstractEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tenDangNhap")
    private String tenDangNhap;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
    @Column(name = "matKhau")
    private String matKhau;



    @OneToOne(mappedBy = "taiKhoan")
    private SinhVien sinhVien;

    @OneToOne(mappedBy = "taiKhoan")
    private GiangVien giangVien;

    @OneToOne(mappedBy = "taiKhoan")
    private PhuHuynh phuHuynh;

    public TaiKhoan(@Nullable Integer id, String tenDangNhap, Role role, String matKhau) {
        this.id = id;
        this.tenDangNhap = tenDangNhap;
        this.role = role;
        this.matKhau = matKhau;
    }
}
