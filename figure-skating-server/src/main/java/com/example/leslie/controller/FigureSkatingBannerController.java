package com.example.leslie.controller;

import com.example.leslie.common.R;
import com.example.leslie.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * FigureSkatingBanner首页轮播图
 */

@RestController
@RequestMapping("/figureSkatingBanner")
public class FigureSkatingBannerController {
    @Autowired
    private BannerService bannerService;

    @GetMapping("/getAllBanner")
    public R getAllBanner(){
        return R.success("成功获取轮播图与",bannerService.getAllBanner());
    }
}
