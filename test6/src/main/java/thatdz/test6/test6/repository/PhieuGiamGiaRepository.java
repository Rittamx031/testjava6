package thatdz.test6.test6.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thatdz.test6.test6.model.entity.PhieuGiamGia;
import thatdz.test6.test6.model.response.PhieuGiamGiaRepose;

public interface PhieuGiamGiaRepository extends JpaRepository<PhieuGiamGia, String> {
  @Query(value = "SELECT MaPhieu\r\n" + //
      "      ,TenPhieu\r\n" + //
      "      ,NgayBatDau\r\n" + //
      "      ,NgayKetThuc\r\n" + //
      "      ,GiaTriGiam\r\n" + //
      "      ,GiaTriGiamToiDa\r\n" + //
      "      ,HinhThucGiam\r\n" + //
      "      ,pgg.TrangThai,\r\n" + //
      "kh.TenKhachHang AS 'NguoiSoHuu' FROM\r\n" + //
      "PhieuGiamGia pgg JOIN\r\n" + //
      "KhachHang kh\r\n" + //
      "ON  pgg.NguoiSoHuu=kh.\r\n" + //
      "MaKhachHang\r\n" + //
      "", nativeQuery = true)
  Page<PhieuGiamGiaRepose> getPageno(Pageable page);
}
