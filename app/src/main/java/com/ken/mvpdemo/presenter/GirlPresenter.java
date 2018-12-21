package com.ken.mvpdemo.presenter;

import com.ken.mvpdemo.bean.Girl;
import com.ken.mvpdemo.mode.GirlModeImlV;
import com.ken.mvpdemo.mode.IGirlMode;
import com.ken.mvpdemo.view.IGrilView;

import java.util.List;

public class GirlPresenter {

    //持有UI层的引用
    IGrilView iGrilView;

    //数据层的引用
    IGirlMode iGirlMode = new GirlModeImlV();

    public GirlPresenter(IGrilView iGrilView) {
        this.iGrilView = iGrilView;
    }

    public void fectch() {
        iGrilView.showLoading();
        if (iGirlMode != null) {
            iGirlMode.loaddata(new IGirlMode.GirlOnLoadlitener() {
                @Override
                public void complete(List<Girl> list) {
                    //回调视图层
                    iGrilView.showGrils(list);
                }
            });
        }
    }
}
