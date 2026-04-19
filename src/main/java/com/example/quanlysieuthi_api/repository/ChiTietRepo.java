package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.ChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChiTietRepo extends JpaRepository<ChiTiet, Long> {
    List<ChiTiet> findByMadonhang(String madonhang);
}