package com.example.leslie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.leslie.common.R;
import com.example.leslie.mapper.PlayerMapper;
import com.example.leslie.model.domain.Player;
import com.example.leslie.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, Player> implements PlayerService {
    @Autowired
    private PlayerMapper playerMapper;

    @Override
    public R allPlayer() {
        return R.success(null, playerMapper.selectList(null));
    }

}
