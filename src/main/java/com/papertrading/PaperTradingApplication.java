package com.papertrading;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
public class PaperTradingApplication {
  public static final Logger logger = LoggerFactory.getLogger(PaperTradingApplication.class);
    public static void main(String[] args) {
        logger.info("Welcome to the Paper Trading Application!");
        SpringApplication.run(PaperTradingApplication.class, args);
    }
}
