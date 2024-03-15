package kr.co.ch06.mapper;

import kr.co.ch06.dto.User4DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface User4Mapper {
    public void insertUser4(User4DTO user4DTO);
    public User4DTO selectUser4(String uid);
    public List<User4DTO> selectUser4s();
    public void updateUser4(User4DTO user4DTO);
    public void deleteUser4(String uid);
}
