package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.loaiHang;
import com.example.quanlysieuthi_api.repository.loaiHangRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class loaiHangServiceImpl implements loaiHangService {
    public final loaiHangRepository loaiHangRepository;

    @Override
    public loaiHang getLoaiHangById(String maloai) {
        return loaiHangRepository.findById(maloai)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy loại hàng: " + maloai));
    }

    @Override
    public List<loaiHang> getAllLoaiHang() {
        return loaiHangRepository.findAll();
    }

    @Override
    public loaiHang addLoaiHang(loaiHang lh) {
        if (loaiHangRepository.existsById(lh.getMaloai())) {
            throw new RuntimeException("Mã loại hàng đã tồn tại");
        }
        return loaiHangRepository.save(lh);
    }

    @Override
    public loaiHang updateLoaiHang(String maloai, loaiHang lh) {
        loaiHang existing = getLoaiHangById(maloai);
        existing.setTenloai(lh.getTenloai());
        return loaiHangRepository.save(existing);
    }

    @Override
    public void deleteLoaiHang(String maloai) {
        // Lưu ý: Sau này khi làm bảng Sản phẩm, bạn có thể thêm check constraint ở đây
        // giống như cách bạn check nhanVienRepository ở chucVuServiceImpl
        loaiHangRepository.deleteById(maloai);
    }

    @Override
    public List<loaiHang> searchLoaiHang(String keyword1, String keyword2) {
        return loaiHangRepository.findByMaloaiContainingOrTenloaiContaining(keyword1, keyword2);
    }
}