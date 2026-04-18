package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.nhanVien;

import java.util.List;

public interface nhanVienService {
    List<nhanVien> getAllNhanVien();
    nhanVien findByManhanvien(String manhanvien);
    nhanVien themNhanVien(nhanVien nv);
    nhanVien suaNhanVien(nhanVien nv);
    void deletenhanVien(String manhanvien);
    void checktrung(nhanVien nv);
}
