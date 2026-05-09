package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

@Data
@Entity
@Table(name = "lichsudoiqua")
public class LichSuDoiQua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "magiaodich")
    private Integer maGiaoDich;

    @Column(name = "makhachhang")
    private String maKH;

    @Column(name = "tenqua")
    private String tenQua;

    @Column(name = "diemtru")
    private Integer diemTru;

    @Column(name = "thoigian")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime thoiGian;
}