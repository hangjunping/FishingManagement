package com.sinovatio.fishing.data.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="SecHunterEntity")
public class SecHunterEntity {

    public SecHunterEntity(Long createTime,String type){
        this.createTime=createTime;
        this.type=type;
    }

    //设置主键自增， 每个类需要一个主键
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "createTime")
    public Long createTime;

    @ColumnInfo(name = "type")
    public String type;
}
