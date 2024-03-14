package kr.co.ch09.dto;

import kr.co.ch09.entity.User1;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User1DTO {
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private int age;

    public User1 toEntity(){

        return User1.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .age(age)
                .build();
    }
}
