package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.nhaCungCap;
import com.example.quanlysieuthi_api.repository.nhaCungCapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class nhaCungCapServiceImpl implements nhaCungCapService {
    public final nhaCungCapRepository nccRepository;

    @Override
    public nhaCungCap getNhaCungCapById(String manhacungcap) {
        return nccRepository.findById(manhacungcap)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhà cung cấp: " + manhacungcap));
    }

    @Override
    public List<nhaCungCap> getAllNhaCungCap() {
        return nccRepository.findAll();
    }

    @Override
    public nhaCungCap addNhaCungCap(nhaCungCap ncc) {
        if (nccRepository.existsById(ncc.getManhacungcap())) {
            throw new RuntimeException("Mã nhà cung cấp đã tồn tại");
        }
        return nccRepository.save(ncc);
    }

    @Override
    public nhaCungCap updateNhaCungCap(String manhacungcap, nhaCungCap ncc) {
        nhaCungCap existing = getNhaCungCapById(manhacungcap);
        // Cập nhật các trường thông tin (Không cập nhật mã)
        existing.setTennhacungcap(ncc.getTennhacungcap());
        existing.setLoaihinh(ncc.getLoaihinh());
        existing.setEmail(ncc.getEmail());
        existing.setSodienthoai(ncc.getSodienthoai());
        existing.setDiachi(ncc.getDiachi());

        return nccRepository.save(existing);
    }

    @Override
    public void deleteNhaCungCap(String manhacungcap) {
        nccRepository.deleteById(manhacungcap);
    }

    @Override
    public List<nhaCungCap> searchNhaCungCap(String keyword1, String keyword2) {
        return nccRepository.findByManhacungcapContainingOrTennhacungcapContaining(keyword1, keyword2);
    }
}