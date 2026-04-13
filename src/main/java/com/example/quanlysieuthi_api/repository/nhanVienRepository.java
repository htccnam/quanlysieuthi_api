package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.nhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface nhanVienRepository extends JpaRepository<nhanVien,String>  {
    Optional<nhanVien> findByManhanvienAndTennhanvien(String manhanvien , String tennhanvien);
    boolean existsByManhanvien(String manhanvien);
}
