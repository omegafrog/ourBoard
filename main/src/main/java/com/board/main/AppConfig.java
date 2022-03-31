package com.board.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemoryBoardRepository memoryBoardRepository() {
        return new MemoryBoardRepository();
    }
}
