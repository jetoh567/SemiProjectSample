package com.example.semiprojectsample.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.semiprojectsample.R;

public class LoginActivity extends AppCompatActivity { // 여기서 this는 LoginActivity를 의미함. this ==> LoginActivity ==> Context ==> getBaseContext()

    // 멤버변수 자리
    private EditText mEdtId, mEdtPw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEdtId = findViewById(R.id.edtId);
        mEdtPw = findViewById(R.id.edtPw);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnJoin = findViewById(R.id.btnJoin);
        btnLogin.setOnClickListener(mBtnLoginClick);
        btnJoin.setOnClickListener(mBtnJoinClick);
    }// end OnCreate()

    // 로그인 버튼 클릭 이벤트
    private View.OnClickListener mBtnLoginClick = new View.OnClickListener() { //ctrl+space bar 하면 자동완성 뜸 // 여기서 this는 View를 의미함(익명클래스)
        @Override
        public void onClick(View view) {
            //Intent i = new Intent(LoginActivity.this, JoinActivity.class); // JoinActivity로 이동
            //startActivity(i);
        }
    };

    // 회원가입 버튼 클릭 이벤트
    private View.OnClickListener mBtnJoinClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(LoginActivity.this, CameraCapture2Activity.class); // JoinActivity로 이동
            startActivity(i);
        }
    };
}
