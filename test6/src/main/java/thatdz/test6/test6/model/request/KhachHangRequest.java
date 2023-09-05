package thatdz.test6.test6.model.request;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class KhachHangRequest {
  int MaKhachHang;

  String TenKhachHang;

  LocalDate SinhNhat;

  String DiaChi;

  String SoDienThoai;

  String Email;

  boolean GioiTinh;

  String ChungMinhThu;

  String SoCanCuoc;

  String AnhDaiDien;

  int TrangThai;

  int DiemTichLuy;
}
