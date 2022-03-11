package com.example.tuttifruitti;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView textViewChoice1;
        public TextView textViewChoice2;
        public TextView textViewChoice3;
        public TextView textViewChoice4;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            textViewChoice1 = (TextView) itemView.findViewById(R.id.recyclerChoice1);
            textViewChoice2 = (TextView) itemView.findViewById(R.id.recyclerChoice2);
            textViewChoice3 = (TextView) itemView.findViewById(R.id.recyclerChoice3);
            textViewChoice4 = (TextView) itemView.findViewById(R.id.recyclerChoice4);
        }
    }
    private List<DataSources> dataSourcesList;

    public MyAdapter(List<DataSources> data) {
        dataSourcesList = data;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View dataView = inflater.inflate(R.layout.my_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(dataView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MyAdapter.ViewHolder holder, int position) {
        // Get the data model based on position
        DataSources data = dataSourcesList.get(position);

        // Set item views based on your views and data model
        TextView textView1 = holder.textViewChoice1;
        textView1.setText("choix 1");

        TextView textView2 = holder.textViewChoice2;
        textView2.setText("choix2");

        TextView textView3 = holder.textViewChoice3;
        textView3.setText("choix3");

        TextView textView4 = holder.textViewChoice4;
        textView4.setText("choix4");
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return dataSourcesList.size();
    }
}
