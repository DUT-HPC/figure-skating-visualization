package com.example.leslie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.leslie.common.R;
import com.example.leslie.model.domain.RankList;
import com.example.leslie.model.request.RankListRequest;

public interface RankListService extends IService<RankList> {

    R addRank(RankListRequest rankListAddRequest);

    R rankOfSongListId(Long songListId);

    R getUserRank(Long consumerId, Long songListId);

}
