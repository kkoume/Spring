package kr.co.ch04.dao;

import kr.co.ch04.dto.User4DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class User4Dao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertUser4(User4DTO user4DTO){

    }

    public User4DTO selectUser4(String uid){
        return null;
    }

    public List<User4DTO> selectUser4s(){
        return null;
    }

    public void updateUser4(User4DTO user4DTO){

    }

    public void deleteUser4(String uid){

    }

}
