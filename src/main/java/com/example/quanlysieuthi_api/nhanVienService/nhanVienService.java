package com.example.quanlysieuthi_api.nhanVienService;

import com.example.quanlysieuthi_api.entity.nhanVien;

import java.util.List;

public interface nhanVienService {
    List<nhanVien> getAllNhanVien();
    void deletenhanVien(String manhanvien);

}
