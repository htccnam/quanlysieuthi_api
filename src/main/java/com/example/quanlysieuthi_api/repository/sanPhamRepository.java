package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.sanPham;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface sanPhamRepository extends JpaRepository<sanPham, String> {
    List<sanPham> findByMasanphamContainingOrTensanphamContaining(String masanpham, String tensanpham);
}