package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.entity.nhanVien;
import com.example.quanlysieuthi_api.Service.nhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
@RequiredArgsConstructor
public class nhanVienController {
    private final nhanVienService nhanVienService;
//    @PostMapping
//    public ResponseEntity<?> createNhanVien(@RequestBody nhanVien nv){
//        try {
//            nhanVien saved = nhanVienService.themNhanVien(nv);
//            return ResponseEntity.ok(saved);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
    @GetMapping
    public List<nhanVien> getAllNhanVien(){
        return nhanVienService.getAllNhanVien();
    }
}
