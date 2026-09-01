package com.eatwhere.eatableback.repository;

import com.eatwhere.eatableback.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// JpaRepository<다룰_엔티티, 기본키_타입> 을 상속받습니다.
public interface PlaceRepository extends JpaRepository<Place, Long> {

  // 💡 [핵심] JPA의 쿼리 메서드 기능! 이름만 잘 지어주면 알아서 조건에 맞는 쿼리를 짜줍니다.
  // "위도(lat)가 swLat ~ neLat 사이이고, 경도(lng)가 swLng ~ neLng 사이인 장소들을 찾아줘"
  List<Place> findByLatBetweenAndLngBetween(Double swLat, Double neLat, Double swLng, Double neLng);
}