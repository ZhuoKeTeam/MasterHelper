package com.team.zhuoke.masterhelper.model.test;

/**
 * Created by WangQing on 2016/12/7.
 */

public class TestList {


    /**
     * des : 生命不息，奋斗不止，万事起于忽微，量变引起质变
     * grade : 1
     * img : http://tva2.sinaimg.cn/crop.200.80.480.480.180/bca65a60gw1eiedwawzi2j20m80i57a7.jpg
     * info : http://blog.csdn.net/lmj623565791
     * isVip : true
     * name : hongyang
     * weiBo :
     * zhiHu :
     */

    private String des;
    private String grade;
    private String img;
    private String info;
    private boolean isVip;
    private String name;
    private String weiBo;
    private String zhiHu;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public boolean isIsVip() {
        return isVip;
    }

    public void setIsVip(boolean isVip) {
        this.isVip = isVip;
    }

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


    // 修改模板，快速生成
    @Override
    public String toString() {
        return "{" +
                "des:'" + des + '\'' +
                ", grade:'" + grade + '\'' +
                ", img:'" + img + '\'' +
                ", info:'" + info + '\'' +
                ", isVip:" + isVip +
                ", name:'" + name + '\'' +
                ", weiBo:'" + weiBo + '\'' +
                ", zhiHu:'" + zhiHu + '\'' +
                '}';
    }

    //    @Override
//    public String toString() {
//        return "MasterList{" +
//                "des='" + des + '\'' +
//                ", grade='" + grade + '\'' +
//                ", img='" + img + '\'' +
//                ", info='" + info + '\'' +
//                ", isVip=" + isVip +
//                ", name='" + name + '\'' +
//                ", weiBo='" + weiBo + '\'' +
//                ", zhiHu='" + zhiHu + '\'' +
//                '}';
//    }

}
