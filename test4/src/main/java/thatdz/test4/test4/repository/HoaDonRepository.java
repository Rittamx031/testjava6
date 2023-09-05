package thatdz.test4.test4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import thatdz.test4.test4.model.entity.HoaDon;

public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
  
}
