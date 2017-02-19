package com.example.easytao01.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easytao01.R;
import com.example.easytao01.main.me.MeFragment;
import com.example.easytao01.main.shop.ShopFragment;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static com.example.easytao01.R.id.tv_title;

public class MainActivity extends AppCompatActivity {



    @BindViews({R.id.tv_shop,R.id.tv_message,R.id.tv_mail_list,R.id.tv_me})
    TextView[] textViews;
    @BindView(R.id.tv_title)
    TextView tv_title;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();

    }

    void init() {
        viewPager.setAdapter(nolodingAdapter);
        textViews[0].setSelected(true);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                for (TextView textView : textViews) {
                    textView.setSelected(false);
                }
                tv_title.setText(textViews[position].getText());
                textViews[position].setSelected(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*点击2次退出程序*/
    private boolean isExit = false;

    @Override
    public void onBackPressed() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            //两秒再次点击返回则退出
            //两秒内没有点击返回，则把isExit设置为false
            viewPager.postDelayed(new Runnable() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
        } else {
            finish();
        }
    }
    private FragmentStatePagerAdapter nolodingAdapter=new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new ShopFragment();
                case 1:
                    return new NoLoginFragment();
                case 2:
                    return new NoLoginFragment();
                case 3:
                    return new MeFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    };
    //底部四个Textview点击事件
    @SuppressWarnings("unused")
    @OnClick({R.id.tv_shop, R.id.tv_message, R.id.tv_mail_list, R.id.tv_me})
    public void onClick(TextView view) {
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].setSelected(false);
            textViews[i].setTag(i);
        }
        view.setSelected(true);
        // 参数false代表瞬间切换，而不是平滑过渡
        viewPager.setCurrentItem((Integer) view.getTag(), false);
        tv_title.setText(textViews[(Integer) view.getTag()].getText());
    }
}
