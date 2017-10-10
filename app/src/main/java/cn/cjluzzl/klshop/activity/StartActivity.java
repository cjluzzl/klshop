package cn.cjluzzl.klshop.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

import cn.cjluzzl.klshop.MainActivity;
import cn.cjluzzl.klshop.R;

/**
 * Created by mac on 2017/10/9.
 */

public class StartActivity extends Activity {
    RelativeLayout rlRoot;

    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_start);
        rlRoot = (RelativeLayout) findViewById(R.id.rl_start);
        startFlash();

        sp = getSharedPreferences("config", MODE_PRIVATE);

        Boolean isLogin = sp.getBoolean("isLogin",false);

        if (isLogin){//登陆了直接进入主页 main
            Intent intent = new Intent(StartActivity.this, MainActivity.class);

            startActivity(intent);
        }else{//未登陆进入登陆页面
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
        }

    }

    /**
     * 开始动画
     */

    private void startFlash(){
        AnimationSet set = new AnimationSet(false);
        //旋转动画设计

        RotateAnimation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);

        rotate.setDuration(2000);
        rotate.setFillAfter(true);

        //旋转动画设置
        ScaleAnimation scale = new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        //设置动画持续时间
        scale.setDuration(2000);
        //是否保持动画结束时的状态
        scale.setFillAfter(true);

        //渐变色动画设计（透明度变化）
        AlphaAnimation alpha = new AlphaAnimation(0,1);

        alpha.setDuration(3000);
        alpha.setFillAfter(true);

        set.addAnimation(rotate);
        set.addAnimation(scale);
        set.addAnimation(alpha);
        //为布局增加动画效果
        rlRoot.startAnimation(set);

    }
}
