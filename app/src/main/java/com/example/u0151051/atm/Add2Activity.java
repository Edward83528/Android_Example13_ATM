package com.example.u0151051.atm;

import android.content.ContentValues;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Add2Activity extends AppCompatActivity {
    Button btn6;
    EditText et1, et2, et3;
    //宣告我們設計的 MyDBHelper類別
    private MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add2);
        //MyDBHelper(傳入Add2Activity本身, "資料庫名稱", (在此使用null,代表以標準模式SQLiteCursor處理Cursor),本應用程式目前資料庫版本)
        helper = new MyDBHelper(this, "expense.db", null, 1);
        findview();
    }

    void findview() {
        btn6 = (Button) findViewById(R.id.button6);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        et3 = (EditText) findViewById(R.id.editText3);
        btn6.setOnClickListener(clickListener);
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //取得畫面上使用者輸入的資料
            String cdate = et1.getText().toString();
            String info = et2.getText().toString();
            int amount = Integer.parseInt(et3.getText().toString());
            //收集一筆記錄的集合
            //使用ContentValues類別，就像是Java的Map集合類別，專門儲存Key-Value的一組對應資料組，其中Key鍵值使用欄位的名稱，Value則是該欄位的值
            ContentValues values = new ContentValues();
            values.put("cdate", cdate);
            values.put("into", info);
            values.put("amount", amount);
            //使用SQLiteDatabase的insert方法新增記錄至表格，第一個參數為表格名稱，第三個則是「資料包」
            //取得資料庫物件後呼叫insert方法，傳入表格名稱與values集合物件以新增這筆記錄，若成功會回傳新增記錄的id值
            //insert方法中的第二個參數可填入一個欄位名稱，如果設null,當第三個參數values內無任何資料時，會在該欄位上給予空值
            long id = helper.getWritableDatabase().insert("exp", null, values);
            //使用Log印出除錯資訊
            Log.d("ADD", id + "");
        }
    };
}
