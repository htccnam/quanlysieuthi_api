package com.example.quanlysieuthi_api.nhanVienService;

import com.example.quanlysieuthi_api.entity.nhanVien;
import com.example.quanlysieuthi_api.repository.nhanVienRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class nhanVienSeviceImpl implements nhanVienService{
    private final nhanVienRepository nhanVienRepository;

    @Override
    public List<nhanVien> getAllNhanVien() {

        return nhanVienRepository.findAll();
    }

    @Override
    public void deletenhanVien(String manhanvien) {

    }
}
