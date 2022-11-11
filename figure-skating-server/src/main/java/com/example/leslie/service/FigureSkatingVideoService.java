package com.example.leslie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.leslie.common.R;
import com.example.leslie.model.domain.FigureSkatingVideo;

public interface FigureSkatingVideoService extends IService<FigureSkatingVideo> {

    R allFigureSkatingVideo();
}
