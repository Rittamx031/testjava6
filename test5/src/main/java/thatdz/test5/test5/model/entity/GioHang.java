package thatdz.test5.test5.model.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHang")
@Entity
public class GioHang {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "MaGioHang")
  UUID MaGioHang;
  @Column(name = "NgayTao")
  LocalDate NgayTao;
  @Column(name = "NgayCapNhap")
  LocalDate NgayCapNhap;
  @Column(name = "NguoiSoHuu")
  int NguoiSoHuu;
  @Column(name = "GhiChu")
  String GhiChu;
  @Column(name = "TrangThai")
  int TrangThai;
}
