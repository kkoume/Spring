package kr.co.ch06.mapper;

import kr.co.ch06.dto.User1DTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/*
    @Mapper
     - MapperScan을 통한 해당 Mapper 등록
     - Mapper xml 파일과 연결 및 데이터베이스와 상호작용
 */
@Mapper
public interface User1Mapper {
    public void insertUser1(User1DTO user1DTO);
    public User1DTO selectUser1(String uid);
    public List<User1DTO> selectUser1s();
    public void updateUser1(User1DTO user1DTO);
    public void deleteUser1(String uid);
}
