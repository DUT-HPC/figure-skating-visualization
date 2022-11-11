package com.example.leslie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.leslie.model.domain.Banner;
import com.example.leslie.model.domain.FigureSkatingBanner;

import java.util.List;

public interface FigureSkatingService extends IService<FigureSkatingBanner> {

    List<Banner> getAllBanner();
}
