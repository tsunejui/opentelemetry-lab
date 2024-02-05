package com.rex.observability;

import java.util.Collections;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    Logger logger = LoggerFactory.getLogger(GreetingController.class);

    @GetMapping("/")
    public Map<String, Object> greeting() {
        logger.debug("This is a debug log");
        logger.error("This is a error log");
        return Collections.singletonMap("message", "Hello, World");
    }
}
