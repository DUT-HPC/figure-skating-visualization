package com.example.leslie.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName(value = "figure_skating_player")
@Data
public class Player {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String name;

    private String pic;

    private Integer age;
}
