package com.ken.mvpdemo.mode;

import com.ken.mvpdemo.bean.Girl;

import java.util.List;

/**
 * 监听数据返回
 */
public interface IGirlMode {

    void loaddata(GirlOnLoadlitener girlOnLoadlitener);

    interface GirlOnLoadlitener {
        void complete(List<Girl> list);
    }
}
