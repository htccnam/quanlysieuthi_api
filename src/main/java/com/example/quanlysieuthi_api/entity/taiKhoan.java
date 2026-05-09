package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "taikhoan")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class taiKhoan {
    @Id
    @Column(name = "taikhoan", length = 50)
    private String taikhoan;

    @Column(name = "matkhau", length = 255)
    private String matkhau;
}