package com.example.quanlysieuthi_api.controller;

import com.example.quanlysieuthi_api.entity.chucVu;
import com.example.quanlysieuthi_api.Service.chucVuService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/chucvu")
public class chucVuController {
    private final chucVuService chucVuService;
    @GetMapping
    public List<chucVu> getAllChucVu(){
        return chucVuService.getAllChucVu();
    }

    @PostMapping
    public ResponseEntity<?> themchucvu(@RequestBody chucVu cv){
        try{
            return ResponseEntity.ok(chucVuService.addChucVu(cv));
        }
        catch (Exception e){
            throw new RuntimeException();
        }
    }

    @PutMapping
    public ResponseEntity<?> suachucvu(@PathVariable String machucvu , @RequestBody chucVu cv){
        return ResponseEntity.ok(chucVuService.updateChucVu(machucvu,cv));
    }

    @GetMapping("/search")
    public List<chucVu> searchChucVu(@RequestParam String keyword){
        return chucVuService.seachChucVu(keyword,keyword);
    }
}
