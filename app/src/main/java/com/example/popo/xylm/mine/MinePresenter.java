package com.example.popo.xylm.mine;

import com.example.popo.xylm.data.beans.ChongZhi;
import com.example.popo.xylm.data.beans.CzDingDan;
import com.example.popo.xylm.data.beans.ZhiFu;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by TMVPHelper on 2018/08/07
 */
public class MinePresenter extends MineContract.Presenter {

    @Override
    public void getDataCz(Integer loginUserId) {
        m.getCzData(loginUserId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ChongZhi>() {
                    @Override
                    public void accept(ChongZhi chongZhi) throws Exception {
                        v.showChongZhi(chongZhi);
                    }
                });
    }

    @Override
    public void getDataCzDd(Integer buyerId, double price, Integer amount) {
        m.getCzDdData(buyerId, price, amount)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CzDingDan>() {
                    @Override
                    public void accept(CzDingDan czDingDan) throws Exception {
                        v.showCzDingDan(czDingDan);
                    }
                });
    }

    @Override
    public void getDataZhiFu(String orderNo) {
        m.getZhiFuData(orderNo)
                .subscribeOn(Schedulers.io())
                .retry()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ZhiFu>() {
                    @Override
                    public void accept(ZhiFu zhiFu) throws Exception {
                        v.showZhiFu(zhiFu);
                    }
                });
    }
}