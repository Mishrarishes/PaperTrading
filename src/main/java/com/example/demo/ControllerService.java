package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ControllerService {
  @GetMapping("/api/home")
  public String home(){
    return "Hello Rishes!";
  }

	@PostMapping("/api/home/data")
	public ResponseEntity<Map<String,String>> getData(@RequestBody Map<String,String> requestBody) {
		String value = requestBody.getOrDefault("value", "Guest");
		return ResponseEntity.ok(Map.of("value", value));
	}
}
