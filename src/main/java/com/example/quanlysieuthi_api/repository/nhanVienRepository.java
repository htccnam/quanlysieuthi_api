package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.nhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface nhanVienRepository extends JpaRepository<nhanVien, String> {
    List<nhanVien> findByManhanvienContainingOrTennhanvienContaining(String manhanvien, String tennhanvien);

    boolean existsByMachucvu(String machucvu);

    boolean existsByManhanvien(String manhanvien);

    Optional<nhanVien> findByManhanvien(String manhanvien);
}
