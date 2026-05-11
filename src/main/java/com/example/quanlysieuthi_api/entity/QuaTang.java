package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "quatang")
public class QuaTang {
    @Id
    @Column(name = "maqua", length = 20)
    private String maQua;

    @Column(name = "tenqua", nullable = false)
    private String tenQua;

    @Column(name = "diemycau")
    private Integer diemYeuCau;

    @Column(name = "mota")
    private String moTa;
}