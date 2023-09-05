package thatdz.test6.test6.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thatdz.test6.test6.model.entity.KhachHang;
import thatdz.test6.test6.model.response.KhachhangRepose;

public interface KhachHangRepository extends JpaRepository<KhachHang, Integer> {
  @Query(value = "SELECT MaKhachHang\r\n" + //
      ",TenKhachHang\r\n" + //
      ",SinhNhat\r\n" + //
      ",DiaChi\r\n" + //
      ",SoDienThoai\r\n" + //
      ",Email\r\n" + //
      ",GioiTinh\r\n" + //
      ",ChungMinhThu\r\n" + //
      ",SoCanCuoc\r\n" + //
      ",AnhDaiDien\r\n" + //
      ",DiemTichLuy\r\n" + // 
      ",TrangThai\r\n" + //
      "FROM KhachHang ", nativeQuery = true)
  Page<KhachhangRepose> getPageno(Pageable page);
}
