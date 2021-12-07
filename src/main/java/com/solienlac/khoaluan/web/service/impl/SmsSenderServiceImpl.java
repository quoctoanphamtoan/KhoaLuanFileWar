package com.solienlac.khoaluan.web.service.impl;

import com.solienlac.khoaluan.web.common.dto.param.PostSmsCanhBao;
import com.solienlac.khoaluan.web.config.TwilioConfig;
import com.solienlac.khoaluan.web.domain.CanhBao;
import com.solienlac.khoaluan.web.domain.GiangVien;
import com.solienlac.khoaluan.web.domain.PhuHuynh;
import com.solienlac.khoaluan.web.domain.SinhVien;
import com.solienlac.khoaluan.web.repository.CanhBaoRepository;
import com.solienlac.khoaluan.web.repository.GiangVienRepository;
import com.solienlac.khoaluan.web.repository.SinhVienRepository;
import com.solienlac.khoaluan.web.service.SmsSenderService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsSenderServiceImpl implements SmsSenderService {
    private final TwilioConfig twilioConfig ;
    private final SinhVienRepository sinhVienRepository;
    private final GiangVienRepository giangVienRepository;
    private final CanhBaoRepository canhBaoRepository;
    @Value("twilio.account_sid")
    private String account_sid;
    @Value("twilio.auth_token")
    private String auth_token;
    @Value("twilio.phone_nummber")
    private String phone_nummber;

    @Override
    public Integer senderSms(PostSmsCanhBao thongTinCanhBao) throws IllegalAccessException {
        SinhVien sinhVien = sinhVienRepository.findById(thongTinCanhBao.getIdSinhVien()).orElse(null);

        PhuHuynh phuHuynh = sinhVien.getPhuHuynh();
        GiangVien giangVien = giangVienRepository.findById(thongTinCanhBao.getIdGiangVien()).orElse(null);
        if (isPhoneNumberValid(sinhVien.getSoDienThoai()
                ,phuHuynh.getSoDienThoai())){
            Twilio.init(twilioConfig.getAccount_sid(), twilioConfig.getAuth_token());
            PhoneNumber from = new PhoneNumber(twilioConfig.getPhone_nummber());


            PhoneNumber toPhuHuynh = new PhoneNumber(phuHuynh.getSoDienThoai());
            PhoneNumber toSinhVien = new PhoneNumber(sinhVien.getSoDienThoai());

            String message =thongTinCanhBao.getTieuDe()+" \n "+ thongTinCanhBao.getNoiDung();
            MessageCreator creatorPhuHuynh = Message.creator(toPhuHuynh,from,message);
            MessageCreator creatorSinhVien = Message.creator(toSinhVien,from,message);
            creatorPhuHuynh.create();
            creatorSinhVien.create();
            CanhBao canhBao = new CanhBao(thongTinCanhBao.getTieuDe(),thongTinCanhBao.getNoiDung(),giangVien,sinhVien);
            canhBaoRepository.save(canhBao);
            return canhBao.getId();

        }else{
            throw new IllegalAccessException("Phone number error! ");
        }

    }

    private boolean isPhoneNumberValid(String phoneSinhVien,String phoneGiangVien) {
        if (phoneSinhVien.equalsIgnoreCase("")||phoneGiangVien.equalsIgnoreCase("")){
            return false;
        }
        return true;
    }
}
