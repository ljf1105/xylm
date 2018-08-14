package com.example.popo.xylm.ui.fragment.shouyemodule;

import com.example.popo.xylm.base.BaseModel;
import com.example.popo.xylm.base.BasePresenter;
import com.example.popo.xylm.base.BaseView;
import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;

import io.reactivex.Observable;


/**
 * Created by popo on 2018/7/30.
 */

public class HomeContract {

    public interface View extends BaseView {
        void showWorks(HomeWorks homeWorks);
        void showImages(ShowImage showImage);
        void showYkHome(YkHome ykHome);
        void showMshi(MingTeacher mingTeacher);
        void showLive(LiveBean liveBean);
        void showWorkXq(WorkXq workXq);
        void showWorkComment(Comment comment);
    }

    public interface Model extends BaseModel {
        Observable<HomeWorks> getDataWorks(Integer sortord);
        Observable<ShowImage> getDataTeaImg();
        Observable<YkHome> getDataYkHome(Integer sortord);
        Observable<MingTeacher> getDataMshi(Integer userType);
        Observable<LiveBean> getDataLive(String type);
        Observable<WorkXq> getDataWorkXq(Integer homewokId);
        Observable<Comment> getDataWorkComment(Integer homewokId);
    }

    public abstract static class Presenter extends BasePresenter<Model, View> {
        public abstract void getWorksData(Integer sortord);
        public abstract void getImgTeaData();
        public abstract void getYkHomeData(Integer sortord);
        public abstract void getMshiData(Integer userType);
        public abstract void getLiveData(String type);
        public abstract void getWorkXqData(Integer homewokId);
        public abstract void getWorkConmmentData(Integer homewokId);
    }
}