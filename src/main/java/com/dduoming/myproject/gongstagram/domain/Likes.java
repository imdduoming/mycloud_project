package com.dduoming.myproject.gongstagram.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter // get 함수를 일괄적으로 만들어줍니다.
@Entity // DB 테이블 역할을 합니다
public class Likes extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST})
    @JoinColumn(name="post_id", nullable = false)
    private Post post;


    public Likes(Post post) {
        this.post=post;

    }
}