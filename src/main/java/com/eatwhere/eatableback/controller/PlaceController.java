package com.eatwhere.eatableback.controller;

import com.eatwhere.eatableback.entity.Place;
import com.eatwhere.eatableback.repository.PlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // 이 클래스가 REST API 요청을 처리한다고 선언
@RequestMapping("/api/places") // 기본 URL 주소 설정
@RequiredArgsConstructor // Repository 주입을 위한 롬복 어노테이션
@CrossOrigin(origins = "http://localhost:5173")
public class PlaceController {

  private final PlaceRepository placeRepository;

  // GET /api/places?swLat=...&swLng=...&neLat=...&neLng=...
  @GetMapping
  public List<Place> getPlacesInBounds(
      @RequestParam Double swLat,
      @RequestParam Double swLng,
      @RequestParam Double neLat,
      @RequestParam Double neLng
  ) {
    // 프론트엔드에서 넘어온 영역(Bounds) 좌표를 이용해 DB에서 맛집 검색 후 반환
    return placeRepository.findByLatBetweenAndLngBetween(swLat, neLat, swLng, neLng);
  }
  @PostMapping
  public Place savePlace(@RequestBody Place place) {
    // JpaRepository의 save() 메서드 하나면 INSERT 쿼리가 자동으로 실행됩니다!
    return placeRepository.save(place);
  }
  @GetMapping("/all")
  public List<Place> getAllSavedPlaces() {
    return placeRepository.findAll();
  }
  @DeleteMapping("/{id}")
  public void deletePlace(@PathVariable Long id) {
    placeRepository.deleteById(id);
  }
}