package kr.co.ch09.repository;

import kr.co.ch09.entity.User4;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User4Repository extends JpaRepository<User4, String> {

}