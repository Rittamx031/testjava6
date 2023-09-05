package thatdz.test5.test5.model.response;

import java.time.LocalDate;
import java.util.UUID;

public interface GioHangReponse {
  UUID getMaGioHang();

  LocalDate getNgayTao();

  LocalDate getNgayCapNhap();

  String getNguoiSoHuu();

  String getGhiChu();

  int getTrangThai();
}
