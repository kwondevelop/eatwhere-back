package com.eatwhere.eatableback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // 이 클래스가 MySQL의 테이블이 될 것이라고 선언
@Table(name = "places") // 실제 생성될 테이블 이름
@Getter
@Setter
@NoArgsConstructor // 파라미터가 없는 기본 생성자를 자동으로 만들어줌 (JPA 필수)
public class Place {

  @Id // 이 필드를 테이블의 기본키(Primary Key)로 설정
  @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT (1, 2, 3... 자동 증가)
  private Long id;

  @Column(nullable = false, length = 100) // null 허용 안 함, 최대 100자
  private String name;

  @Column(nullable = false)
  private Double lat; // 위도

  @Column(nullable = false)
  private Double lng; // 경도

  @Column(length = 200)
  private String address;

  @Column(length = 500)
  private String placeUrl;
}