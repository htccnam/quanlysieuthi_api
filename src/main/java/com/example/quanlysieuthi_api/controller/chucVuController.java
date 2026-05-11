package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.chucVuService;
import com.example.quanlysieuthi_api.entity.chucVu;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chucvu")
public class chucVuController {
    private final chucVuService chucVuService;

    @GetMapping
    public List<chucVu> getAllChucVu() {
        return chucVuService.getAllChucVu();
    }

    @PostMapping
    public ResponseEntity<?> themchucvu(@RequestBody chucVu cv) {
        try {
            return ResponseEntity.ok(chucVuService.addChucVu(cv));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/{machucvu}")
    public ResponseEntity<?> suachucvu(@RequestBody chucVu cv) {
        try {
            return ResponseEntity.ok(chucVuService.updateChucVu(cv));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{machucvu}")
    public ResponseEntity<?> xoachucvu(@PathVariable String machucvu) {
        try {
            chucVuService.deleteChucVu(machucvu);
            return ResponseEntity.ok("xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }

    }

    @GetMapping("/search")
    public List<chucVu> searchChucVu(@RequestParam String keyword) {
        return chucVuService.searchChucVu(keyword);
    }
}
