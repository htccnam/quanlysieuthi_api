package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.KhachHang;
import com.example.quanlysieuthi_api.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository repository;

    public List<KhachHang> getAllKhachHang() {
        return repository.findAll();

    }

    public List<KhachHang> searchKhachHang(String keyword) {
        return repository.findByMaKHContainingIgnoreCaseOrHoTenContainingIgnoreCase(keyword, keyword);
    }

    public KhachHang addKhachHang(KhachHang khachHang) {
        // Logic kiểm tra trùng mã KH
        if (repository.existsById(khachHang.getMaKH())) {
            throw new RuntimeException("Mã khách hàng đã tồn tại!");
        }
        khachHang.setDiemtichluy(0);
        return repository.save(khachHang);
    }

    public KhachHang updateKhachHang(String id, KhachHang khDetails) {
        KhachHang kh = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khách hàng"));

        kh.setHoTen(khDetails.getHoTen());
        kh.setSdt(khDetails.getSdt());
        kh.setGioiTinh(khDetails.getGioiTinh());
        kh.setEmail(khDetails.getEmail());
        kh.setNgaySinh(khDetails.getNgaySinh());
        kh.setDiemtichluy(khDetails.getDiemtichluy());
        kh.setDiachi(khDetails.getDiachi());

        return repository.save(kh);
    }

    public void deleteKhachHang(String id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy khách hàng để xóa");
        }
        try {
            repository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            // Khi xóa khách hàng đã có mã trong bảng hóa đơn, DB sẽ chặn và ném lỗi này
            throw new RuntimeException("Không thể xóa khách hàng đang có đơn hàng");
        }
    }
}


