package com.example.leslie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.leslie.common.R;
import com.example.leslie.mapper.FigureSkatingVideoMapper;
import com.example.leslie.model.domain.FigureSkatingVideo;
import com.example.leslie.service.FigureSkatingVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FigureSkatingVideoServiceImpl extends ServiceImpl<FigureSkatingVideoMapper, FigureSkatingVideo> implements FigureSkatingVideoService {
    @Autowired
    private FigureSkatingVideoMapper figureSkatingVideoMapper;


    @Override
    public R allFigureSkatingVideo() {
        return R.success(null, figureSkatingVideoMapper.selectList(null));
    }

}
