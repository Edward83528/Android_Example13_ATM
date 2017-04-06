package com.example.u0151051.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

//打開「content_finance.xml」，加入一個「ListView元件」並設定其ID值為「list」
//在Android中查詢SQLite資料庫時可透過SQLOpenHelper取得SQLDatabase物件後，呼叫rawQuery或query兩種方法，取得查詢結果「Cursor」物件
//Cursor是一個Java介面，代表一個查詢後的結果，透過它的方法，可指向結果中的其中一筆記錄
public class FinanceActivity extends AppCompatActivity {
    Toolbar toolbar;
    ListView lv;
    MyDBHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        lv = (ListView) findViewById(R.id.list);
       // helper = new MyDBHelper(this, "expense.db", null, 1);
        //使用rawQuery方法並傳入SQL查詢字串
       // Cursor cursor = helper.getReadableDatabase().query("main.exp", null, null, null, null, null, null);
        //ListView的資料來源若是查詢結果－「Cursor」物件時，可使用SimpleCursorAdapter建立Adapter物件
        //SimpleCursorAdapter((Context物件,在清單元件中的一列項目的版面配置資源,經過查詢語法得到的Cursor物件,資料來源的欄位名稱字串陣列,畫面中的資源ID值陣列,這個參數和ListView更新畫面中的項目資料有關(如果給「0」，代表ListView在展示過程中資料庫中的記錄如果被更動了，ListView將不自動重新查詢並更動畫面中的資料))
       // SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_expandable_list_item_2, cursor, new String[]{"info", "amount"}, new int[]{android.R.id.text1, android.R.id.text2}, 0);
       // lv.setAdapter(adapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //點浮動Button觸發的事件
                Intent intent5 = new Intent();
                intent5.setClass(FinanceActivity.this, Add2Activity.class);
                startActivity(intent5);
            }
        });
    }

}
