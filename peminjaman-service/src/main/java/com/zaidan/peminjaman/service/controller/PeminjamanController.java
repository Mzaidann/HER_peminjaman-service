/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaidan.peminjaman.service.controller;

import com.zaidan.peminjaman.service.VO.ResponseTemplateVO;
import com.zaidan.peminjaman.service.entity.Peminjaman;
import com.zaidan.peminjaman.service.service.PeminjamanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP ELITE BOOK G2
 */
@RestController
@RequestMapping("/peminjaman")
public class PeminjamanController {
  @Autowired
  private PeminjamanService peminjamanService;
  
  @PostMapping("/")
  public Peminjaman savePeminjaman(@RequestBody Peminjaman peminjaman) {
      return peminjamanService.savePeminjaman(peminjaman);
  }
  
  @GetMapping("id")
  public ResponseTemplateVO getPeminjaman(@PathVariable("id") Long peminjamanId) {
      return peminjamanService.getPeminjaman(peminjamanId);
  }
}