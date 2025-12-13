
package com.example.demo;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class testController {
    @GetMapping("/greeting")
    public HashMap<String, String> greeting(@RequestParam (defaultValue = "World") String name){
        HashMap<String, String> response = new HashMap<>();
        response.put("id", "1");
        response.put("content", "Hello" + " " +  name);
        return response;
    }
}
