package com.meowzv.zhihureader.bean;

import java.util.List;

/**
 * Created by luwang on 2016/12/6.
 */

public class BeforeEntity {
    /**
     * date : 20161204
     * stories : [{"images":["http://pic2.zhimg.com/1e42348462f288e944b44d60466afe85.jpg"],"type":0,"id":9036410,"ga_prefix":"120422","title":"小事 · 特大作弊事件"},{"images":["http://pic1.zhimg.com/6435b54c4df7403d7c7bedfb2c38ccf4.jpg"],"type":0,"id":8935528,"ga_prefix":"120421","title":"很奇怪，看这部片子的时候我老是想起另外一部"},{"images":["http://pic4.zhimg.com/4c2bf54fa59854ae5a06aaa8811aa2af.jpg"],"type":0,"id":9036241,"ga_prefix":"120420","title":"他们说，别瞎想了保命要紧；但是她，还想做母亲"},{"images":["http://pic3.zhimg.com/38704d6b95aae7f11f4f2ba4b18de2e6.jpg"],"type":0,"id":9030489,"ga_prefix":"120419","title":"「三年以上五年以下」，这些刑期都是怎么定的？"},{"images":["http://pic1.zhimg.com/47d296012e84e1a820824c85a7b690f0.jpg"],"type":0,"id":9031805,"ga_prefix":"120418","title":"阶级与性，低俗与高雅：是这个摇滚乐队的主题"},{"images":["http://pic4.zhimg.com/f64a7ce071f5cc70d6cfd6c4f8912d0f.jpg"],"type":0,"id":9036102,"ga_prefix":"120417","title":"知乎好问题 · 吐司有哪些吃法？"},{"images":["http://pic3.zhimg.com/a69910f8476829064f67230959ccaa9a.jpg"],"type":0,"id":9036013,"ga_prefix":"120416","title":"别只记得「满身油污，躺在车底」，机修工其实更像是医生"},{"images":["http://pic4.zhimg.com/1e6b4f7b7582e1b690b5ba8cf91fa6a7.jpg"],"type":0,"id":9031832,"ga_prefix":"120415","title":"没有同事和领导，自由职业者也可以保持前进的动力"},{"images":["http://pic1.zhimg.com/699e8d805389569a7456f3c19f750994.jpg"],"type":0,"id":9031837,"ga_prefix":"120414","title":"关于《你的名字。》，来看看大家都是如何评价的"},{"images":["http://pic2.zhimg.com/f5634263f022d83485299a4e25752741.jpg"],"type":0,"id":9030373,"ga_prefix":"120413","title":"谷歌地图如此大规模的 3D 建模，是怎么做到的？"},{"images":["http://pic2.zhimg.com/949e157ed06a37860bd2feacd99713c9.jpg"],"type":0,"id":9027623,"ga_prefix":"120412","title":"大误 · 像你这么厉害的，还有六个"},{"images":["http://pic2.zhimg.com/5a17569e2f2ac12a6b8a53b6effae5bd.jpg"],"type":0,"id":9030549,"ga_prefix":"120411","title":"一个旧时代的香甜：拔丝白果"},{"title":"近 20 年来，Apple 就是这样设计他们官网的","ga_prefix":"120410","images":["http://pic4.zhimg.com/8944b23c09101ec90baa50e06769e1bb.jpg"],"multipic":true,"type":0,"id":9021262},{"images":["http://pic3.zhimg.com/b4ef85b8de83e1e308044f5c176aaf56.jpg"],"type":0,"id":9029332,"ga_prefix":"120409","title":"男性遭受的家庭暴力，其实并不少"},{"images":["http://pic4.zhimg.com/214dd13665342895e6595e3d87b7a563.jpg"],"type":0,"id":9033659,"ga_prefix":"120408","title":"北大疫苗研发的新发现， 真的是个大突破"},{"images":["http://pic4.zhimg.com/0e9da2af2624929f487bc3a1ec223883.jpg"],"type":0,"id":9022214,"ga_prefix":"120407","title":"打游戏时很忙，黑屏时很闲，手机 CPU 是怎么调节的？"},{"images":["http://pic2.zhimg.com/57d77f5cd397ff247674f10078878125.jpg"],"type":0,"id":9019122,"ga_prefix":"120407","title":"天津有哪些值得一看的建筑？"},{"images":["http://pic4.zhimg.com/4d5e762945828b43eff5bcd8c5dd46cb.jpg"],"type":0,"id":9033841,"ga_prefix":"120407","title":"偷偷一瞥，发现身旁的妻子居然是个怪物"},{"images":["http://pic1.zhimg.com/1d36208f2b166d1d68a50b037072705c.jpg"],"type":0,"id":9034805,"ga_prefix":"120407","title":"读读日报 24 小时热门 TOP 5 · 我混进了裸贷 QQ 群"},{"images":["http://pic1.zhimg.com/b435e7ed9289eca0318a9529620788b0.jpg"],"type":0,"id":9028453,"ga_prefix":"120406","title":"瞎扯 · 如何正确地吐槽"}]
     */

    private String date;
    private List<StoriesBean> stories;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<StoriesBean> getStories() {
        return stories;
    }

    public void setStories(List<StoriesBean> stories) {
        this.stories = stories;
    }

    public static class StoriesBean {
        /**
         * images : ["http://pic2.zhimg.com/1e42348462f288e944b44d60466afe85.jpg"]
         * type : 0
         * id : 9036410
         * ga_prefix : 120422
         * title : 小事 · 特大作弊事件
         * multipic : true
         */

        private int type;
        private int id;
        private String ga_prefix;
        private String title;
        private boolean multipic;
        private List<String> images;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getGa_prefix() {
            return ga_prefix;
        }

        public void setGa_prefix(String ga_prefix) {
            this.ga_prefix = ga_prefix;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isMultipic() {
            return multipic;
        }

        public void setMultipic(boolean multipic) {
            this.multipic = multipic;
        }

        public List<String> getImages() {
            return images;
        }

        public void setImages(List<String> images) {
            this.images = images;
        }
    }
}
