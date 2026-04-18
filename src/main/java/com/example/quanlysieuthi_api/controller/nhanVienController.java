package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.entity.nhanVien;
import com.example.quanlysieuthi_api.Service.nhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nhanvien")
@RequiredArgsConstructor
public class nhanVienController {
    private final nhanVienService nhanVienService;
    @GetMapping
    public List<nhanVien> getAllNhanVien(){
        return nhanVienService.getAllNhanVien();
    }
    @PostMapping
    public ResponseEntity<?> themnhanvien(@RequestBody nhanVien nv){
        try{
            return ResponseEntity.ok(nhanVienService.themNhanVien(nv));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
