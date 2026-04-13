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
@Table(name = "chucvu")
public class chucVu {
    @Id
    @Column(name = "machucvu",nullable = false ,length = 50)
    private String machucvu;

    @Column(name = "tenchucvu", length = 50)
    private String tenchucvu;
}
