package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.nhanVien;
import com.example.quanlysieuthi_api.repository.nhanVienRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class nhanVienServiceImpl implements nhanVienService{
    private final nhanVienRepository nhanVienRepository;

    @Override
    public List<nhanVien> getAllNhanVien() {

        return nhanVienRepository.findAll();
    }

    @Override
    public nhanVien findByManhanvien(String manhanvien) {
        return nhanVienRepository.findByManhanvien(manhanvien)
                .orElseThrow(()->new RuntimeException("không tìm thấy nhân viên"));
    }


    @Override
    public nhanVien themNhanVien(nhanVien nv) {
        if(nhanVienRepository.existsByManhanvien(nv.getManhanvien())){
            throw new RuntimeException("mã nhân viên đã tồn tại");
        }
        return nhanVienRepository.save(nv);
    }

    @Override
    public nhanVien suaNhanVien(nhanVien nv) {
        nhanVien existing = findByManhanvien(nv.getManhanvien());
        existing.setTennhanvien(nv.getTennhanvien());
        existing.setNgaysinh(nv.getNgaysinh());
        existing.setGioitinh(nv.getGioitinh());
        existing.setSodienthoai(nv.getSodienthoai());
        existing.setEmail(nv.getEmail());
        existing.setDiachi(nv.getDiachi());
        existing.setMachucvu(nv.getMachucvu());

        return nhanVienRepository.save(existing);
    }

    @Override
    public void deletenhanVien(String manhanvien) {

    }

    @Override
    public void checktrung(nhanVien nv) {
        if(nhanVienRepository.existsByManhanvien(nv.getManhanvien())){
            throw  new RuntimeException("Mã nhân viên đã tồn tại");
        }
    }
}
