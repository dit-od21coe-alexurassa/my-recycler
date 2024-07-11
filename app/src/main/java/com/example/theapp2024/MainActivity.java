package com.example.theapp2024;

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

    private String[] names = {"Brian", "David", "Ian", "Kelvin", "Rachel", "Anna", "James", "Emily", "Sophia", "Michael"};
    private int[] images = {
            R.drawable.brian, R.drawable.david, R.drawable.ian, R.drawable.kelvin, R.drawable.rachel,
            R.drawable.anna, R.drawable.james, R.drawable.emily, R.drawable.sophia, R.drawable.michael
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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
