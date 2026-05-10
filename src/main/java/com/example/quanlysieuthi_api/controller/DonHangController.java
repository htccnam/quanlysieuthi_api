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

    @DeleteMapping("/{madonhang}") // Endpoint: DELETE /api/donhang/{madonhang}
    public ResponseEntity<?> xoaDonHang(@PathVariable String madonhang) {
        try {
            donHangService.xoaDonHang(madonhang);
            return ResponseEntity.ok("Xóa thành công!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi khi xóa: " + e.getMessage());
        }
    }

    @PutMapping("/{madonhang}") // Endpoint: PUT /api/donhang/{madonhang}
    public ResponseEntity<?> capNhatDonHang(@PathVariable String madonhang, @RequestBody DonHangRequest request) {
        try {
            // Logic service: Xóa chi tiết cũ -> Cập nhật Đơn hàng -> Thêm chi tiết mới
            DonHang updated = donHangService.capNhatDon(madonhang, request.getDonHang(), request.getChitiet());
            return ResponseEntity.ok(updated);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi cập nhật: " + e.getMessage());
        }
    }

    // Lấy toàn bộ danh sách đơn hàng
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
        // Lấy toàn bộ Map ra trước
        Map<String, Object> data = donHangService.getChiTietDonHang(madonhang);
        // Chỉ trả về phần danh sách chi tiết
        return ResponseEntity.ok(data.get("chitiet"));
    }

    @PostMapping // Endpoint: POST /api/donhang
    public ResponseEntity<?> taoDonHang(@RequestBody DonHangRequest request) {
        try {
            // donHangService sẽ xử lý lưu cả 2 bảng
            DonHang saved = donHangService.taoDonHang(request.getDonHang(), request.getChitiet());
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Lỗi tạo đơn: " + e.getMessage());
        }
    }

    // Class phụ trợ để nhận JSON gửi từ Client chứa cả donHang và chiTiet
    @Data
    public static class DonHangRequest {
        private DonHang donHang;
        private List<ChiTiet> chitiet;
    }
}