package com.example.tidy.adapter;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tidy.R;
import com.example.tidy.applyJob;
import com.example.tidy.database.adz;

import java.util.ArrayList;

public class ApplyAdapter extends RecyclerView.Adapter<ApplyAdapter.masonryAdapter>{

    Context context;
    ArrayList<adz> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    int singleData;

    public ApplyAdapter(Context context, ArrayList<adz> adds, SQLiteDatabase sqLiteDatabase, int singleData) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
        this.singleData = singleData;
    }

    @NonNull
    @Override
    public masonryAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledatafor_applyadds, null);
        return new ApplyAdapter.masonryAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull masonryAdapter holder, int position) {
        final adz add = adds.get(position);
        byte[] image = add.getImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        holder.room.setText(add.getRooms());
        holder.bathroom.setText(add.getBathrooms());
        holder.kitchen.setText(add.getFlooring());
        holder.story.setText(add.getStoreys());
        holder.flooring.setText(add.getFlooring());
        holder.address.setText(add.getLocation());
        holder.price.setText(add.getPrices());
        holder.img.setImageBitmap(bitmap);

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("address", add.getLocation());
                bundle.putString("price", add.getPrices());
                Intent intent = new Intent(context, applyJob.class);
                intent.putExtra("userdata", bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    public class masonryAdapter extends RecyclerView.ViewHolder {
        TextView room, bathroom, kitchen, story, flooring, address, price;
        ImageView img;
        Button edit;
        public masonryAdapter(@NonNull View itemView) {
            super(itemView);
            room = itemView.findViewById(R.id.rooms);
            bathroom = itemView.findViewById(R.id.bathroom);
            kitchen = itemView.findViewById(R.id.kitchen);
            story = itemView.findViewById(R.id.story);
            flooring = itemView.findViewById(R.id.floor);
            address = itemView.findViewById(R.id.address);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);

            edit = itemView.findViewById(R.id.Edit);
        }
    }
}
