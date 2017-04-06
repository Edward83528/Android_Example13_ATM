package com.example.u0151051.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//1.設計一個ATM APP,我們先再新增兩個Activity
//第一個Activity(點投資理財進入畫面)File->new Activity-> Basic Activity->命名為FinanceActivity
//第二個Activity(投資理財畫面下點新增按鈕,出現新增資料的畫面)File->new Activity->Empty Activity->命名為Add2Activity
//2.在專案的java檔->com.底下新增名字為:MYDBHelper的class檔->讓MYDBHelper繼承SQLiteOpenHelper(Android提供實作好資料庫的類別)
//->實作SQLiteOpenHelper抽象類別的兩個抽象方法(onCreate/onUpgrade)和建立建構子(因為SQLiteOpenHelper有有參數的建構子,卻沒有無參數的建構子)
//3.SQLiteOpenHelper類別中可呼叫以下方法得到SQLiteDatabase物件：
//3.1:getReadableDatabase()方法(讀取資料庫的SQLiteDatabase物件，可用在查詢)
//3.2:getWritableDatabase()方法(擁有更新能力的SQLiteDatabase物件，用途為新增、修改或刪除)
public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findview();
    }

    void findview() {
        btn1 = (Button) findViewById(R.id.button);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        btn5 = (Button) findViewById(R.id.button5);
        btn1.setOnClickListener(c);
        btn2.setOnClickListener(c);
        btn3.setOnClickListener(c);
        btn4.setOnClickListener(c);
        btn5.setOnClickListener(c);
    }

    View.OnClickListener c = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:

                    break;
                case R.id.button2:

                    break;
                case R.id.button3:

                    break;
                //點投資理財觸發的事件
                case R.id.button4:
                    Intent intent = new Intent();
                    intent.setClass(MainActivity.this, FinanceActivity.class);
                    startActivity(intent);
                    break;
                case R.id.button5:

                    break;
            }

        }
    };
}
