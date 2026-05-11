package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.loaiHang;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface loaiHangService {
    loaiHang getLoaiHangById(String maloai);

    List<loaiHang> getAllLoaiHang();

    loaiHang addLoaiHang(loaiHang lh);

    loaiHang updateLoaiHang(String maloai, loaiHang lh);

    void deleteLoaiHang(String maloai);

    List<loaiHang> searchLoaiHang(String maloai, String tenloai);
}