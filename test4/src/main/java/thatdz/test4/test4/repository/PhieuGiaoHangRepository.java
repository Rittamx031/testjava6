package thatdz.test4.test4.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import thatdz.test4.test4.model.dto.respone.PhieuGiaoHangResponse;
import thatdz.test4.test4.model.entity.PhieuGiaoHang;

public interface PhieuGiaoHangRepository extends JpaRepository<PhieuGiaoHang, UUID> {
  @Query(value = "SELECT  pg.MaPhieuGiao,  pg.NguoiNhan,  pg.SdtNhan AS 'SdtNguoiNhan',  pg.phiGiaoHang,  hd.nguoiLap,hd.MaHoaDon as 'HoaDon',  hd.ghiChu AS 'GhiChu' FROM  PhieuGiaoHang pg JOIN  HoaDon hd ON pg.hoaDonGiao = hd.maHoaDon ORDER BY  pg.maPhieuGiao ", nativeQuery = true)
  Page<PhieuGiaoHangResponse> getPageNo(Pageable page);
}
