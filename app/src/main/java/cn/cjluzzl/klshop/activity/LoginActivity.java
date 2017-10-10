package cn.cjluzzl.klshop.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import cn.cjluzzl.klshop.MainActivity;
import cn.cjluzzl.klshop.R;

/**
 * Created by mac on 2017/10/9.
 */

public class LoginActivity extends Activity{
    FrameLayout frameLayout;
    ImageButton close;
    Button login;
    RadioGroup rgLogin, rgTip;
    RadioButton rbEmail, rbCode;
    Button rbFind, rbRegister;
    String userName,pwd;
    EditText etUsername, etPwd;

    String phoneNumber;
    String code;
    EditText etPhoneNumber, etCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        close = (ImageButton) findViewById(R.id.ibtn_login_close);
        frameLayout = (FrameLayout) findViewById(R.id.fl_login_way);
        rgLogin = (RadioGroup) findViewById(R.id.rg_login_choose_way);


        login = (Button) findViewById(R.id.btn_login_login);

        rbEmail = (RadioButton) findViewById(R.id.rb_login_email);
        rbCode = (RadioButton) findViewById(R.id.rb_login_code);
        rbFind = (Button) findViewById(R.id.rb_login_find_pwd);
        rbRegister = (Button) findViewById(R.id.rb_login_register);

        View view = View.inflate(LoginActivity.this, R.layout.frame_email, null);
        etUsername = (EditText) view.findViewById(R.id.et_login_username);
        etPwd = (EditText) view.findViewById(R.id.et_login_pwd);
        frameLayout.addView(view);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        rgLogin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                frameLayout.removeAllViews();
                if(checkedId == R.id.rb_login_email){
                    rbEmail.setBackgroundColor(0xFF0);
                    rbCode.setBackgroundColor(0xFFF);
                    View view = View.inflate(LoginActivity.this, R.layout.frame_email, null);
                    etUsername = (EditText) view.findViewById(R.id.et_login_username);
                    etPwd = (EditText) view.findViewById(R.id.et_login_pwd);
                    frameLayout.addView(view);
                }
                if(checkedId == R.id.rb_login_code){
                    rbEmail.setBackgroundColor(0xFFF);
                    rbCode.setBackgroundColor(0xFF0);
                    View view = View.inflate(LoginActivity.this, R.layout.frame_code, null);
                    etPhoneNumber = (EditText) view.findViewById(R.id.et_login_phone_number);
                    etCode = (EditText) view.findViewById(R.id.et_login_code);
                    frameLayout.addView(view);
                }
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rgLogin.getCheckedRadioButtonId() == R.id.rb_login_email){
                    userName = etUsername.getText().toString();
                    pwd = etPwd.getText().toString();
                    Toast.makeText(LoginActivity.this, userName+","+pwd, Toast.LENGTH_SHORT).show();
                }
                if(rgLogin.getCheckedRadioButtonId() == R.id.rb_login_code){
                    phoneNumber = etPhoneNumber.getText().toString();
                    code = etCode.getText().toString();
                    Toast.makeText(LoginActivity.this, phoneNumber+","+code, Toast.LENGTH_SHORT).show();
                }
            }
        });

        rbFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, FindActivity.class);
                startActivity(intent);
            }
        });

        rbRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
