package com.team.zhuoke.masterhelper.fragment;

import java.util.List;

/**
 * Created by renxl
 * On 2017/4/22 15:36.
 */

public class BaseBean<T> {


    /**
     * code : 0
     * message : ok
     * result : [{"id":14,"uid":1246141947,"name":"lmj623565791","nick_name":"Hongyang","des":"生命不息，奋斗不止，万事起于忽微，量变引起质变","article_title":"Android UI性能优化 检测应用中的UI卡顿","article_address":"http://blog.csdn.net/lmj623565791/article/details/60874334"}]
     */

    private int code;
    private String message;
    private List<T> result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> datas) {
        this.result = datas;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", datas=" + result +
                '}';
    }
}
