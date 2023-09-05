package thatdz.test4.test4.model.entity;

import java.time.LocalDate;

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
@Entity
@Table(name = "HoaDon")
public class HoaDon {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MaHoaDon")
  Long MaHoaDon;
  @Column(name = "NgayLap")
  LocalDate NgayLap;
  @Column(name = "NguoiLap")
  LocalDate NguoiLap;
  @Column(name = "GhiChu")
  String GhiChu;
  @Column(name = "NgayThanhToan")
  LocalDate NgayThanhToan;
  @Column(name = "TrangThai")
  int TrangThai;
  @Column(name = "NguoiMua")
  String NguoiMua;
}
