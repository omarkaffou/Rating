package com.example.rating;

import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.rating.adapter.StarAdapter;
import com.example.rating.beans.Star;
import com.example.rating.service.StarService;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {
    private List<Star> stars;
    private RecyclerView recyclerView;
    private StarAdapter starAdapter = null;
    StarService service = StarService.getInstance();
    private static final String TAG = "StarAdapter";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        stars = new ArrayList<>();
        init();
        recyclerView = findViewById(R.id.recycle_view); //insérer le code
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter(starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        starAdapter = new StarAdapter(this, service.findAll());
        recyclerView.setAdapter((RecyclerView.Adapter) starAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        MenuItem menuItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d(TAG, newText);
                return true;
            }
        });
        return true;
    }

    public void init() {
        service.create(new Star("kate bosworth", "http://www.stars- photos.com/resize.php?id=801", 3.5f));
        service.create(new Star("george clooney", "http://www.stars- photos.com/resize.php?id=1191", 3));
        service.create(new Star("michelle rodriguez", "http://www.stars- photos.com/resize.php?id=1120", 5));
        service.create(new Star("george clooney", "http://www.stars- photos.com/resize.php?id=1193", 1));
        service.create(new Star("louise bouroin", "http://www.stars- photos.com/resize.php?id=1185", 5));
        service.create(new Star("louise bouroin", "http://www.stars- photos.com/resize.php?id=1184", 1));
    }
}