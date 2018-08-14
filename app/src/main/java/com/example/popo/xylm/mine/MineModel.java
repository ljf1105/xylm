package com.example.popo.xylm.mine;

import com.example.popo.xylm.data.beans.ChongZhi;
import com.example.popo.xylm.data.beans.CzDingDan;
import com.example.popo.xylm.data.beans.ZhiFu;
import com.example.popo.xylm.utils.RetrofitUtils;

import io.reactivex.Observable;

/**
* Created by TMVPHelper on 2018/08/07
*/
public class MineModel implements MineContract.Model{

    @Override
    public Observable<ChongZhi> getCzData(Integer loginUserId) {
        return RetrofitUtils.getInstance().getMineService().getCzList(loginUserId);
    }

    @Override
    public Observable<CzDingDan> getCzDdData(Integer buyerId, double price, Integer amount) {
        return RetrofitUtils.getInstance().getMineService().getCzDingDan(buyerId,price,amount);
    }

    @Override
    public Observable<ZhiFu> getZhiFuData(String orderNo) {
        return RetrofitUtils.getInstance().getMineService().getCzDingDan(orderNo);
    }


}