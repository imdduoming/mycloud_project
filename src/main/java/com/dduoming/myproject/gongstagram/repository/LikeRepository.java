package com.dduoming.myproject.gongstagram.repository;


import com.dduoming.myproject.gongstagram.domain.Likes;
import com.dduoming.myproject.gongstagram.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes,Long> {
    void deleteByPost(Post post);
}
