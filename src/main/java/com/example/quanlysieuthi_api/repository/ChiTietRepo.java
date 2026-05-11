package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.ChiTiet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietRepo extends JpaRepository<ChiTiet, Long> {
    List<ChiTiet> findByMadonhang(String madonhang);
    @Modifying
    @Transactional
    @Query("DELETE FROM ChiTiet c WHERE c.madonhang = :madonhang")
    void deleteByMadonhangCustom(String madonhang);
}