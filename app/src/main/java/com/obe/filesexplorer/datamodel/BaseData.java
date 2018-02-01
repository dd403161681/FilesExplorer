package com.obe.filesexplorer.datamodel;

import java.io.Serializable;

/**
 * Created by ken on 2018/1/30.
 */

public class BaseData implements Serializable
{
    private long album;
    private String artist;
    private int category;
    private int dataSources;
    private String description;
    private int doubanId;
    private String doubanUrl;
    private long duration;
    private String format;
    private int hisType;
    private long id = 0L;
    private boolean isTitle;
    private long lastPlayPosition;
    private long lastPlayTime;
    private int loadStat;
    private long modifyTime;
    private String name;
    private String nameVisble;
    private String parentPath;
    private String path;
    private String posterUrl;
    private String rootPath;
    private String size;
    private String title;
    private int type;

    public int getCategory()
    {
        return this.category;
    }

    public int getDataSources()
    {
        return this.dataSources;
    }

    public int getDoubanId()
    {
        return this.doubanId;
    }

    public String getDoubanUrl()
    {
        return this.doubanUrl;
    }

    public long getDuration()
    {
        return this.duration;
    }

    public long getLastPlayPosition()
    {
        return this.lastPlayPosition;
    }

    public long getLastPlayTime()
    {
        return this.lastPlayTime;
    }

    public String getName()
    {
        return this.name;
    }

    public String getParentPath()
    {
        return this.parentPath;
    }

    public String getPath()
    {
        return this.path;
    }

    public String getPosterUrl()
    {
        return this.posterUrl;
    }

    public String getRootPath()
    {
        return this.rootPath;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getType()
    {
        return this.type;
    }

    public void setCategory(int paramInt)
    {
        this.category = paramInt;
    }

    public void setDataSources(int paramInt)
    {
        this.dataSources = paramInt;
    }

    public void setDescription(String paramString)
    {
        this.description = paramString;
    }

    public void setDoubanId(int paramInt)
    {
        this.doubanId = paramInt;
    }

    public void setDoubanUrl(String paramString)
    {
        this.doubanUrl = paramString;
    }

    public void setDuration(long paramLong)
    {
        this.duration = paramLong;
    }

    public void setFormat(String paramString)
    {
        this.format = paramString;
    }

    public void setHisType(int paramInt)
    {
        this.hisType = paramInt;
    }

    public void setLastPlayPosition(long paramLong)
    {
        this.lastPlayPosition = paramLong;
    }

    public void setLastPlayTime(long paramLong)
    {
        this.lastPlayTime = paramLong;
    }

    public void setName(String paramString)
    {
        this.name = paramString;
    }

    public void setParentPath(String paramString)
    {
        this.parentPath = paramString;
    }

    public void setPath(String paramString)
    {
        this.path = paramString;
    }

    public void setPosterUrl(String paramString)
    {
        this.posterUrl = paramString;
    }

    public void setRootPath(String paramString)
    {
        this.rootPath = paramString;
    }

    public void setSize(String paramString)
    {
        this.size = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public void setType(int paramInt)
    {
        this.type = paramInt;
    }

    public String toString()
    {
        return "BaseData [name=" + this.name + ", path=" + this.path + ", parentPath=" + this.parentPath + ", rootPath=" + this.rootPath + ", type=" + this.type + ", size=" + this.size + ", format=" + this.format + ", description=" + this.description + ", artist=" + this.artist + ", title=" + this.title + ", modifyTime=" + this.modifyTime + ", id=" + this.id + ", album=" + this.album + ", duration=" + this.duration + ", loadStat=" + this.loadStat + ", doubanId=" + this.doubanId + ", doubanUrl=" + this.doubanUrl + ", posterUrl=" + this.posterUrl + ", lastPlayPosition=" + this.lastPlayPosition + ", lastPlayTime=" + this.lastPlayTime + ", nameVisble=" + this.nameVisble + ", category=" + this.category + ", isTitle=" + this.isTitle + "]";
    }
}
