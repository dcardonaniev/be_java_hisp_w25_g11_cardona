package com.example.be_java_hisp_w25_g11.controller;

import com.example.be_java_hisp_w25_g11.dto.response.FollowedDTO;
import com.example.be_java_hisp_w25_g11.dto.response.FollowerCountDTO;
import com.example.be_java_hisp_w25_g11.dto.response.FollowerDTO;
import com.example.be_java_hisp_w25_g11.dto.response.SuccessDTO;
import com.example.be_java_hisp_w25_g11.service.user.IUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final IUserService userService;

    public UserController(IUserService userService){
        this.userService = userService;
    }

    @PostMapping("/{userId}/follow/{userIdToFollow}")
    public ResponseEntity<SuccessDTO> follow(
        @PathVariable Integer userId,
        @PathVariable Integer userIdToFollow
    ) {
        return new ResponseEntity<>(new SuccessDTO(), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/count")
    public ResponseEntity<FollowerCountDTO> followersCount(
        @PathVariable Integer userId
    ) {
        return new ResponseEntity<>(userService.followersSellersCount(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followers/list")
    public ResponseEntity<FollowerDTO>  followersList(
        @PathVariable Integer userId

    ) {
        return new ResponseEntity<>(userService.buyersFollowSellers(userId), HttpStatus.OK);
    }

    @GetMapping("/{userId}/followed/list")
    public ResponseEntity<FollowedDTO> followedList(
        @PathVariable Integer userId,
        @RequestParam(required = false) String order
    ) {return ResponseEntity.ok(this.userService.sortFollowed(userId,order));}

    @PostMapping("/{userId}/unfollow/{userIdToUnfollow}")
    public ResponseEntity<SuccessDTO> unfollow(
        @PathVariable Integer userId,
        @PathVariable Integer userIdToUnfollow
    ) {
        return new ResponseEntity<>(new SuccessDTO(), HttpStatus.OK);
    }
}
