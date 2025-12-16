package com.devsuperior.dsmovie.controllers;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.devsuperior.dsmovie.tests.TokenUtil;

import io.restassured.http.ContentType;

public class ScoreControllerRA {
	
	private String clientUsername, clientPassword, adminUsername, adminPassword;
	private String clientToken, adminToken;
	private Map<String, Object> postScoreInstance;
	
	@BeforeEach
	private void setUp() throws Exception {
		baseURI = "http://localhost:8080";
		
		clientUsername = "joao@gmail.com";
		clientPassword = "123456";
		adminUsername = "maria@gmail.com";
		adminPassword = "123456";
		
		clientToken = TokenUtil.obtainAccessToken(clientUsername, clientPassword);
		adminToken = TokenUtil.obtainAccessToken(adminUsername, adminPassword);
		
		postScoreInstance = new HashMap<>();
		postScoreInstance.put("movieId", 1);
		postScoreInstance.put("score", 4);

	}
	
	@Test
	public void saveScoreShouldReturnNotFoundWhenMovieIdDoesNotExist() throws Exception {
		postScoreInstance.put("movieId", 100);
		JSONObject newScore = new JSONObject(postScoreInstance);
		
		given()
			.header("Content-type", "application/json")
			.header("Authorization", "Bearer " + adminToken)
			.body(newScore)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.put("/scores")
		.then()
			.statusCode(404);
	}
	
	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenMissingMovieId() throws Exception {
		postScoreInstance.put("movieId", "");
		JSONObject newScore = new JSONObject(postScoreInstance);
		
		given()
			.header("Content-type", "application/json")
			.header("Authorization", "Bearer " + adminToken)
			.body(newScore)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.put("/scores")
		.then()
			.statusCode(422);
	}
	
	@Test
	public void saveScoreShouldReturnUnprocessableEntityWhenScoreIsLessThanZero() throws Exception {	
		postScoreInstance.put("score", -4);
		JSONObject newScore = new JSONObject(postScoreInstance);
		
		given()
			.header("Content-type", "application/json")
			.header("Authorization", "Bearer " + clientToken)
			.body(newScore)
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
		.when()
			.put("/scores")
		.then()
			.statusCode(422);
	}
}
