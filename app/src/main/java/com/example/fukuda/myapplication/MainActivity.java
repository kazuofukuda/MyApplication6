package com.example.fukuda.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Map<String, String> 型の ArrayList を作成します
        ArrayList<Map<String, String>> list =  new ArrayList<Map<String, String>>();

        for (int i = 0; i < 10 ; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("main", "メイン " + String.valueOf(i));
            map.put("sub", "サブ " + String.valueOf(i));
            list.add(map);
        }

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                list,
                android.R.layout.simple_list_item_2,
                new String[] {"main", "sub"},
                new int[] {android.R.id.text1, android.R.id.text2}
        );

        ListView listView = (ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("UI_PARTS", "クリック " + String.valueOf(position));
            }
        });
    }
