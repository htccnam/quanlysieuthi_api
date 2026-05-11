package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.repository.taiKhoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class taiKhoanServiceImpl implements taiKhoanService {
    private final taiKhoanRepository taiKhoanRepository;

    @Override
    public boolean kiemTraDangNhap(String taikhoan, String matkhau) {
        return taiKhoanRepository.findByTaikhoanAndMatkhau(taikhoan, matkhau).isPresent();
    }
}