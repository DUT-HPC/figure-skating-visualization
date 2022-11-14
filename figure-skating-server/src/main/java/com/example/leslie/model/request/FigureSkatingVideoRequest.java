package com.example.leslie.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class FigureSkatingVideoRequest {
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
}
