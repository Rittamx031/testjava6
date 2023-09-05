package java6.test1.test1.entity;

import java.util.UUID;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Entity
@Table(name = "may_tinh")
public class MayTinh {
  @Id
  @UuidGenerator
  @Column(name = "ma", columnDefinition = "uniqueidentifier")
  private UUID id;

  @Column(name = "ten")
  private String ten;

  @Column(name = "gia")
  private float gia;
  @Column(name = "bo_nho")
  private String boNho;
  @Column(name = "mau_sac")
  private String mauSac;
  @Column(name = "hang")
  private String hang;
  @Column(name = "mieu_ta")
  private String mieuTa;

}
