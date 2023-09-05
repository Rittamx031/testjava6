package thatdz.test3.test3.model.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long MaKhachHang;
  private String TenKhachHang;
  private LocalDate SinhNhat;
  private String DiaChi;
  private String SoDienThoai;
  private String Email;
  private boolean GioiTinh;
  private String ChungMinhThu;
  private String SoCanCuoc;
  private String AnhDaiDien;
  private int TrangThai;
  private int DiemTichLuy;

}
