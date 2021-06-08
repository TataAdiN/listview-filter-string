package com.tataadin.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AppCompatActivity;
import com.tataadin.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding viewBinding;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());

        ArrayList<String> names = new ArrayList<>();
        names.add("Mitch");
        names.add("Blake");
        names.add("Shelly");
        names.add("Jess");
        names.add("Steve");
        names.add("Mohammed");

        adapter = new ArrayAdapter<>(this, R.layout.list_item_layout, names);
        viewBinding.theList.setAdapter(adapter);

        viewBinding.searchFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                (MainActivity.this).adapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }}
        );

        setContentView(viewBinding.getRoot());
    }

}
