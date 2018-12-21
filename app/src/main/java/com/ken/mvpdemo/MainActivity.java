package com.ken.mvpdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.ken.mvpdemo.adapter.GirlListAdapter;
import com.ken.mvpdemo.bean.Girl;
import com.ken.mvpdemo.presenter.GirlPresenter;
import com.ken.mvpdemo.view.IGrilView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IGrilView {
    ListView listView;
    GirlPresenter girlPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listview);
        //实例化P层 并抓取数据
        girlPresenter = new GirlPresenter(this);
        girlPresenter.fectch();
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
