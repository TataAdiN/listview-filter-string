package com.tataadin.myapplication.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tataadin.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> implements Filterable {

    List<String> peopleList;
    List<String> peopleListAll;

    public ListAdapter(List<String> peopleList){
        this.peopleList = peopleList;
        peopleListAll = new ArrayList<>(peopleList);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView peopleName;
        public ViewHolder(View view){
            super(view);
            peopleName = view.findViewById(R.id.people_name);
        }
    }

    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ViewHolder holder, int position) {
        Log.d("list2", peopleList.toString());
        String people = peopleList.get(position);
        Log.d("filter2", people);
        Log.d("position", ""+position);
        holder.peopleName.setText(people);
        holder.peopleName.setOnClickListener(v -> Toast.makeText(v.getContext(), people,Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return peopleList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }

    Filter filter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<String> filteredPeople = new ArrayList<>();

            if (constraint == null || constraint.length() == 0){
                filteredPeople.addAll(peopleListAll);
            }else{
                for (String people:peopleListAll) {
                    if(people.toLowerCase().contains(constraint.toString().toLowerCase().trim())){
                        Log.d("filter", constraint.toString());
                        filteredPeople.add(people);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredPeople;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            peopleList.clear();
            peopleList.addAll((List) results.values);
            Log.d("list", peopleList.toString());
            notifyDataSetChanged();
        }
    };
}
