package eu.aboutdev.microservice.dataservice.model;

import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document
@Builder
@lombok.Data
public class Data {

    @Id
    private String dataId;
    private String eventId;
    private Map<String, String> userSettings;
}
