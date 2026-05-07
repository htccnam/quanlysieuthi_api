package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "sanpham")
public class sanPham {
    @Id
    @Column(name = "masanpham", nullable = false, length = 50)
    private String masanpham;

    @Column(name = "tensanpham", length = 100)
    private String tensanpham;

    @Column(name = "maloai", length = 50)
    private String maloai;

    @Column(name = "manhacungcap", length = 50)
    private String manhacungcap;

    @Column(name = "xuatxu", length = 100)
    private String xuatxu;

    @Column(name = "soluong")
    private Integer soluong;

    @Column(name = "ngaysanxuat")
    private Date ngaysanxuat;

    @Column(name = "hansudung")
    private Date hansudung;

    @Column(name = "tinhtrang", length = 50)
    private String tinhtrang;

    @Column(name = "gianhap")
    private Double gianhap;

    @Column(name = "giaban")
    private Double giaban;

    @Column(name = "donvitinh", length = 20)
    private String donvitinh;
}