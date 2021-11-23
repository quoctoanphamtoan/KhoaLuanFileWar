package com.solienlac.khoaluan.web.common.dto.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostSmsCanhBao {
    private String messageCanhBao;
    private Integer idSinhVien;
    private Integer idGiangVien;
}
