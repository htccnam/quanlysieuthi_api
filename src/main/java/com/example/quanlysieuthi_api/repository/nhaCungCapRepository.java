package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.nhaCungCap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface nhaCungCapRepository extends JpaRepository<nhaCungCap, String> {
    // Tìm kiếm theo mã HOẶC theo tên nhà cung cấp
    List<nhaCungCap> findByManhacungcapContainingOrTennhacungcapContaining(String manhacungcap, String tennhacungcap);
}