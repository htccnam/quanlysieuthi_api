package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "donhang")
public class DonHang {
    @Id
    @Column(name = "madonhang", nullable = false, length = 50)
    private String madonhang;

    @Column(name = "makhachhang", length = 50)
    private String makhachhang;

    @Column(name = "manhanvien", length = 50)
    private String manhanvien;

    @Column(name = "makhuyenmai", length = 50)
    private String makhuyenmai;

    @Column(name = "ngaylap")
    private Date ngaylap;

    @Column(name = "phuongthucban", length = 50)
    private String phuongthucban;

    @Column(name = "thanhtoan", length = 50)
    private String thanhtoan;

    @Column(name = "tongtien")
    private Double tongtien;
}
