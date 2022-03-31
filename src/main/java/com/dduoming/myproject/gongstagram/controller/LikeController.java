package com.dduoming.myproject.gongstagram.controller;

import com.dduoming.myproject.gongstagram.domain.Post;
import com.dduoming.myproject.gongstagram.repository.LikeRepository;
import com.dduoming.myproject.gongstagram.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LikeController {
    private final LikeService likeService;
    private final LikeRepository likeRepository;


    @PostMapping("/post/{id}/likes")
    public Post addLike(@PathVariable Long id){
//        User user=(User) userDetails.getUser();
        Post post = likeService.addLike(id);
        return post;



    }

//    @GetMapping("/til/like/{til_id}")
//    //사용자가 이 글을 좋아요 눌렀는지 안눌렀는지 판별하는 함수
//    public boolean getLike(
//            @AuthenticationPrincipal UserDetailsImpl userDetails,
//            @PathVariable Long til_id) {
//
//        Til til = tilRepository.findById(til_id).get();
//        User user=(User) userDetails.getUser();
//        boolean result = false;
//
//
//        if (likeRepository.findByTilAndUser(til, user).isPresent()) {
//            result = true; //이미 좋아요 누른 상태
//        }
//
//        return result;
//
//    }
    //좋아요 취소
    @DeleteMapping("/post/{id}/likes")
    public void CancelLike(@PathVariable Long id)
    {
//        User user=(User) userDetails.getUser();
        likeService.CancelLike(id);

    }
}