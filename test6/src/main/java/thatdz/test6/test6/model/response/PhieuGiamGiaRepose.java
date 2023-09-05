package thatdz.test6.test6.model.response;

import java.time.LocalDate;
import java.util.UUID;

import thatdz.test6.test6.model.entity.KhachHang;

public interface PhieuGiamGiaRepose {
  String getMaPhieu();

  String getTenPhieu();

  LocalDate getNgayBatDau();

  LocalDate getNgayKetThuc();

  Double getGiaTriGiam();

  Double getGiaTriGiamToiDa();

  boolean getHinhThucGiam();

  int getTrangThai();

  String getNguoiSoHuu();
}
