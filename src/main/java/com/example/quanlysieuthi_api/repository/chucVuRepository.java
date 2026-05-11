package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.chucVu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface chucVuRepository extends JpaRepository<chucVu, String> {
    List<chucVu> findByMachucvuContainingOrTenchucvuContaining(String machucvu, String tenchucvu);

    Optional<chucVu> findByMachucvu(String machucvu);

    boolean existsByMachucvu(String machucvu);
}
