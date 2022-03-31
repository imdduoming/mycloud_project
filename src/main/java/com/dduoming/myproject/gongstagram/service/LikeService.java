package com.dduoming.myproject.gongstagram.service;

import com.dduoming.myproject.gongstagram.domain.Likes;
import com.dduoming.myproject.gongstagram.domain.Post;
import com.dduoming.myproject.gongstagram.repository.LikeRepository;
import com.dduoming.myproject.gongstagram.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final PostService postService;

    @Transactional
    public Post addLike(Long post_id) {
        //좋아요를 등록할 til 가져오기

        Post post  = postRepository.findById(post_id).orElseThrow(
                ()->new NullPointerException("해당 아이디가 존재하지 않습니다.")
        );

        likeRepository.save(new Likes(post));
        int like_num=post.getNum_like()+1;
        post.setNum_like(like_num);
        postRepository.save(post);
        return post;
//
//        //중복 좋아요 방지
//        if(!isNotAlreadyLike(user, til)) {
//            likeRepository.save(new Likes(til,user));
//            int like_num=til.getTilLike()+1;
//            til.setTilLike(like_num);
//            tilRepository.save(til);
//            return til;
//
//        }


    }

//    //사용자가 이미 좋아요 한 게시물인지 체크
//    public boolean isNotAlreadyLike(Post post) {
//        return likeRepository.findBy(post).isPresent();
//    }

    @Transactional
    public void CancelLike(Long post_id) {
        //좋아요를 취소할 til 가져오기
        Post post = postRepository.findById(post_id).get();
        int like_num = post.getNum_like();


        if (like_num > 0) {
            like_num = like_num - 1;
            post.setNum_like(like_num);
            postRepository.save(post);
            likeRepository.deleteByPost(post);
        }
//        if(isNotAlreadyLike(user, til) && like_num>0) {
//            like_num=like_num-1;
//            til.setTilLike(like_num);
//            tilRepository.save(til);
//            likeRepository.deleteByTilAndUser(til,user);
//            return til;
//        }
//        return til;

    }
}