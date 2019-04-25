package com.jack.testphoto.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.jack.testphoto.adapter.PhotoViewAdapter;
import com.jack.testphoto.bean.ImageListBean;
import com.jack.testphoto.widget.PhotoViewPager;
import com.jack.testphoto.R;

import java.util.List;

/**
 * 图片查看器
 */
public class PhotoViewActivity extends AppCompatActivity {
    private PhotoViewPager mViewPager;
    private int currentPosition;
    private PhotoViewAdapter adapter;
    private TextView mTvImageCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        getSupportActionBar().hide();
        initView();
        initData();
    }

    private void initView() {
        mViewPager = (PhotoViewPager) findViewById(R.id.view_pager_photo);
        mTvImageCount = (TextView) findViewById(R.id.tv_image_count);
    }

    private void initData() {
        Intent intent = getIntent();
        currentPosition = intent.getIntExtra("curPos", 0);
        ImageListBean dataBean = (ImageListBean) intent.getSerializableExtra("dataBean");
        List<String> mImgList = dataBean.getImg_urls();

        final int imgLen = mImgList.size();
        adapter = new PhotoViewAdapter(mImgList, this);
        mViewPager.setAdapter(adapter);
        mViewPager.setCurrentItem(currentPosition, false);
        mTvImageCount.setText(currentPosition + 1 + " /"  + imgLen);
        mViewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                currentPosition = position;
                mTvImageCount.setText(currentPosition + 1 + "/" + imgLen);
            }
        });
    }


}
