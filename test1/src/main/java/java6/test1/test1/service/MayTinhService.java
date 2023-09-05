package java6.test1.test1.service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java6.test1.test1.dto.MayTinhCustom;
import java6.test1.test1.entity.MayTinh;
import java6.test1.test1.repository.MayTinhRepository;

@Service
public class MayTinhService {
  @Autowired
  public MayTinhRepository repository;

  public List<MayTinhCustom> getAll() {
    return repository.getCusTomMayTinh();
  }

  public MayTinh createMayTinh(MayTinh mayTinh) {
    return repository.save(mayTinh);
  }

  public MayTinh getMayTinh(UUID id) {
    Optional<MayTinh> mayTinh = repository.findById(id);
    if (mayTinh.isPresent()) {
      return mayTinh.get();
    } else {
      return null;
    }
  }

  public MayTinh updateMayTinh(MayTinh mayTinh) {
    Optional<MayTinh> mayTinhpd = repository.findById(mayTinh.getId());
    if (mayTinhpd.isPresent()) {
      MayTinh mayTinhud = mayTinhpd.get();
      mayTinhud.setId(mayTinh.getId());
      mayTinhud.setGia(mayTinh.getGia());
      mayTinhud.setBoNho(mayTinh.getBoNho());
      mayTinhud.setMauSac(mayTinh.getMauSac());
      mayTinhud.setMieuTa(mayTinh.getMieuTa());
      mayTinhud.setTen(mayTinh.getTen());
      repository.save(mayTinhud);
      return mayTinhud;
    } else {
      return null;
    }
  }

  public boolean deleteMayTinh(UUID id) {
    Optional<MayTinh> mayTinh = repository.findById(id);
    if (mayTinh.isPresent()) {
      repository.delete(mayTinh.get());
      return true;
    } else {
      return false;
    }
  }

  public List<MayTinh> getListByRangeLuong() {
    List<MayTinh> list = repository.findAll();
    return list.stream().filter((maytinh) -> (maytinh.getGia() > 1000000 && maytinh.getGia() < 2000000))
        .collect(Collectors.toList());
  }

  public MayTinh getMayTinhMaxLuong() {
    List<MayTinh> list = repository.findAll();
    MayTinh maxgia = list.stream().max(Comparator.comparingDouble(MayTinh::getGia)).get();
    return maxgia;
  }

  public long getTongMayTinhDell() {
    List<MayTinh> list = repository.findAll();

    long soluongdell = list.stream().filter((maytinh) -> maytinh.getHang().equals("DELL")).count();

    return soluongdell;
  }
}
