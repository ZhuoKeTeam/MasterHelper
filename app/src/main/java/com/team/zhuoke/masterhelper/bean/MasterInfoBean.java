package com.team.zhuoke.masterhelper.bean;

import java.util.List;

/**
 * Created by WangQing on 2016/11/28.
 */

public class MasterInfoBean {

    /**
     * code : 200
     * data : [{"des":"生命不息，奋斗不止，万事起于忽微，量变引起质变","grade":"1","img":"http://tva2.sinaimg.cn/crop.200.80.480.480.180/bca65a60gw1eiedwawzi2j20m80i57a7.jpg","info":"http://blog.csdn.net/lmj623565791","isVip":true,"name":"hongyang","weiBo":"","zhiHu":""},{"des":"有创新精神的Android技术分享者","grade":"2","img":"http://tva4.sinaimg.cn/crop.0.0.474.474.180/04f2c14egw1emsvenwld6j20d70d741l.jpg","info":"http://blog.csdn.net/singwhatiwanna/article/details/49560409/","isVip":true,"name":"任玉刚","weiBo":"http://weibo.com/uc83018062","zhiHu":""},{"des":"android | trinea.cn | codekk.com | github.com/trinea","grade":"3","img":"http://tva3.sinaimg.cn/crop.110.4.421.421.180/6630ff83gw1e9ncep47s9j20hs0bvabw.jpg","info":"http://weibo.com/trinea","isVip":true,"name":"Trinea","weiBo":"","zhiHu":""},{"des":"就职于腾讯，个人网站hukai.me","grade":"4","img":"http://tva2.sinaimg.cn/crop.91.0.800.800.180/65b2cf57jw8eusx68amhsj20or0m87ew.jpg","info":"http://weibo.com/u/1706217303","isVip":true,"name":"胡凯","weiBo":"","zhiHu":""},{"des":"每当你在感叹，如果有这样一个东西就好了的时候，请注意，其实这是你的机会","grade":"5","img":"http://avatar.csdn.net/8/B/B/1_sinyu890807.jpg","info":"http://blog.csdn.net/guolin_blog/ ","isVip":true,"name":"郭霖","weiBo":"","zhiHu":""}]
     * msg :
     */

    private String code;
    private String msg;
    private List<DataBean> data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
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
    }

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", msg:'" + msg + '\'' +
                ", data:" + data +
                '}';
    }
}
