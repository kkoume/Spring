package kr.co.ch06.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User4DTO {
    private String uid;
    private String name;
    private String gender;
    private int age;
    private String hp;
    private String addr;
}
