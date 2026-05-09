package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.KhachHangService;
import com.example.quanlysieuthi_api.entity.KhachHang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
@CrossOrigin("*") // Cho phép Client ở port khác gọi API
public class KhachHangController {

    @Autowired
    private KhachHangService service;

    @GetMapping
    public List<KhachHang> getAll() {
        return service.getAllKhachHang();
    }

    @GetMapping("/search")
    public List<KhachHang> search(@RequestParam String keyword) {
        return service.searchKhachHang(keyword);
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody KhachHang khachHang) {
        try {
            return ResponseEntity.ok(service.addKhachHang(khachHang));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable String id, @RequestBody KhachHang khachHang) {
        try {
            return ResponseEntity.ok(service.updateKhachHang(id, khachHang));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            service.deleteKhachHang(id);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}