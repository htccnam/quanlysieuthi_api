package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.sanPhamService;
import com.example.quanlysieuthi_api.entity.sanPham;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/sanpham")
public class sanPhamController {
    private final sanPhamService spService;

    @GetMapping
    public List<sanPham> getAllSanPham() {
        return spService.getAllSanPham();
    }

    @PostMapping
    public ResponseEntity<?> themSanPham(@RequestBody sanPham sp) {
        try {
            return ResponseEntity.ok(spService.addSanPham(sp));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/{masanpham}")
    public ResponseEntity<?> suaSanPham(@PathVariable String masanpham, @RequestBody sanPham sp) {
        try {
            return ResponseEntity.ok(spService.updateSanPham(masanpham, sp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{masanpham}")
    public ResponseEntity<?> xoaSanPham(@PathVariable String masanpham) {
        try {
            spService.deleteSanPham(masanpham);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public List<sanPham> searchSanPham(@RequestParam String keyword) {
        return spService.searchSanPham(keyword, keyword);
    }
}