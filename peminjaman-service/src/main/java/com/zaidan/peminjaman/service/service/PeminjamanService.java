/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.zaidan.peminjaman.service.service;

import com.zaidan.peminjaman.service.VO.Anggota;
import com.zaidan.peminjaman.service.VO.Buku;
import com.zaidan.peminjaman.service.VO.ResponseTemplateVO;
import com.zaidan.peminjaman.service.entity.Peminjaman;
import com.zaidan.peminjaman.service.repository.PeminjamanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author HP ELITE BOOK G2
 */
@Service
public class PeminjamanService {
    @Autowired
    private PeminjamanRepository peminjamanRepository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Peminjaman savePeminjaman(Peminjaman peminjaman){
        return peminjamanRepository.save(peminjaman);
    }
    
    public ResponseTemplateVO getPeminjaman(Long peminjamanId){
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Peminjaman peminjaman = 
                peminjamanRepository.findByPeminjamanId(peminjamanId);
        
        Anggota anggota = 
        restTemplate.getForObject("http://localhost:9001/anggota"
                + peminjaman.getAnggotaId(), Anggota.class);
        
        Buku buku = 
        restTemplate.getForObject("http://localhost:9003/buku/"
                + peminjaman.getBukuId(), Buku.class);
        vo.setPeminjaman(peminjaman);
        vo.setAnggota(anggota);
        vo.setBuku(buku);
        return vo;
    }
}