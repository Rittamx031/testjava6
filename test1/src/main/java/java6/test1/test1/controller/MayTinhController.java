package java6.test1.test1.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java6.test1.test1.dto.MayTinhCustom;
import java6.test1.test1.entity.MayTinh;
import java6.test1.test1.service.MayTinhService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("api/may-tinh")
public class MayTinhController {
  @Autowired
  MayTinhService service;

  @GetMapping
  public ResponseEntity<List<MayTinhCustom>> getAll() {
    return ResponseEntity.ok().body(service.getAll());
  }

  @PutMapping
  public ResponseEntity<MayTinh> putMethodName(@RequestBody MayTinh entity) {
    // TODO: process PUT request
    return ResponseEntity.ok().body(service.updateMayTinh(entity));
  }

  @PostMapping
  public ResponseEntity<MayTinh> createMaTinh(@RequestBody MayTinh entity) {
    // TODO: process PUT request
    return ResponseEntity.ok().body(service.createMayTinh(entity));
  }

  @DeleteMapping("{id}")
  public HttpStatus deleteMayTinh(@PathVariable(name = "id") UUID id) {
    if (service.deleteMayTinh(id)) {
      return HttpStatus.OK;
    } else {
      return HttpStatus.BAD_REQUEST;
    }
  }

  @GetMapping("{id}")
  public ResponseEntity<MayTinh> getMayTinh(@PathVariable(name = "id") UUID id) {
    return ResponseEntity.ok().body(service.getMayTinh(id));
  }

  @GetMapping("getListLuong")
  public ResponseEntity<List<MayTinh>> getList() {
    return ResponseEntity.ok().body(service.getListByRangeLuong());
  }

  @GetMapping("getMax")
  public ResponseEntity<MayTinh> getmaxEntity() {
    return ResponseEntity.ok().body(service.getMayTinhMaxLuong());
  }

  @GetMapping("getSlDell")
  public Long getSoMayDell() {
    return service.getTongMayTinhDell();
  }
}
