package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.HangThanhVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangThanhVienRepository extends JpaRepository<HangThanhVien, String> {
}