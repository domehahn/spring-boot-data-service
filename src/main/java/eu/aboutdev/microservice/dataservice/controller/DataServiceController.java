package eu.aboutdev.microservice.dataservice.controller;

import eu.aboutdev.microservice.dataservice.model.Data;
import eu.aboutdev.microservice.dataservice.repository.DataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DataServiceController {

    private final DataRepository dataRepository;

    @Cacheable(value = "events", key = "#eventId")
    @GetMapping("/data/{eventId}")
    public List<String> findByCustomerId(@PathVariable("eventId") Long eventId) {
        log.info("EventId in: {}", eventId);
        final Data data = Data.builder()
                .eventId(UUID.randomUUID().toString())
                .build();
        final Data save = dataRepository.save(data);
        log.info("EventId out: {}", save.getEventId());
        return List.of(save.getEventId());
    }
}
