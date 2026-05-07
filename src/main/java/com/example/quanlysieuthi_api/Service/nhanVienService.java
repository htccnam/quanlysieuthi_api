package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.nhanVien;

import java.util.List;

public interface nhanVienService {
    List<nhanVien> getAllNhanVien();
    nhanVien themNhanVien(nhanVien nv);
    nhanVien updatenhanvien(nhanVien nv);
    void deletenhanVien(String manhanvien);
    List<nhanVien> search(String key);
}
