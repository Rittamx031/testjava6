package thatdz.test3.test3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import thatdz.test3.test3.model.entity.KhachHang;
import thatdz.test3.test3.repository.KhachHangRepository;

import java.util.List;
import java.util.Optional;

@Service
public class KhachHangService {

  // Declare the repository as final to ensure its immutability
  private final KhachHangRepository khachhangRepository;

  // Use constructor-based dependency injection
  @Autowired
  public KhachHangService(KhachHangRepository khachhangRepository) {
    this.khachhangRepository = khachhangRepository;
  }

  public List<KhachHang> getAllKhachHangs() {
    return khachhangRepository.findAll();
  }

  public List<KhachHang> getPageNo(int pageNo) {
    Pageable page = PageRequest.of(pageNo-1, 5);
    return khachhangRepository.findAll(page).getContent();
  }

  public Optional<KhachHang> getKhachHangById(long id) {
    return khachhangRepository.findById(id);
  }

  public KhachHang saveKhachHang(KhachHang khachhang) {
    return khachhangRepository.save(khachhang);
  }

  public void deleteKhachHang(long id) {
    khachhangRepository.deleteById(id);
  }
}
