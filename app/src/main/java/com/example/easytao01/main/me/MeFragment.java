package com.example.easytao01.main.me;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytao01.R;
import com.example.easytao01.commons.ActivityUtils;
import com.example.easytao01.user.login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的页面
 */

public class MeFragment extends Fragment {
    @BindView(R.id.tv_login)
    TextView tv_login;
    private View view;
    private ActivityUtils activityUtils;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view==null){
             view = inflater.inflate(R.layout.fragment_me, container, false);
            ButterKnife.bind(this,view);
            activityUtils=new ActivityUtils(this);
        }
        return view;
    }
  @OnClick({R.id.tv_person_info,R.id.tv_goods_upload,R.id.tv_person_goods})
    public void OnClick(View v){
      activityUtils.startActivity(LoginActivity.class);
  }
}
