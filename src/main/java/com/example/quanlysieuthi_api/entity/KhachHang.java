package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "khachhang")
public class KhachHang {

    @Id
    @Column(name = "makhachhang", length = 20)
    private String maKH;

    @Column(name = "tenkhachhang", nullable = false)
    private String hoTen;

    @Column(name = "sdt", length = 15)
    private String sdt;

    @Column(name = "gioitinh", length = 10)
    private String gioiTinh;

    @Column(name = "email")
    private String email;

    @Column(name = "ngaysinh")
    private LocalDate ngaySinh;

    @Column(name = "diemtichluy")
    private Integer diemtichluy;

    @Column(name = "diachi")
    private String diachi;

    // Getters và Setters (Bạn dùng tự sinh của IDE hoặc Lombok @Data)
    // ...

}
