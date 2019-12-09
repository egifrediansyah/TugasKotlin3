package com.android.tugaskotlin3.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.android.tugaskotlin3.Adapter.MenuAdapter;
import com.android.tugaskotlin3.Model.Menu;
import com.android.tugaskotlin3.R;

import java.util.ArrayList;
public class MenuActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 1;
    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        final ArrayList<Menu> homes = new ArrayList<>();
        homes.add(new Menu("KOPI A", R.drawable.st, 1200000, "5d"));
        homes.add(new Menu("KOPI B", R.drawable.st, 1000000, "5d"));
        homes.add(new Menu("KOPI C", R.drawable.st, 1200000, "4d"));
        homes.add(new Menu("KOPI D", R.drawable.st, 1200000, "4d"));
        homes.add(new Menu("KOPI E", R.drawable.st, 1200000, "7d"));

        adapter = new MenuAdapter(this, homes);

        // view yang akan diberikan adapter

        ListView orderListView = (ListView)
                findViewById(R.id.order_list_view);
        orderListView.setAdapter(adapter);

//
    }
}
