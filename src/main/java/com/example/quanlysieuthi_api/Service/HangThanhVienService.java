package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.HangThanhVien;
import com.example.quanlysieuthi_api.repository.HangThanhVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HangThanhVienService {
    @Autowired
    private HangThanhVienRepository repository;

    public List<HangThanhVien> getAll() {
        return repository.findAll();
    }

    public HangThanhVien addHangThanhVien(HangThanhVien htv) {
        if (repository.existsById(htv.getMaKH())) {
            throw new RuntimeException("Khách hàng này đã được xếp hạng trước đó!");
        }
        return repository.save(htv);
    }

    public void deleteHangThanhVien(String maKH) {
        if (!repository.existsById(maKH)) {
            throw new RuntimeException("Không tìm thấy dữ liệu xếp hạng để xóa!");
        }
        repository.deleteById(maKH);
    }
}