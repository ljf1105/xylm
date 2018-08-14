package com.example.popo.xylm.ui.fragment.shouyemodule;

import com.example.popo.xylm.data.banner.ShowImage;
import com.example.popo.xylm.data.beans.Comment;
import com.example.popo.xylm.data.beans.HomeWorks;
import com.example.popo.xylm.data.beans.LiveBean;
import com.example.popo.xylm.data.beans.MingTeacher;
import com.example.popo.xylm.data.beans.WorkXq;
import com.example.popo.xylm.data.beans.YkHome;
import com.example.popo.xylm.utils.RetrofitUtils;

import io.reactivex.Observable;

/**
* Created by TMVPHelper on 2018/07/30
*/
public class HomeModel implements HomeContract.Model{


    @Override
    public Observable<HomeWorks> getDataWorks(Integer sortord) {
        return RetrofitUtils.getInstance().getMineService().homeWorkData(sortord);
    }

    @Override
    public Observable<ShowImage> getDataTeaImg() {
        return RetrofitUtils.getInstance().getMineService().ykShowImages();
    }

    @Override
    public Observable<YkHome> getDataYkHome(Integer sortord) {
        return RetrofitUtils.getInstance().getMineService().ykHome(sortord);
    }

    //名师列表
    @Override
    public Observable<MingTeacher> getDataMshi(Integer userType) {
        return RetrofitUtils.getInstance().getMineService().getTeacherList(userType);
    }

    //课程列表
    @Override
    public Observable<LiveBean> getDataLive(String type) {
        return RetrofitUtils.getInstance().getMineService().getLiveList(type);
    }

    @Override
    public Observable<WorkXq> getDataWorkXq(Integer homewokId) {
        return RetrofitUtils.getInstance().getMineService().workXqData(homewokId);
    }

    @Override
    public Observable<Comment> getDataWorkComment(Integer homewokId) {
        return RetrofitUtils.getInstance().getMineService().workComment(homewokId);
    }


}