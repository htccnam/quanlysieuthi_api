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
    private com.example.quanlysieuthi_api.repository.KhachHangRepository khachHangRepo;


    @Override
    @Transactional // Đảm bảo nếu lỗi chi tiết thì đơn hàng cũng không bị lưu nhầm (Rollback)
    public DonHang taoDonHang(DonHang dh, List<ChiTiet> dsChiTiet) {
        // 1. Lưu bảng cha trước để có mã đơn hàng
        DonHang savedDh = dhRepo.save(dh);

        // 2. Gán mã đơn hàng cho từng chi tiết và lưu danh sách chi tiết
        if (dsChiTiet != null && !dsChiTiet.isEmpty()) {
            for (ChiTiet ct : dsChiTiet) {
                //ct.setId(null);
                ct.setMadonhang(savedDh.getMadonhang()); // Set khóa ngoại
            }
            ctRepo.saveAll(dsChiTiet); // Lưu nhiều dòng cùng lúc
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
        // Tìm và xóa tất cả chi tiết thuộc đơn hàng này
        List<ChiTiet> chiTiets = ctRepo.findByMadonhang(madonhang);
        ctRepo.deleteAll(chiTiets);

        // Sau đó xóa đơn hàng
        dhRepo.deleteById(madonhang);
    }

    @Override
    @Transactional
    public DonHang capNhatDon(String madonhang, DonHang dh, List<ChiTiet> dsChiTiet) {
        // 1. Kiểm tra đơn hàng có tồn tại không
        DonHang existingDh = dhRepo.findById(madonhang)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy đơn hàng mã: " + madonhang));

        // 2. Cập nhật các thông tin cơ bản của đơn hàng
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
    @Override
    public Double tinhTongChiTieu(String maKH) {
        return dhRepo.sumTongTienByMaKH(maKH);
    }

}