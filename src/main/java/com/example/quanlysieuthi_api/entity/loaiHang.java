package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "loaihang")
public class loaiHang {
    @Id
    @Column(name = "maloai", nullable = false, length = 50)
    private String maloai;

    @Column(name = "tenloai", length = 100)
    private String tenloai;
}