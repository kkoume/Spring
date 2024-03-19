package kr.co.sboard.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ConfigDTO {
    /*
        날짜 : 2024/03/19
        이름 : 조영흥
        내용 : 게시판 테이블 설정 정보

        cate : 게시판 카테고리
        boardName : 게시판 이름
        admin : 게시판 관리자
        total : 게시판 총 글 등록수
        createDate : 게시판 생성일
     */

    private String cate;
    private String boardName;
    private String admin;
    private int total;
    private LocalDateTime createDate;
}
