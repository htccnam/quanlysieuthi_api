package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.chucVu;
import com.example.quanlysieuthi_api.repository.chucVuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class chucVuServiceImpl implements chucVuService{
    public final chucVuRepository chucVuRepository;

    @Override
    public chucVu getChucVuById(String machucvu) {
        return chucVuRepository.findById(machucvu)
                .orElseThrow(()-> new RuntimeException("không tìm thấy chức vụ"+machucvu));
    }

    public List<chucVu> getAllChucVu(){
        return chucVuRepository.findAll();
    }

    @Override
    public chucVu addChucVu(chucVu cv) {
        if(chucVuRepository.existsById(cv.getMachucvu())){
            throw new RuntimeException("mã chức vụ đã tồn tại");
        }else {
            return chucVuRepository.save(cv);
        }
    }

    @Override
    public chucVu updateChucVu(String machucvu, chucVu cv) {
        chucVu existing = getChucVuById(machucvu);
        existing.setTenchucvu(cv.getTenchucvu());
        return chucVuRepository.save(existing);
    }


    @Override
    public List<chucVu> seachChucVu(String keyword, String keyword2) {
        return chucVuRepository.findByMachucvuContainingOrTenchucvuContaining(keyword,keyword2);
    }
}
