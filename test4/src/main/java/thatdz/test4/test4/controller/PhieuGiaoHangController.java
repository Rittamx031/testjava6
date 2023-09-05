package thatdz.test4.test4.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import thatdz.test4.test4.model.dto.respone.PhieuGiaoHangResponse;
import thatdz.test4.test4.model.entity.PhieuGiaoHang;
import thatdz.test4.test4.service.PhieuGiaoHangService;

@RestController
@RequestMapping("/api/phieugiaohang")
public class PhieuGiaoHangController {

  // Declare the service as final to ensure its immutability
  private final PhieuGiaoHangService phieugiaohangService;

  // Use constructor-based dependency injection
  @Autowired
  public PhieuGiaoHangController(PhieuGiaoHangService phieugiaohangService) {
    this.phieugiaohangService = phieugiaohangService;
  }

  @GetMapping
  public ResponseEntity<List<PhieuGiaoHang>> getAllPhieuGiaoHangs() {
    return ResponseEntity.ok(phieugiaohangService.getAllPhieuGiaoHangs());
  }

  @GetMapping("getPageNo/{pageno}")
  public ResponseEntity<List<PhieuGiaoHangResponse>> getPageNo(@PathVariable("pageno") int pageno) {
    return ResponseEntity.ok(phieugiaohangService.getPageNo(pageno));
  }

  @GetMapping("/{id}")
  public ResponseEntity<PhieuGiaoHang> getPhieuGiaoHangById(@PathVariable UUID id) {
    return phieugiaohangService.getPhieuGiaoHangById(id)
        .map(entity -> ResponseEntity.ok(entity))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<PhieuGiaoHang> createPhieuGiaoHang(@RequestBody PhieuGiaoHang phieugiaohang) {
    return ResponseEntity.ok(phieugiaohangService.savePhieuGiaoHang(phieugiaohang));
  }

  @PutMapping("update/{id}")
  public ResponseEntity<PhieuGiaoHang> updatePhieuGiaoHang(@PathVariable UUID id,
      @RequestBody PhieuGiaoHang phieugiaohang) {
    return ResponseEntity.ok(phieugiaohangService.savePhieuGiaoHang(phieugiaohang));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePhieuGiaoHang(@PathVariable UUID id) {
    phieugiaohangService.deletePhieuGiaoHang(id);
    return ResponseEntity.noContent().build();
  }
}
