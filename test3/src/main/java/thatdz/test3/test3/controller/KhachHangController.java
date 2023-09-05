package thatdz.test3.test3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import thatdz.test3.test3.model.entity.KhachHang;
import thatdz.test3.test3.service.KhachHangService;

import java.util.List;

@RestController
@RequestMapping("/api/khachhang")
public class KhachHangController {

  // Declare the service as final to ensure its immutability
  private final KhachHangService khachhangService;

  // Use constructor-based dependency injection
  @Autowired
  public KhachHangController(KhachHangService khachhangService) {
    this.khachhangService = khachhangService;
  }

  @GetMapping
  public ResponseEntity<List<KhachHang>> getAllKhachHangs() {
    return ResponseEntity.ok(khachhangService.getAllKhachHangs());
  }

  @GetMapping("page/{pageno}")
  public ResponseEntity<List<KhachHang>> getPage(@PathVariable("pageno") int pageno) {
    return ResponseEntity.ok(khachhangService.getPageNo(pageno));
  }

  @GetMapping("/{id}")
  public ResponseEntity<KhachHang> getKhachHangById(@PathVariable long id) {
    return khachhangService.getKhachHangById(id)
        .map(entity -> ResponseEntity.ok(entity))
        .orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<KhachHang> createKhachHang(@RequestBody KhachHang khachhang) {
    return ResponseEntity.ok(khachhangService.saveKhachHang(khachhang));
  }

  @PutMapping("/{id}")
  public ResponseEntity<KhachHang> updateKhachHang(@PathVariable long id, @RequestBody KhachHang khachhang) {
    return ResponseEntity.ok(khachhangService.saveKhachHang(khachhang));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteKhachHang(@PathVariable long id) {
    khachhangService.deleteKhachHang(id);
    return ResponseEntity.noContent().build();
  }
}
