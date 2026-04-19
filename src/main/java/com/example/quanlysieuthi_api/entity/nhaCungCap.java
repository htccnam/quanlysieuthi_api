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
@Table(name = "nhacungcap")
public class nhaCungCap {
    @Id
    @Column(name = "manhacungcap", nullable = false, length = 50)
    private String manhacungcap;

    @Column(name = "tennhacungcap", length = 100)
    private String tennhacungcap;

    @Column(name = "loaihinh", length = 50)
    private String loaihinh;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "sodienthoai", length = 20)
    private String sodienthoai;

    @Column(name = "diachi", length = 255)
    private String diachi;
}