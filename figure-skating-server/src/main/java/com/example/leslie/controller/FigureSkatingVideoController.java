package com.example.leslie.controller;

import com.example.leslie.common.R;
import com.example.leslie.service.FigureSkatingVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureSkatingVideoController {

    @Autowired
    private FigureSkatingVideoService figureSkatingVideoService;

    // 返回所有视频
    @GetMapping("/figureSkating/video")
    public R allFigureSkatingVideo() {
        return figureSkatingVideoService.allFigureSkatingVideo();
    }

    // 返回所有表演者
    @GetMapping("/figureSkating/player")
    public R allFigureSkatingPlayer() {
        return figureSkatingVideoService.allFigureSkatingPlayer();
    }

    // 返回选手的视频
    @GetMapping("/figureSkating/player/detail")
    public R songOfSingerId(@RequestParam int playerId) {
        return figureSkatingVideoService.figureSkatingVideoOfPlayerId(playerId);
    }

}
