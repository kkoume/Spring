package kr.co.ch07.repository;

import kr.co.ch07.entity.User2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User2RepositoryTest {

    @Autowired
    private User2Repository repository;

    @DisplayName("user2 등록")
    public void insertUser2(){
        User2 user2 = User2.builder()
                .uid("A107")
                .name("테스트")
                .birth("1993-02-11")
                .addr("부산시 금정구")
                .build();
        repository.save(user2);
    }

    @DisplayName("user2 조회")
    public void selectUser2(){
        String uid = "A107";
        Optional<User2> result = repository.findById(uid);
        User2 user2 = result.get();
        log.info(user2.toString());
    }

    @DisplayName("user2 목록")
    public void selectUser2s(){

    }

    @DisplayName("user2 수정")
    public void updateUser2(){

    }

    @DisplayName("user2 삭제")
    public void deleteUser2(){

    }



    @Test
    public void findUser2ByUid() {
        User2 user2 = repository.findUser2ByUid("a102");
        log.warn(user2.toString());
    }

    @Test
    public void findUser2ByName() {
        List<User2> user2s = repository.findUser2ByName("원빈");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByNameNot() {
        List<User2> user2s = repository.findUser2ByNameNot("원빈");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByUidAndName() {
        User2 user2 = repository.findUser2ByUidAndName("a102", "원빈");
        log.warn(user2.toString());
    }

    @Test
    public void findUser2ByUidOrName() {
        List<User2> user2s = repository.findUser2ByUidOrName("a102", "원빈");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByNameLike() {
        List<User2> user2s = repository.findUser2ByNameLike("원빈");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByNameContains() {
        List<User2> user2s = repository.findUser2ByNameContains("원빈");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByNameStartsWith() {
        List<User2> user2s = repository.findUser2ByNameStartsWith("금");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByNameEndsWith() {
        List<User2> user2s = repository.findUser2ByNameEndsWith("선");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByOrderByName() {
        List<User2> user2s = repository.findUser2ByNameEndsWith("선");
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByOrderByAddrAsc() {
        List<User2> user2s = repository.findUser2ByOrderByAddrAsc();
        log.warn(user2s.toString());
    }

    @Test
    public void findUser2ByOrderByAddrDesc() {
        List<User2> user2s = repository.findUser2ByOrderByAddrDesc();
        log.warn(user2s.toString());
    }

    @Test
    public void countUser2ByUid() {
        int result = repository.countUser2ByUid("a101");
        log.warn("countUser2ByUid : " + result);
    }

    @Test
    public void countUser2ByName() {
        int result = repository.countUser2ByName("김유신");
        log.warn("countUser2ByName : " + result);
    }

    @Test
    public void selectUser2ByName() {
        List<User2> user2s = repository.selectUser2ByName("금강선");
        log.warn(user2s.toString());
    }

    @Test
    public void selectUser2ByNameParam() {
        List<User2> user2s = repository.selectUser2ByNameParam("김유신");
        log.warn(user2s.toString());
    }

    @Test
    public void selectUser2ByUid() {
        List<Object[]> user2s = repository.selectUser2ByUid("a101");
        log.warn(user2s.toString());
    }

}