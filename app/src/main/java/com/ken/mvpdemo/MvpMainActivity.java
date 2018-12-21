package com.ken.mvpdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.Toast;

import com.ken.mvpdemo.adapter.GirlListAdapter;
import com.ken.mvpdemo.base.BaseAcivity;
import com.ken.mvpdemo.bean.Girl;
import com.ken.mvpdemo.presenter.GirlPresenter;
import com.ken.mvpdemo.presenter.MvpGirlPresenter;
import com.ken.mvpdemo.view.IGrilView;

import java.util.List;

public class MvpMainActivity extends BaseAcivity<IGrilView, MvpGirlPresenter<IGrilView>> implements IGrilView {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        mPresenter.fectch();
    }

    @Override
    protected MvpGirlPresenter<IGrilView> createPresenter() {
        return new MvpGirlPresenter<>(this);
    }


    @Override
    public void showLoading() {
        Toast.makeText(this, "正在加载中...", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGrils(List<Girl> grils) {
        listView.setAdapter(new GirlListAdapter(this, grils));
    }
}
