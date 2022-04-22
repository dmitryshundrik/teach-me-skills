package tms.lesson16;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println(objectMapper.writeValueAsString(new Bar(new Human("Bob", "28"),
                    new ArrayList<>(List.of(new Alcohol("Gin"), new Alcohol("Vodka"))),
                    "Madison St, 20")));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
