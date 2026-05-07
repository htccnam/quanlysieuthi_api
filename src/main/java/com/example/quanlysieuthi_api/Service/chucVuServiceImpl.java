package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.chucVu;
import com.example.quanlysieuthi_api.repository.chucVuRepository;
import com.example.quanlysieuthi_api.repository.nhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class chucVuServiceImpl implements chucVuService{
    public final chucVuRepository chucVuRepository;
    public final nhanVienRepository nhanVienRepository;


    public List<chucVu> getAllChucVu(){
        return chucVuRepository.findAll();
    }

    @Override
    public chucVu addChucVu(chucVu cv) {
        if(chucVuRepository.existsByMachucvu(cv.getMachucvu())){
            throw new RuntimeException("mã chức vụ đã tồn tại");
        }
        return chucVuRepository.save(cv);
    }

    @Override
    public chucVu updateChucVu(chucVu cv) {
        chucVu existing=chucVuRepository.findByMachucvu(cv.getMachucvu())
                .orElseThrow(()->new RuntimeException("không tìm thấy chức vụ"));;

        existing.setTenchucvu(cv.getTenchucvu());
        return chucVuRepository.save(existing);
    }

    @Override
    public void deleteChucVu(String machucvu) {
        if(nhanVienRepository.existsByMachucvu(machucvu)){
            throw new RuntimeException("mã CHỨC VỤ đã được chọn cho NHÂN VIÊN");
        }
        chucVuRepository.findByMachucvu(machucvu)
                .orElseThrow(()->new RuntimeException("không tìm thấy chức vụ"));
        chucVuRepository.deleteById(machucvu);
    }

    @Override
    public List<chucVu> searchChucVu(String keyword) {
        return chucVuRepository.findByMachucvuContainingOrTenchucvuContaining(keyword,keyword);
    }
}
