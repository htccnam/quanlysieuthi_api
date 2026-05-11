package com.example.quanlysieuthi_api.Service;

import com.example.quanlysieuthi_api.entity.nhaCungCap;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface nhaCungCapService {
    nhaCungCap getNhaCungCapById(String manhacungcap);

    List<nhaCungCap> getAllNhaCungCap();

    nhaCungCap addNhaCungCap(nhaCungCap ncc);

    nhaCungCap updateNhaCungCap(String manhacungcap, nhaCungCap ncc);

    void deleteNhaCungCap(String manhacungcap);

    List<nhaCungCap> searchNhaCungCap(String keyword1, String keyword2);
}