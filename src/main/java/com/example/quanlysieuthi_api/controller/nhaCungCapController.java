package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.nhaCungCapService;
import com.example.quanlysieuthi_api.entity.nhaCungCap;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/nhacungcap")
public class nhaCungCapController {
    private final nhaCungCapService nccService;

    @GetMapping
    public List<nhaCungCap> getAllNhaCungCap() {
        return nccService.getAllNhaCungCap();
    }

    @PostMapping
    public ResponseEntity<?> themNhaCungCap(@RequestBody nhaCungCap ncc) {
        try {
            return ResponseEntity.ok(nccService.addNhaCungCap(ncc));
        } catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }

    @PutMapping("/{manhacungcap}")
    public ResponseEntity<?> suaNhaCungCap(@PathVariable String manhacungcap, @RequestBody nhaCungCap ncc) {
        try {
            return ResponseEntity.ok(nccService.updateNhaCungCap(manhacungcap, ncc));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{manhacungcap}")
    public ResponseEntity<?> xoaNhaCungCap(@PathVariable String manhacungcap) {
        try {
            nccService.deleteNhaCungCap(manhacungcap);
            return ResponseEntity.ok("Xóa thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/search")
    public List<nhaCungCap> searchNhaCungCap(@RequestParam String keyword) {
        return nccService.searchNhaCungCap(keyword, keyword);
    }
}