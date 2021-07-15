package com.tataadin.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tataadin.myapplication.databinding.ListItemLayoutBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {

    private static final String TAG = "ListAdapter";
    List<String> movieList;
    private ListItemLayoutBinding binding;

    public ListAdapter(List<String> movieList){
        this.movieList = movieList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(View view){
            super(view);
        }
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ListItemLayoutBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    @Override
    public Filter getFilter() {
        return null;
    }
}
