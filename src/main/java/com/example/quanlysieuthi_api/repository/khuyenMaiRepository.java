package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.khuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface khuyenMaiRepository extends JpaRepository<khuyenMai, String> {
    List<khuyenMai> findByMakhuyenmaiContainingOrTenkhuyenmaiContaining(String makhuyenmai, String tenkhuyenmai);

    boolean existsByMakhuyenmai(String makhuyenmai);
}
