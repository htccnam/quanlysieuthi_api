package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepo extends JpaRepository<DonHang, String> {
}