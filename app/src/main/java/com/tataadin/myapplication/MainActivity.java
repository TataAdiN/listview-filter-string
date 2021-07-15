package com.tataadin.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tataadin.myapplication.adapters.ListAdapter;
import com.tataadin.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding viewBinding = ActivityMainBinding.inflate(getLayoutInflater());

        ArrayList<String> names = new ArrayList<>();
        names.add("Mitch");
        names.add("Blake");
        names.add("Shelly");
        names.add("Jess");
        names.add("Steve");
        names.add("Mohammed");

        ListAdapter adapter = new ListAdapter(names);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        viewBinding.theList.setLayoutManager(mLayoutManager);
        viewBinding.theList.setItemAnimator(new DefaultItemAnimator());

        viewBinding.theList.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        viewBinding.theList.addItemDecoration(dividerItemDecoration);
        setContentView(viewBinding.getRoot());
    }

}
