package com.ken.mvpdemo.presenter;

import com.ken.mvpdemo.base.BasePresenter;
import com.ken.mvpdemo.bean.Girl;
import com.ken.mvpdemo.mode.GirlModeImlV;
import com.ken.mvpdemo.mode.IGirlMode;
import com.ken.mvpdemo.view.IGrilView;

import java.util.List;

public class MvpGirlPresenter<T> extends BasePresenter<IGrilView> {
    /**
     * 持有视图层 UI接口的引用  此时的视图层Activity
     */
    IGrilView mGrilView;

    public MvpGirlPresenter(IGrilView mGrilView) {
        this.mGrilView = mGrilView;
    }

    /**
     * 持有模型Model的引用
     */
    IGirlMode girlModel = new GirlModeImlV();

    @Override
    public void fectch() {
        mGrilView.showLoading();
        if (girlModel != null) {
            girlModel.loaddata(new IGirlMode.GirlOnLoadlitener() {
                @Override
                public void complete(List<Girl> list) {
                    //回调视图层
                    mGrilView.showGrils(list);
                }
            });
        }
    }
}
