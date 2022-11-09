package com.example.leslie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.leslie.common.R;
import com.example.leslie.model.domain.Collect;
import com.example.leslie.model.request.CollectRequest;

public interface CollectService extends IService<Collect> {

    R addCollection(CollectRequest addCollectRequest);

    R existSongId(CollectRequest isCollectRequest);

    R deleteCollect(Integer userId,Integer songId);

    R collectionOfUser(Integer userId);
}
