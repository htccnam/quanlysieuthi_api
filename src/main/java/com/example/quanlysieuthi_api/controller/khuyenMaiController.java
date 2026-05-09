package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.khuyenMaiService;
import com.example.quanlysieuthi_api.entity.khuyenMai;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/khuyenmai")
@RequiredArgsConstructor
public class khuyenMaiController {
    private final khuyenMaiService khuyenMaiService;

    @GetMapping
    public List<khuyenMai> getAllKhuyenMai() {
        return khuyenMaiService.getAllKhuyenMai();
    }

    @PostMapping
    public ResponseEntity<?> themKhuyenMai(@RequestBody khuyenMai km) {
        try {
            return ResponseEntity.ok(khuyenMaiService.themKhuyenMai(km));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{makhuyenmai}")
    public ResponseEntity<?> suaKhuyenMai(@PathVariable String makhuyenmai, @RequestBody khuyenMai km) {
        try {
            km.setMakhuyenmai(makhuyenmai);
            return ResponseEntity.ok(khuyenMaiService.suaKhuyenMai(km));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{makhuyenmai}")
    public ResponseEntity<?> xoaKhuyenMai(@PathVariable String makhuyenmai) {
        try {
            khuyenMaiService.xoaKhuyenMai(makhuyenmai);
            return ResponseEntity.ok().body("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public List<khuyenMai> searchKhuyenMai(@RequestParam String keyword) {
        return khuyenMaiService.search(keyword);
    }

}
