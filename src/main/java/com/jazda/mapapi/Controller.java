package com.jazda.mapapi;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class Controller {

    @Autowired
    private RestTemplateBuilder builder;
    private RoutesRepository routesRepository;

    @GetMapping
    public ResponseEntity<String> cokolwiek() {
        // Wołamy API HERE ROUTE żeby otrzymać obiekt HereRoute
        // ResponseEntity<HereRoute> hereRoute = restTemplate.exchange(URL, HttpMethod.GET, body, HereRoute.class);
        RestTemplate restTemplate = builder.build();

        ResponseEntity<HereRoute> twoj_url = restTemplate.getForEntity("TWOJ URL", HereRoute.class);
        HereRoute hereRoute = new HereRoute();

        hereRoute.getRoutes().stream().forEach(route -> {
            List<EntityToSave> entityToSaveList = route.getSections().stream()
                    .map(Section::getSummary)
                    .map(Summary::getLength)
                    .map(length -> new EntityToSave(1, length)).collect(Collectors.toList());

            entityToSaveList.forEach(entityToSave -> routesRepository.save(entityToSave));
        });


        System.out.println("elo");
        return null;
    }
}
