package com.example.quanlysieuthi_api.repository;
import com.example.quanlysieuthi_api.entity.QuaTang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuaTangRepository extends JpaRepository<QuaTang, String> {
}