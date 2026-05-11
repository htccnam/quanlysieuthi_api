package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.loaiHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface loaiHangRepository extends JpaRepository<loaiHang, String> {
    List<loaiHang> findByMaloaiContainingOrTenloaiContaining(String maloai, String tenloai);
}