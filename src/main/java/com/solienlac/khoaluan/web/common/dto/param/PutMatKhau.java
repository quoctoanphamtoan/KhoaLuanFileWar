package com.solienlac.khoaluan.web.common.dto.param;

import com.solienlac.khoaluan.web.domain.common.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PutMatKhau {
    private Integer id;
    private Role role;
    private String password;
    private String newPassword;
    private String confirmPassword;
}
