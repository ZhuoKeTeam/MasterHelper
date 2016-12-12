package com.team.zhuoke.masterhelper.model.test;

import com.team.zhuoke.masterhelper.presenter.test.interfaces.FrescoDemoContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 2016/12/9.
 */

public class FrescoModel implements FrescoDemoContract.Model {

    @Override
    public List<String> girlList() {
        //  假数据 图片来源来自GankIo
        List<String> girlList = new ArrayList<>();
        girlList.add("http://ww3.sinaimg.cn/large/7a8aed7bgw1etlw75so1hj20qo0hsgpk.jpg");
        girlList.add("http://ww3.sinaimg.cn/large/7a8aed7bjw1eyd07uugyvj20qo0hqgom.jpg");
        girlList.add("http://ww1.sinaimg.cn/large/610dc034jw1fahy9m7xw0j20u00u042l.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034jw1fagrnmiqm1j20u011hanr.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034gw1fafmi73pomj20u00u0abr.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034gw1fac4t2zhwsj20sg0izahf.jpg");
        girlList.add("http://ww1.sinaimg.cn/large/7a8aed7bgw1esojpl5gmgj20qo0hstbs.jpg");
        girlList.add("http://ww1.sinaimg.cn/large/7a8aed7bgw1evdga4dimoj20qo0hsmzf.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/610dc034jw1fa8n634v0vj20u00qx0x4.jpg");
        girlList.add("http://ww3.sinaimg.cn/large/610dc034jw1fa7jol4pgvj20u00u0q51.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/610dc034gw1f9zjk8iaz2j20u011hgsc.jpg");
        girlList.add("http://ww4.sinaimg.cn/large/610dc034gw1fa0ppsw0a7j20u00u0thp.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/7a8aed7bgw1evuryc3xumj20qo0hr41d.jpg");
        girlList.add("http://ww3.sinaimg.cn/large/7a8aed7bjw1ezplg7s8mdj20xc0m8jwf.jpg");
        girlList.add("http://ww2.sinaimg.cn/large/610dc034jw1fa42ktmjh4j20u011hn8g.jpg");
        return girlList;
    }
}
