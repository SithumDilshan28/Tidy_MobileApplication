package com.example.tidy.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tidy.R;
import com.example.tidy.addreview;
import com.example.tidy.database.cleaner;

import java.util.ArrayList;

public class CleanerAdapter extends RecyclerView.Adapter<CleanerAdapter.cleanerAdapater> {

    Context context;
    ArrayList<cleaner> workers = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;

    public CleanerAdapter(Context context, int singledatafor_cleaners, ArrayList<cleaner> workers, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.workers = workers;
        this.sqLiteDatabase = sqLiteDatabase;
    }

    @NonNull
    @Override
    public CleanerAdapter.cleanerAdapater onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledatafor_cleaners, null);
        return new CleanerAdapter.cleanerAdapater(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CleanerAdapter.cleanerAdapater holder, int position) {
        final cleaner worker = workers.get(position);
        holder.name.setText(worker.getFullName());
        holder.number.setText(worker.getMobile());

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name", worker.getFullName());
                Intent intent = new Intent(context, addreview.class);
                intent.putExtra("userdata", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return workers.size();
    }

    public class cleanerAdapater extends RecyclerView.ViewHolder {
        TextView name, number;
        Button add;

        public cleanerAdapater(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            number = itemView.findViewById(R.id.number);

            add = itemView.findViewById(R.id.add);
        }
    }
}
