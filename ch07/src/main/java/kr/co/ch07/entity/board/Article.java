package kr.co.ch07.entity.board;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name="board_article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // Auto_Increment
    private int no;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)  // 연관 엔티티가 로딩될 때 필요 시점에 로딩되는 지연전략
    @JoinColumn(name="writer")          // 엔티티가 테이블로 생성될 때 컬럼명, 해당 엔티티의 @ID 컬럼타임으로 생성
    private User user;

    @OneToOne(mappedBy = "article")     //양방향 연관 관계에서 외래키를 갖는 엔티티의 속성을 mappedBy 속성으로 연결 주인을 설정
    private File file;

    @OneToMany(mappedBy = "article")
    private List<Comment> comment;

    @CreationTimestamp
    private LocalDateTime rdate;
}
