package thatdz.test5.test5.model.entity;

import java.util.UUID;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "GioHangChiTiet")
@Entity
public class GioHangChiTiet {
  @EmbeddedId
  GioHangChiTietKey id;
  @Column(name = "SoLuong")
  int SoLuong;
  @Column(name = "GhiChu")
  String GhiChu;
  @Column(name = "TrangThai")
  int TrangThai;
}
