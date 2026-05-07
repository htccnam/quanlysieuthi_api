package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.DonHangService;
import com.example.quanlysieuthi_api.entity.DonHang;
import com.example.quanlysieuthi_api.entity.ChiTiet;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/donhang")
@RequiredArgsConstructor
public class DonHangController {
    private final DonHangService donHangService;

    // Lấy toàn bộ danh sách đơn hàng
    @GetMapping
    public List<DonHang> getAll() {
        return donHangService.getAllDonHang();
    }

    // Xem chi tiết một đơn hàng cụ thể
    @GetMapping("/{madonhang}")
    public ResponseEntity<?> getChiTiet(@PathVariable String madonhang) {
        return ResponseEntity.ok(donHangService.getChiTietDonHang(madonhang));
    }

    // API Tạo đơn hàng mới
    @PostMapping
    public ResponseEntity<?> taoDonHang(@RequestBody DonHangRequest request) {
        try {
            DonHang saved = donHangService.taoDonHang(request.getDonhang(), request.getChitiet());
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi tạo đơn: " + e.getMessage());
        }
    }

    // DTO Helper để nhận JSON từ Client
    @Data
    public static class DonHangRequest {
        private DonHang donhang;
        private List<ChiTiet> chitiet;
    }
}