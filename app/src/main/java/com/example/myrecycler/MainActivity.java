package com.example.myrecycler;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    private String[] names = {
            "Mount Kilimanjaro", "Manyara Park", "A snip of Serengeti National park", "Serengeti national park zebras",
    "Mbeya landscapes", "Waterfalls"};
    private int[] images = {
            R.drawable.mnt_kilimanjaro, R.drawable.tz_manyara_park, R.drawable.serengeti_snip, R.drawable.serengeti_zebras,
            R.drawable.landscape1, R.drawable.tz_waterfall
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        setTitle("Tourist Attractions in Tanzania");


        recyclerView = findViewById(R.id.recyclerView);

        // RecyclerView setup
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Item> itemList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            itemList.add(new Item(names[i], images[i]));
        }
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(itemList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
