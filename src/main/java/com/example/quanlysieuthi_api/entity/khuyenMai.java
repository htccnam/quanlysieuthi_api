package com.example.quanlysieuthi_api.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "khuyenmai")
public class khuyenMai {
    @Id
    @Column(name = "makhuyenmai" , length = 50)
    private String makhuyenmai;

    @Column(name = "tenkhuyenmai" , length = 50)
    private String tenkhuyenmai;

    @Column(name = "mota" ,length = 200)
    private String mota;

    @Column(name = "sotiengiam")
    private int sotiengiam;

    @Column(name = "ngaytao" )
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date ngaytao;
}
