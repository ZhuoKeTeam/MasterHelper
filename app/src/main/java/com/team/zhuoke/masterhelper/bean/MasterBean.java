package com.team.zhuoke.masterhelper.bean;

/**
 * Created by WangQing on 2016/11/23.
 */

public class MasterBean {
    private String name;
    private String weiBo;
    private String zhiHu;
    private String grade;
    private boolean isVip;
    private String info;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeiBo() {
        return weiBo;
    }

    public void setWeiBo(String weiBo) {
        this.weiBo = weiBo;
    }

    public String getZhiHu() {
        return zhiHu;
    }

    public void setZhiHu(String zhiHu) {
        this.zhiHu = zhiHu;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setVip(boolean vip) {
        isVip = vip;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "{" +
                "name:'" + name + '\'' +
                ", weiBo:'" + weiBo + '\'' +
                ", zhiHu:'" + zhiHu + '\'' +
                ", grade:'" + grade + '\'' +
                ", isVip:" + isVip +
                ", info:'" + info + '\'' +
                '}';
    }
}
