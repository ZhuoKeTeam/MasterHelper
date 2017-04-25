package com.team.zhuoke.masterhelper.fragment;

/**
 * Created by renxl
 * On 2017/4/22 15:38.
 */

public class ArticleInfoBean {

    /**
     * id : 14
     * uid : 1246141947
     * name : lmj623565791
     * nick_name : Hongyang
     * des : 生命不息，奋斗不止，万事起于忽微，量变引起质变
     * article_title : Android UI性能优化 检测应用中的UI卡顿
     * article_address : http://blog.csdn.net/lmj623565791/article/details/60874334
     */

    private int id;
    private long uid;
    private String name;
    private String nick_name;
    private String des;
    private String article_title;
    private String article_address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_address() {
        return article_address;
    }

    public void setArticle_address(String article_address) {
        this.article_address = article_address;
    }

    @Override
    public String toString() {
        return "ArticleInfoBean{" +
                "id=" + id +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", nick_name='" + nick_name + '\'' +
                ", des='" + des + '\'' +
                ", article_title='" + article_title + '\'' +
                ", article_address='" + article_address + '\'' +
                '}';
    }
}
