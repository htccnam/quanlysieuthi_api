package com.example.quanlysieuthi_api.repository;

import com.example.quanlysieuthi_api.entity.DonHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DonHangRepo extends JpaRepository<DonHang, String> {
    @Query("SELECT SUM(d.tongtien) FROM DonHang d WHERE d.makhachhang = :maKH")
    Double sumTongTienByMaKH(@Param("maKH") String maKH);
}