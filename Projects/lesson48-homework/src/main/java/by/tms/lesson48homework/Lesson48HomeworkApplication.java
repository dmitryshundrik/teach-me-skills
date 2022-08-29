package by.tms.lesson48homework;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title = "Swagger Petstore",
        version = "1.0",
        description = "This is a sample server Petstore server.",
        license = @License(name = "Apache 2.0", url = ""),
        contact = @Contact(name = "Dmitry Shundrik", url = "", email = "dmitryshundrik@gmail.com")))
public class Lesson48HomeworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lesson48HomeworkApplication.class, args);
    }

}
