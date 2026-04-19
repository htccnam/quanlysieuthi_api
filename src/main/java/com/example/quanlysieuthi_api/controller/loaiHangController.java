package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.loaiHangService;
import com.example.quanlysieuthi_api.entity.loaiHang;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/loaihang")
public class loaiHangController {
    private final loaiHangService loaiHangService;

    @GetMapping
    public List<loaiHang> getAllLoaiHang() {
        return loaiHangService.getAllLoaiHang();
    }

    @PostMapping
    public ResponseEntity<?> themloaihang(@RequestBody loaiHang lh) {
        try {
            return ResponseEntity.ok(loaiHangService.addLoaiHang(lh));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/{maloai}")
    public ResponseEntity<?> sualoaihang(@PathVariable String maloai, @RequestBody loaiHang lh) {
        try {
            return ResponseEntity.ok(loaiHangService.updateLoaiHang(maloai, lh));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{maloai}")
    public ResponseEntity<?> xoaloaihang(@PathVariable String maloai) {
        try {
            loaiHangService.deleteLoaiHang(maloai);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public List<loaiHang> searchLoaiHang(@RequestParam String keyword) {
        return loaiHangService.searchLoaiHang(keyword, keyword);
    }
}