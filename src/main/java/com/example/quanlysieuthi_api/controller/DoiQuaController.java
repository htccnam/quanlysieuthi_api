package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.entity.LichSuDoiQua;
import com.example.quanlysieuthi_api.entity.QuaTang;
import com.example.quanlysieuthi_api.Service.DoiQuaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doiqua")
@CrossOrigin("*")
public class DoiQuaController {

    @Autowired
    private DoiQuaService service;

    // Lấy kho quà
    @GetMapping("/quatang")
    public List<QuaTang> getKhoQua() {
        return service.layDanhSachQua();
    }

    // Lấy lịch sử theo mã khách
    @GetMapping("/lichsu/{maKH}")
    public List<LichSuDoiQua> getLichSu(@PathVariable String maKH) {
        return service.layLichSuCuaKhach(maKH);
    }

    // Gửi yêu cầu đổi quà (Truyền 2 tham số lên qua URL)
    @PostMapping("/thuchien")
    public ResponseEntity<?> doiQua(@RequestParam String maKH, @RequestParam String maQua) {
        try {
            String ketQua = service.thucHienDoiQua(maKH, maQua);
            return ResponseEntity.ok(ketQua);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // Bắn lỗi thiếu điểm về đây
        }
    }
}