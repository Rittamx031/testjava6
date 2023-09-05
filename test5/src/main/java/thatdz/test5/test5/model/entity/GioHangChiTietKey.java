package thatdz.test5.test5.model.entity;

import java.util.Objects;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * GioHangChiTietKey
 */
@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GioHangChiTietKey {
  @Column(name = "MaGioHang")
  UUID MaGioHang;

  @Column(name = "MaSanPham")
  int MaSanPham;

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof GioHangChiTietKey))
      return false;
    GioHangChiTietKey other = (GioHangChiTietKey) obj;
    return Objects.equals(MaGioHang, other.MaGioHang) && Objects.equals(MaSanPham, other.MaSanPham);
  }

  @Override
  public int hashCode() {
    return Objects.hash(MaGioHang, MaSanPham);
  }
}