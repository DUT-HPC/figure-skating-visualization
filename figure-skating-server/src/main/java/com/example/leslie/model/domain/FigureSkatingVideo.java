package com.example.leslie.model.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.util.Date;

@TableName(value = "figure_skating_video")
@Data
public class FigureSkatingVideo {
    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String videoPic;

    private String videoPath;

    private String player;

    private String playerPic;

    private String music;

    private String introduction;

    private int age;

    private String openposeVideoPath;

    private String segmentVideoPath;

    private String typeList;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
