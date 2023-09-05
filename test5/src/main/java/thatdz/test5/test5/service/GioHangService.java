package thatdz.test5.test5.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import thatdz.test5.test5.model.entity.GioHang;
import thatdz.test5.test5.model.entity.GioHangChiTiet;
import thatdz.test5.test5.model.response.GioHangDetail;
import thatdz.test5.test5.model.response.GioHangReponse;
import thatdz.test5.test5.repository.GioHangChiTietRepository;
import thatdz.test5.test5.repository.GioHangrepository;

@Service
@Transactional
public class GioHangService {
  @Autowired
  GioHangrepository repository;
  @Autowired
  GioHangChiTietRepository ghctrepository;

  public GioHangDetail getGioHangChiTiet(UUID id) {
    Optional<GioHang> optional = repository.findById(id);
    if (optional.isPresent()) {
      GioHang gioHang = optional.get();
      List<GioHangChiTiet> list = ghctrepository.getGioHangDetail(id);
      return new GioHangDetail(gioHang, list);
    } else {
      return null;
    }
  }

  public List<GioHang> getall() {
    return repository.findAll();
  }

  public List<GioHangReponse> getPageNo(int pageno) {
    return repository.getPageNo(PageRequest.of(pageno - 1, 5)).getContent();
  }

  public GioHang getOne(UUID id) {
    Optional<GioHang> optional = repository.findById(id);
    if (optional.isPresent()) {
      return optional.get();
    } else {
      return null;
    }
  }

  public GioHang addGioHang(GioHang gioHang) {
    return repository.save(gioHang);
  }

  public GioHang updateGioHang(UUID id, GioHang gioHang) {
    Optional<GioHang> optional = repository.findById(id);
    if (optional.isPresent()) {
      GioHang op = optional.get();
      op.setGhiChu(gioHang.getGhiChu());
      return repository.save(op);
    } else {
      return null;
    }
  }
}
