package com.ianczm.notion.food.infrastructure.notion;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ianczm.notion.food.domain.models.Food;
import com.ianczm.notion.food.domain.models.User;
import com.ianczm.notion.food.infrastructure.FoodRepository;
import com.ianczm.notion.food.infrastructure.UserRepository;
import com.ianczm.notion.food.infrastructure.notion.data.NotionResults;
import com.ianczm.notion.food.infrastructure.notion.data.pages.NotionPage;
import com.ianczm.notion.food.infrastructure.notion.data.pages.food.NotionFoodProperties;
import com.ianczm.notion.food.infrastructure.notion.data.users.NotionUser;
import com.ianczm.notion.food.utils.InfrastructureMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class NotionClient implements FoodRepository, UserRepository {

    private static final Logger logger = LoggerFactory.getLogger(NotionClient.class);

    @Autowired
    private ObjectMapper objectMapper;

    public static final String NOTION_VERSION_KEY = "Notion-Version";
    public static final String NOTION_VERSION_VALUE = "2022-06-28";
    private final WebClient client;
    private final String databaseId;

    public NotionClient(
            WebClient.Builder clientBuilder,
            @Value("${client.notion.baseurl}") String baseUrl,
            @Value("${client.notion.secret}") String secret,
            @Value("${client.notion.database}") String databaseId) {
        this.databaseId = databaseId;
        this.client = clientBuilder
                .baseUrl(baseUrl)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.AUTHORIZATION, "Bearer " + secret)
                .defaultHeader(NOTION_VERSION_KEY, NOTION_VERSION_VALUE)
                .build();
    }

    public Mono<List<User>> getUsers() {
        return this.client.get()
                .uri("/users")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<NotionResults<NotionUser>>() {})
                .map(NotionResults::getResults)
                .map(results -> results.stream()
                        .map(InfrastructureMapper::toModel).toList()
                );
    }

    public Mono<List<Food>> getFood() {
        return this.client.post()
                .uri("/databases/" + this.databaseId + "/query")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<NotionResults<NotionPage<NotionFoodProperties>>>() {})
                .map(NotionResults::getResults)
                .map(results -> results.stream().map(InfrastructureMapper::toModel).toList());
    }
}
