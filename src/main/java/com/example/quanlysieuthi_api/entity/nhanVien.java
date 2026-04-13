package com.example.quanlysieuthi_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "nhanvien")
public class nhanVien {
    @Id
    @Column(name= "manhanvien" , nullable = false ,length = 50)
    private String manhanvien;

    @Column(name = "tennhanvien" ,nullable = true,length = 50)
    private String tennhanvien;

    @Column(name = "ngaysinh" , nullable = true )
    private Date ngaysinh;

    @Column(name = "gioitinh" , nullable = true , length = 10)
    private  String gioitinh;

    @Column(name = "sodienthoai" , nullable = true, length = 50)
    private String sodienthoai;

    @Column(name = "email" , nullable = true, length = 50)
    private String email;

    @Column(name = "diachi" , nullable = true, length = 255)
    private String diachi;

    @Column(name = "machucvu" , nullable = true, length = 50)
    private String machucvu;


}
