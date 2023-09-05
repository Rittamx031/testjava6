package thatdz.test6.test6.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thatdz.test6.test6.model.entity.PhieuGiamGia;
import thatdz.test6.test6.model.request.PhieuGiamGiaRequest;
import thatdz.test6.test6.model.response.PhieuGiamGiaRepose;
import thatdz.test6.test6.service.KhachHangService;
import thatdz.test6.test6.service.PhieuGiamGiaService;

@RestController
@RequestMapping("api/phieugiamgia")
public class PhieuGiamGiaContoller {
  @Autowired
  PhieuGiamGiaService service;
  @Autowired
  KhachHangService khservice;

  @GetMapping("pageno/{page}")
  public ResponseEntity<List<PhieuGiamGiaRepose>> getPageNo(@PathVariable("page") int pageno) {
    return ResponseEntity.ok().body(service.getPageNo(pageno));
  }

  @PostMapping("add")
  public ResponseEntity<PhieuGiamGia> add(@RequestBody PhieuGiamGiaRequest request) {

    return ResponseEntity.ok().body(service.addPhieuGiamGia(request));
  }

  @PutMapping("add/{id}")
  public ResponseEntity<PhieuGiamGia> update(@PathVariable("id") String id, @RequestBody PhieuGiamGiaRequest request) {
    return ResponseEntity.ok().body(service.updatePhieuGiamGia(id, request));
  }
}
