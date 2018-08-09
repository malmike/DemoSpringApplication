package com.example.demo;

import com.example.demo.models.Book;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;

import static org.apache.commons.lang.RandomStringUtils.randomAlphabetic;



@SpringBootTest(classes = DemoApplication.class, webEnvironment = WebEnvironment.DEFINED_PORT)
public class BaseTest {
    protected static final String API_ROOT = "http://localhost:8081/demo_api";

    protected Book createRandomBook(){
        Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    protected String createBookAsUri(Book book){
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT + "/api/book");
        book.setUuid(response.jsonPath().get("uuid").toString());
        return API_ROOT + "/api/book/" + response.jsonPath().get("uuid");
    }
}
