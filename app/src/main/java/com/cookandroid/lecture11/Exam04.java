package com.cookandroid.lecture11;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Exam04 extends AppCompatActivity {

    //Map<Integer, String> posterInfo = new HashMap<Integer, String>();  // 일반 hashmap쓰니까 순서가 엉망임
    Map<Integer, String> posterInfo = new LinkedHashMap<Integer, String>();
    Integer[] posterID = new Integer[40];
    String[] posterTitle = new String[40];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exam04);
        setTitle("그리드뷰 영화 포스터");

        posterInfo.put(R.drawable.mov01, "토이스토리4");
        posterInfo.put(R.drawable.mov02, "호빗3");
        posterInfo.put(R.drawable.mov03, "제이슨 본");
        posterInfo.put(R.drawable.mov04, "반지의 제왕 3");
        posterInfo.put(R.drawable.mov05, "정직한 후보");
        posterInfo.put(R.drawable.mov06, "나쁜 녀석들");
        posterInfo.put(R.drawable.mov07, "겨울왕국 2");
        posterInfo.put(R.drawable.mov08, "알라딘");
        posterInfo.put(R.drawable.mov09, "극한직업");
        posterInfo.put(R.drawable.mov10, "스파이더맨");
        posterInfo.put(R.drawable.mov11, "레옹");
        posterInfo.put(R.drawable.mov12, "주먹왕 랄프2");
        posterInfo.put(R.drawable.mov13, "타짜");
        posterInfo.put(R.drawable.mov14, "걸캅스");
        posterInfo.put(R.drawable.mov15, "도굴");
        posterInfo.put(R.drawable.mov16, "어벤져스 엔드게임");
        posterInfo.put(R.drawable.mov17, "엑시트");
        posterInfo.put(R.drawable.mov18, "캡틴마블");
        posterInfo.put(R.drawable.mov19, "봉오동 전투");
        posterInfo.put(R.drawable.mov20, "분노의질주");
        posterInfo.put(R.drawable.mov21, "아바타");
        posterInfo.put(R.drawable.mov22, "힘을내요 미스터리");
        posterInfo.put(R.drawable.mov23, "포드v페라리");
        posterInfo.put(R.drawable.mov24, "쥬만지");
        posterInfo.put(R.drawable.mov25, "the god father 대부");
        posterInfo.put(R.drawable.mov26, "국가대표");
        posterInfo.put(R.drawable.mov27, "토이스토리3");
        posterInfo.put(R.drawable.mov28, "마당을 나온 암탉");
        posterInfo.put(R.drawable.mov29, "죽은 시인의 사회");
        posterInfo.put(R.drawable.mov30, "서유쌍기");
        posterInfo.put(R.drawable.mov31, "킹콩");
        posterInfo.put(R.drawable.mov32, "반지의 제왕");
        posterInfo.put(R.drawable.mov33, "이게뭐지");
        posterInfo.put(R.drawable.mov34, "미녀는 괴로워");
        posterInfo.put(R.drawable.mov35, "나홀로집에");
        posterInfo.put(R.drawable.mov36, "이건 또 뭐지");
        posterInfo.put(R.drawable.mov37, "더록");
        posterInfo.put(R.drawable.mov38, "..?");
        posterInfo.put(R.drawable.mov39, "매트릭스");
        posterInfo.put(R.drawable.mov40, "가위손");

        int counter = 0;
        for( Map.Entry<Integer, String> elem : posterInfo.entrySet() ){
            posterID[counter] = elem.getKey();
            posterTitle[counter] = elem.getValue();
            counter++;
        }

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }
    public class MyGridAdapter extends BaseAdapter {
        Context context;

        public MyGridAdapter(Context c) {
            context = c;
        }

        public int getCount() {
            return posterID.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        /*
        Integer[] posterID = { R.drawable.mov01, R.drawable.mov02,
                R.drawable.mov03, R.drawable.mov04, R.drawable.mov05,
                R.drawable.mov06, R.drawable.mov07, R.drawable.mov08,
                R.drawable.mov09, R.drawable.mov10, R.drawable.mov01,
                R.drawable.mov02, R.drawable.mov03, R.drawable.mov04,
                R.drawable.mov05, R.drawable.mov06, R.drawable.mov07,
                R.drawable.mov08, R.drawable.mov09, R.drawable.mov10,
                R.drawable.mov01, R.drawable.mov02, R.drawable.mov03,
                R.drawable.mov04, R.drawable.mov05, R.drawable.mov06,
                R.drawable.mov07, R.drawable.mov08, R.drawable.mov09,
                R.drawable.mov10 };

        String[] posterTitle = { "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보",
                "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
                "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보",
                "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨",
                "토이스토리4", "호빗3", "제이슨 본", "반지의 제왕 3","정직한 후보",
                "나쁜 녀석들", "겨울왕국 2", "알라딘", "극한직업", "스파이더맨"};
         */

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageview = new ImageView(context);
            imageview.setLayoutParams(new GridView.LayoutParams(200, 300));
            imageview.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageview.setPadding(5, 5, 5, 5);

            imageview.setImageResource(posterID[position]);

            final int pos = position;
            imageview.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(
                            Exam04.this, R.layout.exam04_dialog, null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(
                            Exam04.this);
                    ImageView ivPoster = (ImageView) dialogView
                            .findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterTitle[pos]);
                    dlg.setIcon(R.drawable.movie_icon);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageview;
        }

    }

}
