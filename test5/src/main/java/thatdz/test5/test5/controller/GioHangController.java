package thatdz.test5.test5.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import thatdz.test5.test5.model.entity.GioHang;
import thatdz.test5.test5.model.response.GioHangDetail;
import thatdz.test5.test5.model.response.GioHangReponse;
import thatdz.test5.test5.service.GioHangService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("api/giohang")
public class GioHangController {
  @Autowired
  GioHangService service;

  // ResponseEntity<
  @GetMapping()
  public ResponseEntity<List<GioHang>> getAll() {
    return ResponseEntity.ok().body(service.getall());
  }

  @GetMapping("giohangdetail/{id}")
  public ResponseEntity<GioHangDetail> getAll(@PathVariable("id") UUID idGioHang) {
    return ResponseEntity.ok().body(service.getGioHangChiTiet(idGioHang));
  }

  @GetMapping("pageno/{pageno}")
  public ResponseEntity<List<GioHangReponse>> getPageNo(@PathVariable("pageno") int pageno) {
    return ResponseEntity.ok().body(service.getPageNo(pageno));
  }

  @PostMapping(value = "add")
  public ResponseEntity<GioHang> addNewGioHang(@RequestBody GioHang entity) {
    // TODO: process POST request

    return ResponseEntity.ok().body(service.addGioHang(entity));
  }

  @PutMapping(value = "update/{id}")
  public ResponseEntity<GioHang> updateGioHang(@PathVariable("id") UUID id, @RequestBody GioHang entity) {
    // TODO: process POST request

    return ResponseEntity.ok().body(service.updateGioHang(id, entity));
  }
}
