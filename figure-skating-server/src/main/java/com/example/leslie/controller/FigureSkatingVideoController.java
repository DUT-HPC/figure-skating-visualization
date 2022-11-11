package com.example.leslie.controller;

import com.example.leslie.common.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerController {
    // 返回所有歌手
    @GetMapping("/player")
    public R allSinger() {
        return singerService.allSinger();
    }
}
