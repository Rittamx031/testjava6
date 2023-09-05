package thatdz.test6.test6.model.entity;

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
import thatdz.test6.test6.model.request.KhachHangRequest;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "KhachHang")
public class KhachHang {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "MaKhachHang")
  int MaKhachHang;
  @Column(name = "TenKhachHang")
  String TenKhachHang;
  @Column(name = "SinhNhat")
  LocalDate SinhNhat;
  @Column(name = "DiaChi")
  String DiaChi;
  @Column(name = "SoDienThoai")
  String SoDienThoai;
  @Column(name = "Email")
  String Email;
  @Column(name = "GioiTinh")
  boolean GioiTinh;
  @Column(name = "ChungMinhThu")
  String ChungMinhThu;
  @Column(name = "SoCanCuoc")
  String SoCanCuoc;
  @Column(name = "AnhDaiDien")
  String AnhDaiDien;
  @Column(name = "TrangThai")
  int TrangThai;
  @Column(name = "DiemTichLuy")
  int DiemTichLuy;

  public KhachHang(KhachHangRequest request) {
    this.MaKhachHang = request.MaKhachHang;

    this.TenKhachHang = request.TenKhachHang;

    this.SinhNhat = request.SinhNhat;

    this.DiaChi = request.DiaChi;

    this.SoDienThoai = request.SoDienThoai;

    this.Email = request.Email;

    this.GioiTinh = request.GioiTinh;

    this.ChungMinhThu = request.ChungMinhThu;

    this.SoCanCuoc = request.SoCanCuoc;

    this.AnhDaiDien = request.AnhDaiDien;

    this.TrangThai = request.TrangThai;

    this.DiemTichLuy = request.DiemTichLuy;
  }
  // @Column(name = "HangKhachHang")
  // String HangKhachHang;
  // @Column(name = "NguoiGioiThieu")
  // String NguoiGioiThieu;
}
