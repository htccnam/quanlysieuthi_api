package com.example.quanlysieuthi_api.repository;
import com.example.quanlysieuthi_api.entity.LichSuDoiQua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

@Repository
public interface LichSuDoiQuaRepository extends JpaRepository<LichSuDoiQua, Integer> {
    @Query("SELECT l FROM LichSuDoiQua l WHERE l.maKH = :maKH ORDER BY l.thoiGian DESC")
    List<LichSuDoiQua> findByMaKHOrderByThoiGianDesc(@Param("maKH") String maKH);
}