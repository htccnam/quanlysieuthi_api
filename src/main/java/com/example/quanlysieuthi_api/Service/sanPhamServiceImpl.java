package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.sanPham;
import com.example.quanlysieuthi_api.repository.sanPhamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class sanPhamServiceImpl implements sanPhamService {
    public final sanPhamRepository spRepository;

    @Override
    public sanPham getSanPhamById(String masanpham) {
        return spRepository.findById(masanpham)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sản phẩm: " + masanpham));
    }

    @Override
    public List<sanPham> getAllSanPham() {
        return spRepository.findAll();
    }

    @Override
    public sanPham addSanPham(sanPham sp) {
        if (spRepository.existsById(sp.getMasanpham())) {
            throw new RuntimeException("Mã sản phẩm đã tồn tại");
        }
        return spRepository.save(sp);
    }

    @Override
    public sanPham updateSanPham(String masanpham, sanPham sp) {
        sanPham existing = getSanPhamById(masanpham);
        existing.setTensanpham(sp.getTensanpham());
        existing.setMaloai(sp.getMaloai());
        existing.setManhacungcap(sp.getManhacungcap());
        existing.setXuatxu(sp.getXuatxu());
        existing.setSoluong(sp.getSoluong());
        existing.setNgaysanxuat(sp.getNgaysanxuat());
        existing.setHansudung(sp.getHansudung());
        existing.setTinhtrang(sp.getTinhtrang());
        existing.setGianhap(sp.getGianhap());
        existing.setGiaban(sp.getGiaban());
        existing.setDonvitinh(sp.getDonvitinh());
        return spRepository.save(existing);
    }

    @Override
    public void deleteSanPham(String masanpham) {
        spRepository.deleteById(masanpham);
    }

    @Override
    public List<sanPham> searchSanPham(String keyword1, String keyword2) {
        return spRepository.findByMasanphamContainingOrTensanphamContaining(keyword1, keyword2);
    }
}