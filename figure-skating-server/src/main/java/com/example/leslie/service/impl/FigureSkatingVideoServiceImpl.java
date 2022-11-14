package com.example.leslie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.leslie.common.R;
import com.example.leslie.mapper.FigureSkatingVideoMapper;
import com.example.leslie.mapper.PlayerMapper;
import com.example.leslie.model.domain.FigureSkatingVideo;
import com.example.leslie.model.domain.Player;
import com.example.leslie.model.domain.Singer;
import com.example.leslie.service.FigureSkatingVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FigureSkatingVideoServiceImpl extends ServiceImpl<FigureSkatingVideoMapper, FigureSkatingVideo> implements FigureSkatingVideoService {
    @Autowired
    private FigureSkatingVideoMapper figureSkatingVideoMapper;

    @Autowired
    private PlayerMapper playerMapper;


    @Override
    public R allFigureSkatingVideo() {
        return R.success(null, figureSkatingVideoMapper.selectList(null));
    }

    @Override
    public R allFigureSkatingPlayer() {
        QueryWrapper<FigureSkatingVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("DISTINCT player").orderByAsc("player");
        return R.success(null, figureSkatingVideoMapper.selectList(queryWrapper));
    }

    @Override
    public R figureSkatingVideoOfPlayerId(int playerId) {
        QueryWrapper<Player> queryWrapperPlayer = new QueryWrapper<>();
        queryWrapperPlayer.eq("id", playerId);
        List<Player> player = playerMapper.selectList(queryWrapperPlayer);

        QueryWrapper<FigureSkatingVideo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("player", player.get(0).getName());
        return R.success(null, figureSkatingVideoMapper.selectList(queryWrapper));
    }
}
