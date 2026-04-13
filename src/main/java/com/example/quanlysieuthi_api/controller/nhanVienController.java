package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.entity.nhanVien;
import com.example.quanlysieuthi_api.nhanVienService.nhanVienService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
