package com.ahnsafety.ex20listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    //Adapter객체 참조변수
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView= findViewById(R.id.listview);

        //리스트뷰에 보여질 View객체들을 만들어내는
        //작업을 수행하는 Adapter 객체 생성
        adapter= ArrayAdapter.createFromResource(this, R.array.datas, R.layout.list_item);
        //리스트뷰에 아답터객체를 연결
        listView.setAdapter(adapter);



        //리스트뷰의 항목(item)을 클릭하는 것을
        //듣는 리스너 객체 생성 및 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                //res폴더 안에 있는 values폴더 안에
                //arrays.xml안에 작성한 datas라는 이름의
                //String배열을 참조하기

                //res창고관리자 소환
                Resources res= MainActivity.this.getResources();

                //창고관리자에게 arrays.xml문서 안에 있는
                //datas라는 이름의 배열객체 얻어오기
                String[] arr= res.getStringArray(R.array.datas);


                Toast.makeText(MainActivity.this, arr[position], Toast.LENGTH_SHORT).show();

            }
        });

        //아이템 롱클릭 리스너 생성 및 설정
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {

                Toast.makeText(MainActivity.this, "long click", Toast.LENGTH_SHORT).show();

                return true;
            }
        });


    }
}
