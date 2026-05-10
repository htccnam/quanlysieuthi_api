package com.example.quanlysieuthi_api.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty("madonhang")
    private String madonhang;

    @JsonProperty("masanpham")
    private String masanpham;

    @JsonProperty("tensanpham")
    private String tensanpham;

    @JsonProperty("soluong")
    private Integer soluong;

    @JsonProperty("dongia")
    private Double dongia;

    @JsonProperty("thanhtien")
    private Double thanhtien;
}
