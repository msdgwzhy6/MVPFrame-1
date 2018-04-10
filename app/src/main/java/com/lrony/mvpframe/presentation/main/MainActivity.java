package com.lrony.mvpframe.presentation.main;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lrony.mvpframe.R;
import com.lrony.mvpframe.mvp.MvpActivity;

public class MainActivity extends MvpActivity<MainContract.Presenter> implements MainContract.View, View.OnClickListener {

    private static final String TAG = "MainActivity";

    private Button mBtnGetData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        // Must use
        getPresenter().start();
    }

    private void initView() {
        mBtnGetData = findViewById(R.id.btn_get_data);
        bindOnClickLister(this, mBtnGetData);
    }

    @NonNull
    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void setBtnGetDataEnabled(boolean enabled) {
        mBtnGetData.setEnabled(enabled);
    }

    @Override
    public void showData(String data) {
        showToast(data);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_get_data:
                getPresenter().getData();
                break;
        }
    }
}