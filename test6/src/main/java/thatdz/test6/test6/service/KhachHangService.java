package thatdz.test6.test6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import thatdz.test6.test6.model.entity.KhachHang;
import thatdz.test6.test6.model.request.KhachHangRequest;
import thatdz.test6.test6.model.response.KhachhangRepose;
import thatdz.test6.test6.repository.KhachHangRepository;

@Service
public class KhachHangService {
  @Autowired
  KhachHangRepository repository;

  public List<KhachhangRepose> getPageNo(int page) {
    return repository.getPageno(PageRequest.of(page - 1, 5)).getContent();
  }

  public KhachHang addKhachHang(KhachHangRequest request) {
    return repository.save(new KhachHang(request));
  }

  public KhachHang getKhachHangById(int id) {
    Optional<KhachHang> khachHang = repository.findById(id);
    if (khachHang.isPresent()) {
      return khachHang.get();
    }
    throw new ResponseStatusException(404, "M khong biet chon id a", null);
  }

  public KhachHang updateKhachHang(int id, KhachHangRequest request) {
    KhachHang khachHangps = this.getKhachHangById(id);
    khachHangps.setAnhDaiDien(request.AnhDaiDien);
    return repository.save(khachHangps);
  }
}
