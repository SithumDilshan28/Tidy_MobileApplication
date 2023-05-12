package com.example.tidy.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tidy.R;
import com.example.tidy.database.Apply;

import java.util.ArrayList;

public class ViewApplyAdapter extends RecyclerView.Adapter<ViewApplyAdapter.masonryAdapter> {

    Context context;
    ArrayList<Apply> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    int singleData;

    public ViewApplyAdapter(Context context, ArrayList<Apply> adds, SQLiteDatabase sqLiteDatabase, int singleData) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
        this.singleData = singleData;
    }

    @NonNull
    @Override
    public ViewApplyAdapter.masonryAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledatafor_applyjob, null);
        return new ViewApplyAdapter.masonryAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewApplyAdapter.masonryAdapter holder, int position) {
        final Apply add = adds.get(position);
        holder.address.setText(add.getAddress());
        holder.price.setText(add.getPrice());
        holder.name.setText(add.getName());
    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    public class masonryAdapter extends RecyclerView.ViewHolder {
        TextView name, address, price;
        ImageView img;
        Button edit;
        public masonryAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            price = itemView.findViewById(R.id.price);

            edit = itemView.findViewById(R.id.Edit);
        }
    }
}
