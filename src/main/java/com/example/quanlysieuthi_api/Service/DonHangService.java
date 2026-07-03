package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.ChiTiet;
import com.example.quanlysieuthi_api.entity.DonHang;

import java.util.List;
import java.util.Map;

public interface DonHangService {
    DonHang taoDonHang(DonHang dh, List<ChiTiet> dsChiTiet);

    Map<String, Object> getChiTietDonHang(String madonhang);

    List<DonHang> getAllDonHang();
    void xoaDonHang(String madonhang);
    DonHang capNhatDon(String madonhang, DonHang dh, List<ChiTiet> dsChiTiet);
    Double tinhTongChiTieu(String maKH);
}
