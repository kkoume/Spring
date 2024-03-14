package kr.co.ch06.service;

import kr.co.ch06.dto.User3DTO;
import kr.co.ch06.mapper.User3Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class User3Service {

    private final User3Mapper mapper;

    public void insertUser3(User3DTO user3DTO){
        mapper.insertUser3(user3DTO);
    }

    public User3DTO selectUser3(String uid){
        return mapper.selectUser3(uid);
    }

    public List<User3DTO> selectUser3s(){
        return mapper.selectUser3s();
    }

    public void updateUser3(User3DTO user3DTO){
        mapper.updateUser3(user3DTO);
    }

    public void deleteUser3(String uid){
        mapper.deleteUser3(uid);
    }

}
