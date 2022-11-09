package com.example.leslie.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.leslie.common.R;
import com.example.leslie.model.domain.SongList;
import com.example.leslie.model.request.SongListRequest;
import org.springframework.web.multipart.MultipartFile;

public interface SongListService extends IService<SongList> {

    R addSongList(SongListRequest addSongListRequest);

    R updateSongListMsg(SongListRequest updateSongListRequest);

    R updateSongListImg(MultipartFile avatorFile, int id);

    R deleteSongList(Integer id);

    R allSongList();

    R likeTitle(String title);

    R likeStyle(String style);
}
