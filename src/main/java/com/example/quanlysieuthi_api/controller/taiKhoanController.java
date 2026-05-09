package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.Service.taiKhoanService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/taikhoan")
@RequiredArgsConstructor
public class taiKhoanController {
    private final taiKhoanService taiKhoanService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginInfo) {
        String taikhoan = loginInfo.get("taikhoan");
        String matkhau = loginInfo.get("matkhau");
        boolean ok = taiKhoanService.kiemTraDangNhap(taikhoan, matkhau);
        if (ok) {
            return ResponseEntity.ok().body(Map.of("message", "Đăng nhập thành công"));
        } else {
            return ResponseEntity.status(401).body("Sai tài khoản hoặc mật khẩu");
        }
    }
}