package kr.co.ch10.service;

import kr.co.ch10.dto.UserDTO;
import kr.co.ch10.entity.User;
import kr.co.ch10.repository.UserRepository;
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
public class UserService {

    private final UserRepository userRepository;

    public ResponseEntity<?> insertUser(UserDTO userDTO){
        /*
            JPA save()는 삽입, 수정을 동시에 할 수 있는 메서드 이기 때문에
            삽입을 수행하고자 할 경우에는 먼저 미리 existsById()로 존재여부를 확인하고
            save()를 수행하면 됨
        */
        if(userRepository.existsById(userDTO.getUid())){
            // 이미 존재하는 아이디이면
            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(userDTO.getUid() + " already exist");

        }else{
            // 존재하지 않으면
            User user = userDTO.toEntity();
            userRepository.save(user);

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userDTO);
        }
    }

    public ResponseEntity<?> selectUser(String uid){

        try {
            // orElseThrow() 메서드로 존재하는 Entity를 가져오거나 존재하지 않으면 기본 예외 NoSuchElementException 발생
            User user = userRepository.findById(uid).orElseThrow();

            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(user.toDTO());

        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }

    public ResponseEntity<List<UserDTO>> selectUsers(){

        List<UserDTO> userDTOs = userRepository.findAll()
                .stream()
                .map(entity -> UserDTO.builder()
                        .uid(entity.getUid())
                        .name(entity.getName())
                        .age(entity.getAge())
                        .hp(entity.getHp())
                        .role(entity.getRole())
                        .regDate(entity.getRegDate())
                        .build())
                .toList();

        return ResponseEntity
                .ok()
                .body(userDTOs);
    }

    public ResponseEntity<?> updateUser(UserDTO userDTO){

        // 수정하기 전에 먼저 존재여부 확인
        if(userRepository.existsById(userDTO.getUid())){
            // 이미 존재하는 아이디이면 수정
            userRepository.save(userDTO.toEntity());

            // 수정 후 수정 데이터 반환
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(userDTO);
        }else{
            // 사용자가 존재하지 않으면 NOT_FOUND 응답데이터와 user not found 메세지
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }
    }
    public ResponseEntity<?> deleteUser(String uid){

        // 삭제 전 삭제할 사용자 조회
        Optional<User> optUser = userRepository.findById(uid);

        if(optUser.isPresent()){
            // 사용자가 존재하면 삭제 후 삭제한 사용자 정보 ResponseEntity로 반환
            userRepository.deleteById(uid);
            return ResponseEntity
                    .ok()
                    .body(optUser.get());
        }else{
            // 사용자가 존재하지 않으면 NOT_FOUND 응답데이터와 user not found 메세지
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("user not found");
        }

    }

}
