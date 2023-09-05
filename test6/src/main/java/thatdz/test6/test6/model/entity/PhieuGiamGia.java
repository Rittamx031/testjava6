package thatdz.test6.test6.model.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import thatdz.test6.test6.model.request.PhieuGiamGiaRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PhieuGiamGia")
public class PhieuGiamGia {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "MaPhieu")
  UUID MaPhieu;
  @Column(name = "TenPhieu")
  String TenPhieu;
  @Column(name = "NgayBatDau")
  LocalDate NgayBatDau;
  @Column(name = "NgayKetThuc")
  LocalDate NgayKetThuc;
  @Column(name = "GiaTriGiam")
  Double GiaTriGiam;
  @Column(name = "GiaTriGiamToiDa")
  Double GiaTriGiamToiDa;
  @Column(name = "HinhThucGiam")
  boolean HinhThucGiam;
  @Column(name = "TrangThai")
  int TrangThai;
  @ManyToOne
  @JoinColumn(name = "NguoiSoHuu")
  KhachHang NguoiSoHuu;

  public PhieuGiamGia(PhieuGiamGiaRequest request) {
    this.MaPhieu = request.MaPhieu;
    this.TenPhieu = request.TenPhieu;
    this.NgayBatDau = request.NgayBatDau;
    this.NgayKetThuc = request.NgayKetThuc;
    this.GiaTriGiam = request.GiaTriGiam;
    this.GiaTriGiamToiDa = request.GiaTriGiamToiDa;
    this.HinhThucGiam = request.HinhThucGiam;
    this.TrangThai = request.TrangThai;
  }
}
