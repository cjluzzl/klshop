package cn.cjluzzl.klshop.activity;


import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

import cn.cjluzzl.klshop.R;

/**
 * Created by mac on 2017/10/10.
 */

public class FindActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_find);
    }
}
