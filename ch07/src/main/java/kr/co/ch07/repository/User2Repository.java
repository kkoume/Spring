package kr.co.ch07.repository;

import kr.co.ch07.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User2Repository extends JpaRepository<User2, String> {

    // 사용자 정의 쿼리메서드
    public User2 findUser2ByUid(String uid);
    public List<User2> findUser2ByName(String name);
    public List<User2> findUser2ByNameNot(String name);

    public User2 findUser2ByUidAndName(String uid, String name);
    public List<User2> findUser2ByUidOrName(String uid, String name);

    public List<User2> findUser2ByNameLike(String name);
    public List<User2> findUser2ByNameContains(String name);
    public List<User2> findUser2ByNameStartsWith(String name);
    public List<User2> findUser2ByNameEndsWith(String name);

    public List<User2> findUser2ByOrderByAddrAsc();
    public List<User2> findUser2ByOrderByAddrDesc();

    public int countUser2ByUid(String uid);
    public int countUser2ByName(String name);


    // JPQL 정의
    @Query("select u2 from User2 as u2 where u2.name = ?1")
    public List<User2> selectUser2ByName(String name);

    @Query("select u2 from User2 as u2 where u2.name = :name")
    public List<User2> selectUser2ByNameParam(@Param("name") String name);

    @Query("select u2.uid, u2.name, u2.addr from User2 as u2 where u2.uid = :uid")
    public List<Object[]> selectUser2ByUid(@Param("uid") String uid);
}
