package thatdz.test4.test4.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import thatdz.test4.test4.model.dto.respone.PhieuGiaoHangResponse;
import thatdz.test4.test4.model.entity.PhieuGiaoHang;
import thatdz.test4.test4.repository.PhieuGiaoHangRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class PhieuGiaoHangService {

  // Declare the repository as final to ensure its immutability
  private final PhieuGiaoHangRepository phieugiaohangRepository;

  // Use constructor-based dependency injection
  @Autowired
  public PhieuGiaoHangService(PhieuGiaoHangRepository phieugiaohangRepository) {
    this.phieugiaohangRepository = phieugiaohangRepository;
  }

  public List<PhieuGiaoHang> getAllNhanVienInRangeLuong() {
    List<PhieuGiaoHang> list = phieugiaohangRepository.findAll();
    List<PhieuGiaoHang> listrs = list.stream().filter((pgh) -> {
      return (pgh.getPhiGiaoHang() >= 100000 && pgh.getPhiGiaoHang() <= 300000);
    }).collect(Collectors.toList());
    return null;
  }

  public PhieuGiaoHang getMax() {
    List<PhieuGiaoHang> list = phieugiaohangRepository.findAll();
    Optional<PhieuGiaoHang> optiom = list.stream().max(Comparator.comparing(PhieuGiaoHang::getPhiGiaoHang));
    return optiom.get();
  }

  public List<PhieuGiaoHang> getAllPhieuGiaoHangs() {
    return phieugiaohangRepository.findAll();
  }

  public List<PhieuGiaoHangResponse> getPageNo(int pageno) {
    return phieugiaohangRepository.getPageNo(PageRequest.of(pageno - 1, 5)).getContent();
  }

  public Optional<PhieuGiaoHang> getPhieuGiaoHangById(UUID id) {
    return phieugiaohangRepository.findById(id);
  }

  public PhieuGiaoHang savePhieuGiaoHang(PhieuGiaoHang phieugiaohang) {
    return phieugiaohangRepository.save(phieugiaohang);
  }

  public void deletePhieuGiaoHang(UUID id) {
    phieugiaohangRepository.deleteById(id);
  }
}

class getRangeLuong<E> implements Predicate<Integer> {
  @Override
  public boolean test(Integer v) {
    int min = 100000, max = 300000;
    return (v >= min && v <= max);
  }
}