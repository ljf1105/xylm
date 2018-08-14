package com.example.popo.xylm.mine;

import com.example.popo.xylm.base.BaseModel;
import com.example.popo.xylm.base.BasePresenter;
import com.example.popo.xylm.base.BaseView;
import com.example.popo.xylm.data.beans.ChongZhi;
import com.example.popo.xylm.data.beans.CzDingDan;
import com.example.popo.xylm.data.beans.ZhiFu;

import io.reactivex.Observable;

/**
 * Created by popo on 2018/8/7.
 */

public class MineContract {

    public interface View extends BaseView {
        void showChongZhi(ChongZhi chongZhi);
        void showCzDingDan(CzDingDan czDingDan);
        void showZhiFu(ZhiFu zhiFu);
    }

    public interface Model extends BaseModel {
        Observable<ChongZhi> getCzData(Integer loginUserId);
        Observable<CzDingDan> getCzDdData(Integer buyerId,double price,Integer amount);
        Observable<ZhiFu> getZhiFuData(String orderNo);
    }

    public abstract static class Presenter extends BasePresenter<Model, View> {
        public abstract void getDataCz(Integer loginUserId);
        public abstract void getDataCzDd(Integer buyerId,double price,Integer amount);
        public abstract void getDataZhiFu(String orderNo);
    }
}