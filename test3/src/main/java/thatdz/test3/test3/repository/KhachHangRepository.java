package thatdz.test3.test3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.test3.test3.model.entity.KhachHang;

public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
}
