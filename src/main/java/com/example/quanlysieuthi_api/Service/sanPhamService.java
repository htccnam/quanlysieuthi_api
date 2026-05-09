package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.sanPham;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface sanPhamService {
    sanPham getSanPhamById(String masanpham);

    List<sanPham> getAllSanPham();

    sanPham addSanPham(sanPham sp);

    sanPham updateSanPham(String masanpham, sanPham sp);

    void deleteSanPham(String masanpham);

    List<sanPham> searchSanPham(String keyword1, String keyword2);
}