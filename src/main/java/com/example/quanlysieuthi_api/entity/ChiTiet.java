package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "chitietdonhang")
public class ChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "madonhang", nullable = false, length = 50)
    private String madonhang;

    @Column(name = "masanpham", length = 50)
    private String masanpham;

    @Column(name = "tensanpham", length = 100)
    private String tensanpham;

    @Column(name = "soluong")
    private Integer soluong;

    @Column(name = "dongia")
    private Double dongia;

    @Column(name = "thanhtien")
    private Double thanhtien;
}
