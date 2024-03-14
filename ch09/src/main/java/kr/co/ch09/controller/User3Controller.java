package kr.co.ch09.controller;

import kr.co.ch09.dto.User3DTO;
import kr.co.ch09.service.User3Service;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class User3Controller {

    private final User3Service user3Service;

    @GetMapping("/user3")
    public ResponseEntity<List<User3DTO>> list(){
        return user3Service.selectUser3s();
    }

    @GetMapping("/user3/{uid}")
    public ResponseEntity<?> user3(@PathVariable("uid") String uid){
        return user3Service.selectUser3(uid);
    }

    @PostMapping("/user3")
    public ResponseEntity<?> register(@RequestBody @Validated User3DTO user3DTO){
        return user3Service.insertUser3(user3DTO);
    }

    @PutMapping("/user3")
    public ResponseEntity<?> modify(@RequestBody User3DTO user3DTO){
        return user3Service.updateUser3(user3DTO);
    }

    @DeleteMapping("/user3/{uid}")
    public ResponseEntity<?> delete(@PathVariable("uid") String uid){
        return user3Service.deleteUser3(uid);
    }
}
