package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.HangThanhVienService;
import com.example.quanlysieuthi_api.entity.HangThanhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/hangthanhvien")
@CrossOrigin("*")
public class HangThanhVienApiController {

    @Autowired
    private HangThanhVienService service;

    @GetMapping
    public List<HangThanhVien> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ResponseEntity<?> add(@RequestBody HangThanhVien htv) {
        try {
            return ResponseEntity.ok(service.addHangThanhVien(htv));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            service.deleteHangThanhVien(id);
            return ResponseEntity.ok("Xóa hạng thành công");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}