package com.example.pc.loiandroid;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Blob;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final String DATABASE_NAME = "Database.sqlite";
    SQLiteDatabase database;

    ListView lvThucUong;
    ArrayList<ThucUong> dsThucUong;
    AdapterThucUong adapterThucUong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
        readData();
    }

    private void readData() {
        database = DataBase.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * FROM ThucUong", null);
        Toast.makeText(MainActivity.this, "read", Toast.LENGTH_SHORT).show();
        dsThucUong.clear();
        for(int i = 0; i < cursor.getCount(); i++){
            cursor.moveToPosition(i);
//            int id = cursor.getInt(0);
  //          String ten = cursor.getString(0);
            String note = cursor.getString(1);
            byte [] anh = cursor.getBlob(2);
           // dsThucUong.add(new ThucUong(ten, note));
        }

        adapterThucUong.notifyDataSetChanged();



    }


    private void addControls() {
        lvThucUong = findViewById(R.id.lvThucUong);
        dsThucUong = new ArrayList<>();
        adapterThucUong = new AdapterThucUong(MainActivity.this, R.layout.items, dsThucUong);
        lvThucUong.setAdapter(adapterThucUong);
    }

}
