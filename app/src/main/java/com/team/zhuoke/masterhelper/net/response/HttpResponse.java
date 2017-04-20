package com.team.zhuoke.masterhelper.net.response;

/**
 *  作者：gaoyin
 *  电话：18810474975
 *  邮箱：18810474975@163.com
 *  版本号：1.0
 *  类描述： 约定服务器公共的json数据
 *  备注消息：
 *  修改时间：2016/11/23 下午5:52
 **/
public class HttpResponse<T> {

     private String code ;

    private T result;

     private String message;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                "code:'" + code + '\'' +
                ", result:" + result +
                ", message:'" + message + '\'' +
                '}';
    }
}
