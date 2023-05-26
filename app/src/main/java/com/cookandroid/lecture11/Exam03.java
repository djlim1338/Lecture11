package com.cookandroid.lecture11;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Exam03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam03);
        setTitle("13~17 리스트뷰 추가 삭제");

        final ArrayList<String> midList = new ArrayList<String>();
        ListView list = (ListView) findViewById(R.id.listView1);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, midList);
        //        android.R.layout.simple_list_item_single_choice, midList);
        //list.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        list.setAdapter(adapter);

        final EditText edtItem = (EditText) findViewById(R.id.edtItem);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                midList.add(edtItem.getText().toString());
                edtItem.setText(null);
                adapter.notifyDataSetChanged();
            }
        });

        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                midList.remove(arg2);
                adapter.notifyDataSetChanged();
                return false;
            }
        });

    }

}
