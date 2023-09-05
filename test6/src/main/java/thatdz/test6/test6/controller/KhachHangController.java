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

import thatdz.test6.test6.model.entity.KhachHang;
import thatdz.test6.test6.model.request.KhachHangRequest;
import thatdz.test6.test6.model.response.KhachhangRepose;
import thatdz.test6.test6.service.KhachHangService;

@RestController
@RequestMapping("api/khachhang")
public class KhachHangController {
  @Autowired
  KhachHangService service;

  @GetMapping("pageno/{page}")
  public ResponseEntity<List<KhachhangRepose>> getPageNo(@PathVariable("page") int pageno) {
    return ResponseEntity.ok().body(service.getPageNo(pageno));
  }

  @PostMapping("add")
  public ResponseEntity<KhachHang> add(@RequestBody KhachHangRequest request) {
    return ResponseEntity.ok().body(service.addKhachHang(request));
  }

  @PutMapping("add/{id}")
  public ResponseEntity<KhachHang> update(@PathVariable("id") int id, @RequestBody KhachHangRequest request) {
    return ResponseEntity.ok().body(service.updateKhachHang(id, request));
  }
}
