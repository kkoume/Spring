package kr.co.ch09.service;

import kr.co.ch09.dto.User2DTO;
import kr.co.ch09.entity.User2;
import kr.co.ch09.repository.User2Repository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class User2Service {

    private final User2Repository user2Repository;

    public ResponseEntity<?> insertUser2(User2DTO user2DTO){
        /*
            JPA save()는 삽입, 수정을 동시에 할 수 있는 메서드 이기 때문에
            삽입을 수행하고자 할 경우에는 먼저 미리 existsById()로 존재여부를 확인하고
            save()를 수행하면 됨
        */
        if(user2Repository.existsById(user2DTO.getUid())){
            // 이미 존재하는 아이디이면
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(user2DTO.getUid() + " already exist");

        }else{
            // 존재하지 않으면
            User2 user2 = user2DTO.toEntity();
            user2Repository.save(user2);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user2DTO);
        }
    }

    public ResponseEntity<?> selectUser2(String uid){

        try {
            // orElseThrow() 메서드로 존재하는 Entity를 가져오거나 존재하지 않으면 기본 예외 NoSuchElementException 발생
            User2 user2 = user2Repository.findById(uid).orElseThrow();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user2.toDTO());

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }

    public ResponseEntity<List<User2DTO>> selectUser2s(){

        List<User2DTO> user2DTOs = user2Repository.findAll()
                .stream()
                .map(entity -> User2DTO.builder()
                        .uid(entity.getUid())
                        .name(entity.getName())
                        .birth(entity.getBirth())
                        //.email(entity.getEmail())
                        //.age(entity.getAge())
                        .addr(entity.getAddr())
                        .build())
                .toList();

        return ResponseEntity
                .ok()
                .body(user2DTOs);
    }

    public ResponseEntity<?> updateUser2(User2DTO user2DTO){

        // 수정하기 전에 먼저 존재여부 확인
        if(user2Repository.existsById(user2DTO.getUid())){
            // 이미 존재하는 아이디이면 수정
            user2Repository.save(user2DTO.toEntity());

            // 수정 후 수정 데이터 반환
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user2DTO);
        }else{
            // 사용자가 존재하지 않으면 NOT_FOUND 응답데이터와 user not found 메세지
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }
    public ResponseEntity<?> deleteUser2(String uid){

        // 삭제 전 삭제할 사용자 조회
        Optional<User2> optUser2 = user2Repository.findById(uid);

        if(optUser2.isPresent()){
            // 사용자가 존재하면 삭제 후 삭제한 사용자 정보 ResponseEntity로 반환
            user2Repository.deleteById(uid);
            return ResponseEntity
                    .ok()
                    .body(optUser2.get());
        }else{
            // 사용자가 존재하지 않으면 NOT_FOUND 응답데이터와 user not found 메세지
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }

    }

}