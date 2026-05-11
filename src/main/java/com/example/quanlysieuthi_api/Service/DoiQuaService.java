package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.KhachHang;
import com.example.quanlysieuthi_api.entity.LichSuDoiQua;
import com.example.quanlysieuthi_api.entity.QuaTang;
import com.example.quanlysieuthi_api.repository.KhachHangRepository;
import com.example.quanlysieuthi_api.repository.LichSuDoiQuaRepository;
import com.example.quanlysieuthi_api.repository.QuaTangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoiQuaService {
    @Autowired
    private QuaTangRepository quaTangRepo;
    @Autowired
    private LichSuDoiQuaRepository lichSuRepo;
    @Autowired
    private KhachHangRepository khachHangRepo;

    public List<QuaTang> layDanhSachQua() {
        return quaTangRepo.findAll();
    }

    public List<LichSuDoiQua> layLichSuCuaKhach(String maKH) {
        return lichSuRepo.findByMaKHOrderByThoiGianDesc(maKH);
    }

    // Logic xử lý đổi quà nguyên tử
    @Transactional
    public String thucHienDoiQua(String maKH, String maQua) {
        KhachHang kh = khachHangRepo.findById(maKH)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng!"));
        QuaTang qua = quaTangRepo.findById(maQua)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy phần quà!"));

        // 1. Kiểm tra điểm
        if (kh.getDiemtichluy() < qua.getDiemYeuCau()) {
            int diemThieu = qua.getDiemYeuCau() - kh.getDiemtichluy();
            throw new RuntimeException("Chưa đủ điểm! Cần tích lũy thêm " + diemThieu + " điểm để đổi món quà này.");
        }

        // 2. Trừ điểm khách hàng
        kh.setDiemtichluy(kh.getDiemtichluy() - qua.getDiemYeuCau());
        khachHangRepo.save(kh);

        // 3. Ghi vào lịch sử
        LichSuDoiQua ls = new LichSuDoiQua();
        ls.setMaKH(maKH);
        ls.setTenQua(qua.getTenQua());
        ls.setDiemTru(qua.getDiemYeuCau());
        ls.setThoiGian(LocalDateTime.now());
        lichSuRepo.save(ls);

        return "Đổi quà thành công! Điểm hiện tại còn: " + kh.getDiemtichluy();
    }
}