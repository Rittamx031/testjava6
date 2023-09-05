package thatdz.test5.test5.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thatdz.test5.test5.model.entity.GioHang;
import thatdz.test5.test5.model.response.GioHangReponse;

public interface GioHangrepository extends JpaRepository<GioHang, UUID> {
  @Query(value = "SELECT gh.MaGioHang , gh.NgayTao, gh.NgayCapNhap, kh.TenKhachHang AS 'NguoiSoHuu', gh.GhiChu , gh.TrangThai  FROM GioHang gh JOIN KhachHang kh on kh.MaKhachHang = gh.NguoiSoHuu;", nativeQuery = true)
  Page<GioHangReponse> getPageNo(Pageable page);
}
