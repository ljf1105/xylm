package com.example.popo.xylm.base;

/**
 * Created by popo on 2018/7/26.
 */

public class BasePresenter<M, V> {
    public M m;
    public V v;

    public void setMV(M m,V v) {
        this.m = m;
        this.v = v;
    }

}
