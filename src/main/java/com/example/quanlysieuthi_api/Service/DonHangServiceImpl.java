package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.ChiTiet;
import com.example.quanlysieuthi_api.entity.DonHang;
import com.example.quanlysieuthi_api.repository.ChiTietRepo;
import com.example.quanlysieuthi_api.repository.DonHangRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DonHangServiceImpl implements DonHangService {
    private final DonHangRepo dhRepo;
    private final ChiTietRepo ctRepo;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DonHang taoDonHang(DonHang dh, List<ChiTiet> dsChiTiet) {
        DonHang savedDh = dhRepo.save(dh);

        if (dsChiTiet != null && !dsChiTiet.isEmpty()) {
            for (ChiTiet ct : dsChiTiet) {
                //ct.setId(null);
                ct.setMadonhang(savedDh.getMadonhang());
            }
            ctRepo.saveAll(dsChiTiet);
        }
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

    @Override
    @Transactional
    public void xoaDonHang(String madonhang) {

        List<ChiTiet> chiTiets = ctRepo.findByMadonhang(madonhang);
        ctRepo.deleteAll(chiTiets);

        dhRepo.deleteById(madonhang);
    }

    @Override
    @Transactional
    public DonHang capNhatDon(String madonhang, DonHang dh, List<ChiTiet> dsChiTiet) {

        DonHang existingDh = dhRepo.findById(madonhang)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng mã: " + madonhang));

        existingDh.setMakhachhang(dh.getMakhachhang());
        existingDh.setManhanvien(dh.getManhanvien());
        existingDh.setNgaylap(dh.getNgaylap());
        existingDh.setPhuongthucban(dh.getPhuongthucban());
        existingDh.setThanhtoan(dh.getThanhtoan());
        existingDh.setTongtien(dh.getTongtien());

        dhRepo.save(existingDh);

        ctRepo.deleteByMadonhangCustom(madonhang);

        ctRepo.flush();

        if (dsChiTiet != null && !dsChiTiet.isEmpty()) {
            for (ChiTiet ct : dsChiTiet) {
                //ct.setId(null);
                ct.setMadonhang(madonhang);
            }
            ctRepo.saveAll(dsChiTiet);
        }

        return existingDh;
    }
}