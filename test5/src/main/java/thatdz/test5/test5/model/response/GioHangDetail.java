package thatdz.test5.test5.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import thatdz.test5.test5.model.entity.GioHang;
import thatdz.test5.test5.model.entity.GioHangChiTiet;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GioHangDetail {
  GioHang gioHang;
  List<GioHangChiTiet> gioHangChiTiet;
}
