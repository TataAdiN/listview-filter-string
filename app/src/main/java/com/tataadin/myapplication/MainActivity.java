package com.tataadin.myapplication;

import android.os.Bundle;
import android.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tataadin.myapplication.adapters.ListAdapter;
import com.tataadin.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding viewBinding = ActivityMainBinding.inflate(getLayoutInflater());

        List<String> people = new ArrayList<>();
        people.add("Mitch");
        people.add("Blake");
        people.add("Shelly");
        people.add("Jess");
        people.add("Steve");
        people.add("Mohammed");


        ListAdapter adapter = new ListAdapter(people);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        viewBinding.theList.setHasFixedSize(true);
        viewBinding.theList.setLayoutManager(mLayoutManager);
        viewBinding.theList.setAdapter(adapter);
        viewBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        setContentView(viewBinding.getRoot());
    }

}
