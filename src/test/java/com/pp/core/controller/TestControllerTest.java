package com.pp.core.controller;

import static io.restassured.http.ContentType.JSON;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;
import static org.springframework.http.HttpStatus.OK;

import com.pp.core.controller.testclasses.controller.dto.TestDto;
import com.pp.core.controller.testclasses.controller.dto.UpdateTestDto;
import com.pp.core.controller.testclasses.dao.entity.TestEntity;
import com.pp.core.controller.testclasses.dao.repository.TestRepository;
import io.restassured.RestAssured;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(webEnvironment = RANDOM_PORT)
class TestControllerTest {

  @LocalServerPort
  private int port;
  @Autowired
  private TestRepository testRepository;

  private static TestEntity getTestEntity() {
    TestEntity entity = new TestEntity();
    entity.setName("test");
    return entity;
  }

  @BeforeEach
  void setUp() {
    testRepository.deleteAll();
  }

  @Test
  void shouldCreateTestResource() {
    String name = "test";
    TestDto request = new TestDto();
    request.setName(name);

    TestDto testDto = RestAssured.given()
                                 .port(port)
                                 .accept(JSON)
                                 .contentType(JSON)
                                 .body(request)
                                 .when()
                                 .post("/test")
                                 .then()
                                 .statusCode(CREATED.value())
                                 .extract()
                                 .as(TestDto.class);

    assertThat(testDto).isNotNull();
    assertThat(testDto.getName()).isEqualTo(name);
  }

  @Test
  void shouldGetTestResourceById() {
    TestEntity savedEntity = saveTestEntity();

    TestDto testDto = RestAssured.given()
                                 .port(port)
                                 .accept(JSON)
                                 .contentType(JSON)
                                 .when()
                                 .get("/test/" + savedEntity.getId())
                                 .then()
                                 .statusCode(OK.value())
                                 .extract()
                                 .as(TestDto.class);

    assertThat(testDto).isNotNull();
    assertThat(testDto.getName()).isEqualTo(savedEntity.getName());
  }

  @Test
  void shouldDeleteTestResourceById() {
    TestEntity savedEntity = saveTestEntity();

    RestAssured.given()
               .port(port)
               .accept(JSON)
               .contentType(JSON)
               .when()
               .delete("/test/" + savedEntity.getId())
               .then()
               .statusCode(NO_CONTENT.value());

    List<TestEntity> testEntities = testRepository.findAll();
    assertThat(testEntities).isEmpty();
  }

  @Test
  void shouldUpdateTestResourceById() {
    TestEntity savedEntity = saveTestEntity();

    UpdateTestDto request = new UpdateTestDto();
    request.setName("updated");

    RestAssured.given()
               .port(port)
               .accept(JSON)
               .contentType(JSON)
               .body(request)
               .when()
               .put("/test/" + savedEntity.getId())
               .then()
               .statusCode(OK.value());

    List<TestEntity> testEntities = testRepository.findAll();
    assertThat(testEntities).hasSize(1);
    assertThat(testEntities.getFirst().getName()).isEqualTo(request.getName());
  }

  private TestEntity saveTestEntity() {
    TestEntity entity = getTestEntity();
    return testRepository.save(entity);
  }

  @Configuration
  @ComponentScan("com.pp.core")
  public static class SpringConfig {

  }
}