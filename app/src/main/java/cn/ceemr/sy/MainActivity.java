package cn.ceemr.sy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridView gridview = (GridView) findViewById(R.id.GridView);
        ArrayList<HashMap<String, Object>> meumList = new ArrayList<HashMap<String, Object>>();

        for(int i = 1;i < 7;i++) {
            HashMap<String, Object> map = new HashMap<String, Object>();
            String iconame = "ico_"+i;
            map.put("ItemImage",R.mipmap.ico_2);
            map.put("ItemText", "NO."+i);
            meumList.add(map);
        }

        SimpleAdapter saMenuItem = new SimpleAdapter(this,
                meumList, //数据源
                R.layout.grid_item, //xml实现
                new String[]{"ItemImage","ItemText"}, //对应map的Key
                new int[]{R.id.ItemImage,R.id.ItemText});  //对应R的Id
        // 添加Item到网格中
        gridview.setAdapter(saMenuItem);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                System.out.println("click index:"+arg2);
            }
        });
    }
}
