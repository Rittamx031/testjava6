package java6.test1.test1.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java6.test1.test1.dto.MayTinhCustom;
import java6.test1.test1.entity.MayTinh;

public interface MayTinhRepository extends JpaRepository<MayTinh, UUID> {

  @Query(value = "select ma,ten,gia,bo_nho,mau_sac,hang,mieu_ta from may_tinh", nativeQuery = true)
  List<MayTinhCustom> getCusTomMayTinh();
}
