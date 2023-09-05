package thatdz.test4.test4.model.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhieuGiaoHang {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID MaPhieuGiao;
  private String NguoiNhan;
  private String SdtNhan;
  private String NguoiGiao;
  private String SdtGiao;
  private LocalDate NgayGiao;
  private LocalDate NgayNhan;
  private String NguoiTao;
  private double PhiGiaoHang;
  private String GhiChu;
  private int TrangThai;
  @ManyToOne
  @JoinColumn(name = "HoaDonGiao")
  private HoaDon HoaDonGiao;
  // private DiaChi DiaChiGiao;
}
