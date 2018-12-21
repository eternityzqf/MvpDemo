package com.ken.mvpdemo.base;

import java.lang.ref.WeakReference;

/**
 * @param <T> 对应每个Activity的UI Presnter
 */
public abstract class BasePresenter<T> {

    /**
     * 持有UI接口的弱引用
     */
    protected WeakReference<T> mWeakReference;

    /**
     * 绑定UI对象引用
     */
    public void attachView(T view) {
        mWeakReference = new WeakReference<T>(view);
    }

    /**
     * 加载数据
     */
    public abstract void fectch();

    /**
     * 解绑UI的引用对象
     */
    public void dettach() {
        if (mWeakReference != null) {
            mWeakReference.clear();
            mWeakReference = null;
        }
    }
}
