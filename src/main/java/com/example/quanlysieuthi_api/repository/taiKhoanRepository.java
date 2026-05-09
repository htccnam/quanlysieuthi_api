package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.taiKhoan;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface taiKhoanRepository extends JpaRepository<taiKhoan, String> {
    Optional<taiKhoan> findByTaikhoanAndMatkhau(String taikhoan, String matkhau);
}