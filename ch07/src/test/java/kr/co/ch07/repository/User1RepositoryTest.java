package kr.co.ch07.repository;

import kr.co.ch07.entity.User1;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class User1RepositoryTest {
    /**
     * JUnit 테스트에서는 @Autowired 주입
     * 생성자 주입은 No ParameterResolver registered for parameter 에러 발생
     * 시간날때 왜 그런지 알아볼것
     */
    @Autowired
    private User1Repository repository;

    @DisplayName("user1 등록")
    public void insertUser1(){
        // given - entity 준비
        User1 user1 = User1.builder()
                .uid("j101")
                .name("김유신")
                .birth("1990-03-12")
                .hp("010-1234-1002")
                .age(21)
                .build();

        // when - entity 저장
        repository.save(user1);
    }


    @DisplayName("user1 조회")
    public void selectUser1(){
        // given - 조회 아이디
        String uid = "j101";

        // when - 조회하기
        Optional<User1> result = repository.findById(uid);
        User1 user1 = result.get();
        log.info(user1.toString());
    }

    @DisplayName("user1 목록")
    public void selectUser1s(){

    }

    @DisplayName("user1 수정")
    public void updateUser1(){

    }

    @DisplayName("user1 삭제")
    public void deleteUser1(){

    }

    /*
        사용자 정의 쿼리 메서드 테스트
        테스트 메서드는 반환타입이 void, 매개변수는 없어야 됨
        있으면 No ParameterResolver registered for parameter 에러 뜸
    */
    @Test
    public void findUser1ByUid(){
        User1 user1 = repository.findUser1ByUid("a102");
        log.warn(user1.toString());
    }
    @Test
    public void findUser1ByName(){
        List<User1> user1s = repository.findUser1ByName("김유신");
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByNameNot(){
        List<User1> user1s = repository.findUser1ByNameNot("김유신");
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByUidAndName(){
        User1 user1 = repository.findUser1ByUidAndName("a102", "김유신");
        log.warn(user1.toString());
    }
    @Test
    public void findUser1ByUidOrName(){
        List<User1> user1s = repository.findUser1ByUidOrName("a102", "김유신");
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByAgeGreaterThan(){
        List<User1> user1s = repository.findUser1ByAgeGreaterThan(23);
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByAgeGreaterThanEqual(){
        List<User1> user1s = repository.findUser1ByAgeGreaterThanEqual(23);
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByAgeLessThan(){
        List<User1> user1s = repository.findUser1ByAgeLessThan(23);
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByAgeLessThanEqual(){
        List<User1> user1s = repository.findUser1ByAgeLessThanEqual(23);
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByAgeBetween(){
        List<User1> user1s = repository.findUser1ByAgeBetween(20, 30);
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByNameLike(){
        List<User1> user1s = repository.findUser1ByNameLike("김유신");
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByNameContains(){
        List<User1> user1s = repository.findUser1ByNameContains("김유신");
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByNameStartsWith(){
        List<User1> user1s = repository.findUser1ByNameStartsWith("김");
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByNameEndsWith(){
        List<User1> user1s = repository.findUser1ByNameEndsWith("신");
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByOrderByName(){
        List<User1> user1s = repository.findUser1ByOrderByName();
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByOrderByAgeAsc(){
        List<User1> user1s = repository.findUser1ByOrderByAgeAsc();
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByOrderByAgeDesc(){
        List<User1> user1s = repository.findUser1ByOrderByAgeDesc();
        log.warn(user1s.toString());
    }
    @Test
    public void findUser1ByAgeGreaterThanOrderByAgeDesc(){
        List<User1> user1s = repository.findUser1ByAgeGreaterThanOrderByAgeDesc(23);
        log.warn(user1s.toString());
    }
    @Test
    public void countUser1ByUid(){
        int result = repository.countUser1ByUid("a101");
        log.warn("countUser1ByUid : " + result);
    }
    @Test
    public void countUser1ByName(){
        int result = repository.countUser1ByName("김유신");
        log.warn("countUser1ByName : " + result);
    }

    // JPQL 정의
    @Test
    public void selectUser1UnderAge30(){
        List<User1> user1s = repository.selectUser1UnderAge30();
        log.warn(user1s.toString());
    }
    @Test
    public void selectUser1ByName(){
        List<User1> user1s = repository.selectUser1ByName("김유신");
        log.warn(user1s.toString());
    }
    @Test
    public void selectUser1ByNameParam(){
        List<User1> user1s = repository.selectUser1ByNameParam("김유신");
        log.warn(user1s.toString());
    }
    @Test
    public void selectUser1ByUid(){
        List<Object[]> user1s = repository.selectUser1ByUid("a101");
        log.warn(user1s.toString());
    }
}