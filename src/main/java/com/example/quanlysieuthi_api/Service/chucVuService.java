package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.chucVu;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface chucVuService {
    chucVu getChucVuById(String machucvu);
    List<chucVu> getAllChucVu();
    chucVu addChucVu(chucVu cv);
    chucVu updateChucVu(String machucvu,chucVu cv);
    List<chucVu> seachChucVu(String machuvu, String tenchucvu);
}
