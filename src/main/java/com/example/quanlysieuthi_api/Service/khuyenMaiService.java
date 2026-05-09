package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.khuyenMai;
import org.springframework.stereotype.Service;

import java.util.List;


public interface khuyenMaiService {
    List<khuyenMai> getAllKhuyenMai();
    khuyenMai themKhuyenMai(khuyenMai km);
    khuyenMai suaKhuyenMai(khuyenMai km);
    void xoaKhuyenMai(String makhuyenmai);
    List<khuyenMai> search(String keyword);
}
