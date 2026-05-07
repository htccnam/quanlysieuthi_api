package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.DonHang;
import com.example.quanlysieuthi_api.entity.ChiTiet;
import com.example.quanlysieuthi_api.repository.DonHangRepo;
import com.example.quanlysieuthi_api.repository.ChiTietRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DonHangServiceImpl implements DonHangService {
    private final DonHangRepo dhRepo;
    private final ChiTietRepo ctRepo;

    @Override
    @Transactional
    public DonHang taoDonHang(DonHang dh, List<ChiTiet> dsChiTiet) {
        // 1. Lưu thông tin hóa đơn chung
        DonHang savedDh = dhRepo.save(dh);

        // 2. Gán mã đơn hàng cho từng chi tiết và lưu
        for (ChiTiet ct : dsChiTiet) {
            ct.setMadonhang(savedDh.getMadonhang());
        }
        ctRepo.saveAll(dsChiTiet);

        return savedDh;
    }

    @Override
    public Map<String, Object> getChiTietDonHang(String madonhang) {
        DonHang dh = dhRepo.findById(madonhang).orElse(null);
        List<ChiTiet> dsChiTiet = ctRepo.findByMadonhang(madonhang);

        Map<String, Object> result = new HashMap<>();
        result.put("donhang", dh);
        result.put("chitiet", dsChiTiet);
        return result;
    }

    @Override
    public List<DonHang> getAllDonHang() {
        return dhRepo.findAll();
    }
}