package com.example.leslie.controller;

import com.example.leslie.common.R;
import com.example.leslie.service.FigureSkatingVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FigureSkatingVideoController {

    @Autowired
    private FigureSkatingVideoService figureSkatingVideoService;

    // 返回所有视频
    @GetMapping("/figureSkatingVideo")
    public R allFigureSkatingVideo() {
        return figureSkatingVideoService.allFigureSkatingVideo();
    }
}
