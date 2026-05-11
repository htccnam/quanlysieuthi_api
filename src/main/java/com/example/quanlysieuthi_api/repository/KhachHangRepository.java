package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

    List<KhachHang> findByMaKHContainingIgnoreCaseOrHoTenContainingIgnoreCase(String keyword1, String keyword2);

    boolean existsById(String maKH);
}
