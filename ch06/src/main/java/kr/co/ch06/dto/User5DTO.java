package kr.co.ch06.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User5DTO {
    private int seq;
    private String name;
    private String gender;
    private int age;
    private String addr;
}
