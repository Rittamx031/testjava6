package thatdz.test4.test4.model.dto.respone;

import java.util.UUID;

public interface PhieuGiaoHangResponse {
  // Mã Phiếu Giao, Người Nhận, SĐT Người Nhận, Phí Giao Hàng, Người Lập, Hoá đơn
  // ghi chú)
  UUID getMaPhieuGiao();

  String getNguoiNhan();

  String getSdtNguoiNhan();

  double getPhiGiaoHang();

  String getNguoiLap();

  Long getHoaDon();

  String getGhiChu();

}
