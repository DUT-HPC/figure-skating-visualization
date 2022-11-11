package com.example.leslie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.leslie.mapper.BannerMapper;
import com.example.leslie.model.domain.Banner;
import com.example.leslie.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FigureSkatingBannerImpl extends ServiceImpl<BannerMapper, Banner>
        implements BannerService{
    @Autowired
    private BannerMapper bannerMapper;

    @Cacheable(value = "fingureSkatingBanner", key = "'list'")  //放在缓存中 redis 是以key-value进行存储的
    @Override
    public List<Banner> getAllBanner() {
        System.out.println("没有走缓存");
        return bannerMapper.selectList(null);
    }
}

