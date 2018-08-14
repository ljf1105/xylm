package com.example.popo.xylm.ui.fragment.shouyemodule;

import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TMVPHelper on 2018/07/30
 */
public class HomePresenter extends HomeContract.Presenter {


    @Override
    public void getWorksData(Integer sortord) {
        m.getDataWorks(sortord)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<HomeWorks>() {
                    @Override
                    public void accept(HomeWorks homeWorks) throws Exception {
                        v.showWorks(homeWorks);
                    }
                });
    }

    @Override
    public void getImgTeaData() {
        m.getDataTeaImg()
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowImage>() {
                    @Override
                    public void accept(ShowImage showImage) throws Exception {
                        v.showImages(showImage);
                    }
                });
    }

    @Override
    public void getYkHomeData(Integer sortord) {
        m.getDataYkHome(sortord)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<YkHome>() {
                    @Override
                    public void accept(YkHome ykHome) throws Exception {
                        v.showYkHome(ykHome);
                    }
                });
    }

    @Override
    public void getMshiData(Integer userType) {
        m.getDataMshi(userType)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MingTeacher>() {
                    @Override
                    public void accept(MingTeacher mingTeacher) throws Exception {
                        v.showMshi(mingTeacher);
                    }
                });
    }

    @Override
    public void getLiveData(String type) {
        m.getDataLive(type)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<LiveBean>() {
                    @Override
                    public void accept(LiveBean liveBean) throws Exception {
                        v.showLive(liveBean);
                    }
                });
    }

    @Override
    public void getWorkXqData(Integer homewokId) {
        m.getDataWorkXq(homewokId)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WorkXq>() {
                    @Override
                    public void accept(WorkXq workXq) throws Exception {
                        v.showWorkXq(workXq);
                    }
                });
    }

    @Override
    public void getWorkConmmentData(Integer homewokId) {
        m.getDataWorkComment(homewokId)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Comment>() {
                    @Override
                    public void accept(Comment comment) throws Exception {
                        v.showWorkComment(comment);
                    }
                });
    }


}