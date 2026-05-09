package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.khuyenMai;
import com.example.quanlysieuthi_api.repository.khuyenMaiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class khuyenMaiServiceImpl implements khuyenMaiService{
    public final khuyenMaiRepository khuyemmairepo;
    @Override
    public List<khuyenMai> getAllKhuyenMai() {
        return khuyemmairepo.findAll();
    }

    @Override
    public khuyenMai themKhuyenMai(khuyenMai km) {
        if (khuyemmairepo.existsByMakhuyenmai(km.getMakhuyenmai())) {
            throw new RuntimeException("Mã khuyến mãi đã tồn tại!");
        }
        return khuyemmairepo.save(km);
    }

    @Override
    public khuyenMai suaKhuyenMai(khuyenMai km) {
        khuyenMai existing = khuyemmairepo.findById(km.getMakhuyenmai())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khuyến mãi!"));
        existing.setTenkhuyenmai(km.getTenkhuyenmai());
        existing.setMota(km.getMota());
        existing.setSotiengiam(km.getSotiengiam());
        existing.setNgaytao(km.getNgaytao());
        return khuyemmairepo.save(existing);
    }

    @Override
    public void xoaKhuyenMai(String makhuyenmai) {
        if (!khuyemmairepo.existsById(makhuyenmai)) {
            throw new RuntimeException("Khuyến mãi không tồn tại!");
        }
        khuyemmairepo.deleteById(makhuyenmai);
    }

    @Override
    public List<khuyenMai> search(String keyword) {
        return khuyemmairepo.findByMakhuyenmaiContainingOrTenkhuyenmaiContaining(keyword, keyword);
    }
}
