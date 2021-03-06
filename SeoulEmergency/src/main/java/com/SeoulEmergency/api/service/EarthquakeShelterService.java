package com.SeoulEmergency.api.service;


import com.SeoulEmergency.api.queryrepository.EarthquakeShelterRepository;
import com.SeoulEmergency.core.domain.EarthquakeShelter;
import com.SeoulEmergency.core.domain.EarthquakeShelterWithDistance;
import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EarthquakeShelterService {

    private final EarthquakeShelterRepository earthquakeShelterRepository;

    public List<EarthquakeShelterWithDistance> getNearEarthquakeShelters(Double longitude, Double latitude) {
        // 입력받은 경도, 위도 정보로 point 객체를 만들어 넘김.
        Point point = new Point(longitude, latitude);

        return earthquakeShelterRepository.findByLocationWithDistance(point);
    }
    public List<EarthquakeShelter> getnameSearchEarthquakeShelters(String title) {
        // 입력받은 이름으로 검색 ㄱ
        String Regtitle = ".*" + title + ".*";
        return earthquakeShelterRepository.findByNameRegex(Regtitle);
    }
    public List<EarthquakeShelter> getareaSearchEarthquakeShelters(String title) {
        // 입력받은 이름으로 검색 ㄱ
        String Regtitle = ".*" + title + ".*";
        return earthquakeShelterRepository.findByAddressRegex(Regtitle);
    }
}
