package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.DonHangService;
import com.example.quanlysieuthi_api.entity.ChiTiet;
import com.example.quanlysieuthi_api.entity.DonHang;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/donhang")
@RequiredArgsConstructor
public class DonHangController {
    private final DonHangService donHangService;

    @DeleteMapping("/{madonhang}")
    public ResponseEntity<?> xoaDonHang(@PathVariable String madonhang) {
        try {
            donHangService.xoaDonHang(madonhang);
            return ResponseEntity.ok("Xóa thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xóa: " + e.getMessage());
        }
    }

    @PutMapping("/{madonhang}")
    public ResponseEntity<?> capNhatDonHang(@PathVariable String madonhang, @RequestBody DonHangRequest request) {
        try {
            DonHang updated = donHangService.capNhatDon(madonhang, request.getDonHang(), request.getChitiet());
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật: " + e.getMessage());
        }
    }

    @GetMapping
    public List<DonHang> getAll() {
        return donHangService.getAllDonHang();
    }


    @GetMapping("/{madonhang}")
    public ResponseEntity<?> getChiTiet(@PathVariable String madonhang) {
        return ResponseEntity.ok(donHangService.getChiTietDonHang(madonhang));
    }

    @GetMapping("/{madonhang}/chitiet")
    public ResponseEntity<?> getOnlyChiTiet(@PathVariable String madonhang) {
        Map<String, Object> data = donHangService.getChiTietDonHang(madonhang);
        return ResponseEntity.ok(data.get("chitiet"));
    }

    @PostMapping
    public ResponseEntity<?> taoDonHang(@RequestBody DonHangRequest request) {
        try {

            DonHang saved = donHangService.taoDonHang(request.getDonHang(), request.getChitiet());
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi tạo đơn: " + e.getMessage());
        }
    }

    @Data
    public static class DonHangRequest {
        private DonHang donHang;
        private List<ChiTiet> chitiet;
    }
}