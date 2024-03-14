package kr.co.ch09.controller;

import kr.co.ch09.dto.User1DTO;
import kr.co.ch09.service.User1Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;

    /*
        @RequestBody
          - 요청 본문 내용에 포함된 데이터를 Java 객체로 변환
          - 클라이언트에서 전송되는 JSON 데이터를 수신
          - 생략가능. 보통은 생략함.

        @ResponseBody
          - 메서드의 변환값을 응답객체 내용 본문으로 출력
          - JSON 출력 어노테이션

        @PathVariable
          - 주소 파라미터 값을 수신

        @RestController
          - API 요청을 처리하는 메서드의 결과를 응답객체 본문에 출력시키는 클래스 어노테이션

        ResponseEntity
          - API를 요청한 사용자에게 응답데이터를 구성해서 부가적인 정보를 제공하기 위한 클래스
          - 일반적으로 상태코드(header), 본문내용(body)을 구성해서 제공
    */
    @ResponseBody
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> user1s = user1Service.selectUser1s();
        return user1s;
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user1(@PathVariable("uid") String uid){
        User1DTO user1DTO = user1Service.selectUser1(uid);
        return user1DTO;
    }

    @ResponseBody
    @PostMapping("/user1")
    public ResponseEntity<User1DTO> register(@RequestBody User1DTO user1DTO){
        user1Service.insertUser1(user1DTO);
        return ResponseEntity.ok().body(user1DTO);
    }

    @ResponseBody
    @PutMapping("/user1")
    public ResponseEntity<User1DTO> modify(User1DTO user1DTO){
        User1DTO user1 = user1Service.updateUser1(user1DTO);
        return ResponseEntity
                    .status(HttpStatus.ACCEPTED)
                    .body(user1);
    }

    @ResponseBody
    @DeleteMapping("/user1/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){
        return user1Service.deleteUser1(uid);
    }
}
