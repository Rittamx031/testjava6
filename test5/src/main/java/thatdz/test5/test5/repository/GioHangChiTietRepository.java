package thatdz.test5.test5.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import thatdz.test5.test5.model.entity.GioHangChiTiet;
import thatdz.test5.test5.model.entity.GioHangChiTietKey;

/**
 * GioHangChiTietRepository
 */
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, GioHangChiTietKey> {
  @Query(value = "SELECT ghct FROM GioHangChiTiet ghct WHERE ghct.id.MaGioHang = :idGioHang")
  List<GioHangChiTiet> getGioHangDetail(@Param("idGioHang") UUID idGioHang);
}