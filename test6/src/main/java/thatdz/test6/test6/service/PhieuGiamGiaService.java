package thatdz.test6.test6.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import thatdz.test6.test6.model.entity.PhieuGiamGia;
import thatdz.test6.test6.model.request.PhieuGiamGiaRequest;
import thatdz.test6.test6.model.response.PhieuGiamGiaRepose;
import thatdz.test6.test6.model.response.PhieuGiamGiaRepose;
import thatdz.test6.test6.repository.PhieuGiamGiaRepository;
import thatdz.test6.test6.repository.PhieuGiamGiaRepository;

@Service
public class PhieuGiamGiaService {
  @Autowired
  PhieuGiamGiaRepository repository;

  public List<PhieuGiamGiaRepose> getPageNo(int page) {
    return repository.getPageno(PageRequest.of(page - 1, 5)).getContent();
  }

  public PhieuGiamGia addPhieuGiamGia(PhieuGiamGiaRequest request) {
    return repository.save(new PhieuGiamGia(request));
  }

  public PhieuGiamGia getPhieuGiamGiaById(String id) {
    Optional<PhieuGiamGia> PhieuGiamGia = repository.findById(id);
    if (PhieuGiamGia.isPresent()) {
      return PhieuGiamGia.get();
    }
    throw new ResponseStatusException(404, "M khong biet chon id a", null);
  }

  public PhieuGiamGia updatePhieuGiamGia(String id, PhieuGiamGiaRequest request) {
    PhieuGiamGia PhieuGiamGiaps = this.getPhieuGiamGiaById(id);
    return repository.save(PhieuGiamGiaps);
  }
}
