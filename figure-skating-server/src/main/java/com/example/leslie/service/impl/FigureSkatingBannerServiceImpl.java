package com.example.leslie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.leslie.mapper.FigureSkatingBannerMapper;
import com.example.leslie.model.domain.FigureSkatingBanner;
import com.example.leslie.service.FigureSkatingBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FigureSkatingBannerServiceImpl extends ServiceImpl<FigureSkatingBannerMapper, FigureSkatingBanner>
        implements FigureSkatingBannerService {

    @Autowired
    private FigureSkatingBannerMapper figureSkatingBannerMapper;

    @Cacheable(value = "figure_skating_banner", key = "'list'")  //放在缓存中 redis 是以key-value进行存储的
    @Override
    public List<FigureSkatingBanner> getAllBanner() {
        System.out.println("没有走缓存");
        return figureSkatingBannerMapper.selectList(null);
    }
}

