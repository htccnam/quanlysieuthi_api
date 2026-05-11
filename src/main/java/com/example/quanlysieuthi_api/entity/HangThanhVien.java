package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "hangthanhvien")
public class HangThanhVien {
    @Id
    @Column(name = "makhachhang", length = 20)
    private String maKH;

    @Column(name = "tenkhachhang")
    private String tenKH;

    @Column(name = "tenhang")
    private String tenHang;
}