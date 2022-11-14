package com.example.leslie.controller;


import com.example.leslie.common.R;
import com.example.leslie.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {


    @Autowired
    private PlayerService playerService;

    // 返回所有视频
    @GetMapping("/player")
    public R allPlayer() {
        return playerService.allPlayer();
    }

}
