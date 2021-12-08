package com.solienlac.khoaluan.web.common.dto.param;

import com.solienlac.khoaluan.web.domain.common.Role;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class PutImgDetail {
    private Integer id;
    private Role role;
}
