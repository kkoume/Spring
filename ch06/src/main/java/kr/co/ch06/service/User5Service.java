package kr.co.ch06.service;

import kr.co.ch06.dto.User5DTO;
import kr.co.ch06.mapper.User5Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class User5Service {

    private final User5Mapper mapper;

    public void insertUser5(User5DTO user5DTO){
        mapper.insertUser5(user5DTO);
    }

    public User5DTO selectUser5(int seq){
        return mapper.selectUser5(seq);
    }

    public List<User5DTO> selectUser5s(){
        return mapper.selectUser5s();
    }

    public void updateUser5(User5DTO user5DTO){
        mapper.updateUser5(user5DTO);
    }

    public void deleteUser5(int seq){
        mapper.deleteUser5(seq);
    }

}
