package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.DonHang;
import com.example.quanlysieuthi_api.entity.ChiTiet;
import java.util.List;
import java.util.Map;

public interface DonHangService {
    DonHang taoDonHang(DonHang dh, List<ChiTiet> dsChiTiet);
    Map<String, Object> getChiTietDonHang(String madonhang);
    List<DonHang> getAllDonHang();
}