package com.samsung.myitschool.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecylerViewAdapter extends RecyclerView.Adapter<MyRecylerViewAdapter.ViewHolder> {

    private List<String> localList;
    private LayoutInflater localInflater;
    private Context context;
    //private ItemClickListener

    MyRecylerViewAdapter(Context c, List<String> data) {
        this.context = c;
        this.localList = data;
        this.localInflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override

    // подключем view для ряда
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = localInflater.inflate(R.layout.recyclerview_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String city = localList.get(position);
        holder.cityTextView.setText(city);
    }

    @Override
    public int getItemCount() {
        return localList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView cityTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cityTextView = itemView.findViewById(R.id.item_text);
            cityTextView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            Toast t = Toast.makeText(context, String.valueOf(localList.indexOf(cityTextView.getText().toString())), Toast.LENGTH_LONG);
            t.show();

        }
    }
}
