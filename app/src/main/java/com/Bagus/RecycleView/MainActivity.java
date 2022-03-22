package com.Bagus.RecycleView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    ArrayList<ItemModel> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        data = new ArrayList<>();
        for (int i = 0; i < MyItem.Headline.length; i++) {
            data.add(new ItemModel(
                    MyItem.Headline[i],
                    MyItem.Subhead[i],
                    MyItem.iconList[i]
            ));
        }

        showList();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_list) {
            showList();
        } else if (item.getItemId() == R.id.menu_grid) {
            showGrid();
        }
        return true;
    }

    private void showList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        AdapterList adapterList = new AdapterList(data);
        recyclerView.setAdapter(adapterList);
    }

    private void showGrid() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        AdapterGrid adapterGrid = new AdapterGrid(data);
        recyclerView.setAdapter(adapterGrid);
    }
}
