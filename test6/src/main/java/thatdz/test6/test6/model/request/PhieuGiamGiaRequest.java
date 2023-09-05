package thatdz.test6.test6.model.request;

import java.time.LocalDate;
import java.util.UUID;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PUBLIC)
public class PhieuGiamGiaRequest {

  UUID MaPhieu;
  String TenPhieu;
  LocalDate NgayBatDau;
  LocalDate NgayKetThuc;
  Double GiaTriGiam;
  Double GiaTriGiamToiDa;
  boolean HinhThucGiam;
  int TrangThai;
  int NguoiSoHuu;
}
