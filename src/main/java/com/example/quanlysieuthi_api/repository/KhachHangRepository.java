package com.example.quanlysieuthi_api.repository;
import com.example.quanlysieuthi_api.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, String> {

    // Spring tự động generate câu lệnh SQL giống: SELECT * FROM khachhang WHERE makhachhang LIKE %?% OR tenkhachhang LIKE %?%
    List<KhachHang> findByMaKHContainingIgnoreCaseOrHoTenContainingIgnoreCase(String keyword1, String keyword2);

    // Hàm kiểm tra trùng mã
    boolean existsById(String maKH);
}
