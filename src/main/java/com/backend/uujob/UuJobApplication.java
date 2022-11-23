package com.backend.uujob;

import com.backend.uujob.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//代表返回的是json格式的数据
@RestController
@SpringBootApplication
public class UuJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(UuJobApplication.class, args);
    }
}
