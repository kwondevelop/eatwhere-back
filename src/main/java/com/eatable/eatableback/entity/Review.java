package com.eatable.eatableback.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "reviews")
@Getter
@Setter
@NoArgsConstructor
public class Review {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private Integer rating; // 평점 (1~5)

  @Column(nullable = false, length = 1000)
  private String content; // 리뷰 내용

  @Column(length = 500)
  private String imageUrl; // 사진(로컬/S3) 경로

  @Column(nullable = false, updatable = false)
  private LocalDateTime createdAt = LocalDateTime.now(); // 작성 시간

  // N:1 관계 설정 (여러 개의 리뷰는 하나의 장소에 속함)
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "place_id", nullable = false) // 테이블에 place_id 라는 외래키(FK) 컬럼 생성
  private Place place;
}