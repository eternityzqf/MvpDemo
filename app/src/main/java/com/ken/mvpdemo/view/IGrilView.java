package com.ken.mvpdemo.view;


import com.ken.mvpdemo.bean.Girl;

import java.util.List;

/**
 * Created by Administrator on 2017/3/3 0003.
 */

public interface IGrilView {
    /**
     * UI业务逻辑   加载进度条
     */
    void showLoading();

    void showGrils(List<Girl> grils);
}
