package com.jack.testphoto.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jack.testphoto.R;
import com.jack.testphoto.bean.ImageListBean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void btnClick(View v) {
        List<String> mImgList = new ArrayList<>();
        mImgList.add("http://d.hiphotos.baidu.com/image/h%3D300/sign=d644f76b990a304e4d22a6fae1c9a7c3/ac4bd11373f0820271f4125045fbfbedab641b7e.jpg");
        mImgList.add("http://e.hiphotos.baidu.com/image/h%3D300/sign=59567c51990a304e4d22a6fae1c9a7c3/ac4bd11373f08202fee6996a45fbfbedab641b6a.jpg");
        mImgList.add("http://b.hiphotos.baidu.com/image/h%3D300/sign=ae797191731ed21b66c928e59d6fddae/b21bb051f81986181f970fe744ed2e738ad4e685.jpg");

        ImageListBean mData = new ImageListBean(1, "相册标题", mImgList);

        Intent intent = new Intent(this, PhotoViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("dataBean", mData);
        intent.putExtras(bundle);
        intent.putExtra("curPos", 0);

        startActivity(intent);
    }
}
