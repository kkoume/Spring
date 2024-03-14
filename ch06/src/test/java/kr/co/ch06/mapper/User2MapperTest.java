package kr.co.ch06.mapper;

import kr.co.ch06.dto.User2DTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User2MapperTest {

    @Autowired
    private User2Mapper mapper;


    @DisplayName("user2 등록")
    void insertUser2() {
        log.info("insertUser2...");

        User2DTO user2DTO = User2DTO.builder()
                                    .uid("A107")
                                    .name("테스트")
                                    .birth("1991-05-17")
                                    .addr("부산시 금정구")
                                    .build();
    }

    @DisplayName("user2 조회")
    void selectUser2() {
        log.info("selectUser2...");
    }

    @DisplayName("user2 목록")
    void selectUser2s() {
        log.info("selectUser2s...");
    }

    @DisplayName("user2 수정")
    void updateUser2() {
        log.info("updateUser2...");
    }

    @DisplayName("user2 삭제")
    void deleteUser2() {
        log.info("deleteUser2...");
    }
}