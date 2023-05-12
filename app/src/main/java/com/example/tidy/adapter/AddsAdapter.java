package com.example.tidy.adapter;

import android.annotation.SuppressLint;
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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tidy.R;
import com.example.tidy.addAdz;
import com.example.tidy.database.adz;
import com.example.tidy.database.dbConnector;

import java.util.ArrayList;

public class AddsAdapter extends RecyclerView.Adapter<AddsAdapter.adzAdapter> {

    Context context;
    ArrayList<adz> adds = new ArrayList<>();
    SQLiteDatabase sqLiteDatabase;
    int singleData;

    public AddsAdapter(Context context, ArrayList<adz> adds, SQLiteDatabase sqLiteDatabase, int singleData) {
        this.context = context;
        this.adds = adds;
        this.sqLiteDatabase = sqLiteDatabase;
        this.singleData = singleData;
    }

    @NonNull
    @Override
    public adzAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.singledatafor_adds, null);
        return new adzAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adzAdapter holder, @SuppressLint("RecyclerView") int position) {
        final adz add = adds.get(position);
        byte[] image = add.getImg();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
        holder.room.setText(add.getRooms());
        holder.bathroom.setText(add.getBathrooms());
        holder.flooring.setText(add.getFlooring());
        holder.story.setText(add.getStoreys());
        holder.address.setText(add.getLocation());
        holder.contact.setText(add.getContact());
        holder.price.setText(add.getPrices());
        holder.img.setImageBitmap(bitmap);

        holder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("id",add.getId());
                bundle.putString("Rooms", add.getRooms());
                bundle.putString("Bathrooms", add.getBathrooms());
                bundle.putString("Flooring", add.getFlooring());
                bundle.putString("Storeys", add.getStoreys());
                bundle.putString("Location", add.getLocation());
                bundle.putString("Contact", add.getContact());
                bundle.putString("Price", add.getPrices());
                bundle.putByteArray("Image", add.getImg());
                Intent intent = new Intent(context, addAdz.class);
                intent.putExtra("userdata", bundle);
                context.startActivity(intent);
            }

        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            dbConnector db = new dbConnector(context);
            @Override
            public void onClick(View v) {
                sqLiteDatabase =db.getReadableDatabase();
                long delete=sqLiteDatabase.delete("Adz","id="+add.getId(),null);
                if (delete != -1) {
                    Toast.makeText(context,"Deleted Successfully",Toast.LENGTH_SHORT).show();
                    adds.remove(position);
                    notifyDataSetChanged();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    public class adzAdapter extends RecyclerView.ViewHolder {
        TextView room, bathroom, story, flooring, address, contact, price;
        ImageView img;
        Button edit, delete;
        public adzAdapter(@NonNull View itemView) {
            super(itemView);
            room = itemView.findViewById(R.id.rooms);
            bathroom = itemView.findViewById(R.id.bathroom);
            flooring = itemView.findViewById(R.id.flooring);
            story = itemView.findViewById(R.id.story);
            address = itemView.findViewById(R.id.location);
            contact = itemView.findViewById(R.id.contact);
            price = itemView.findViewById(R.id.price);
            img = itemView.findViewById(R.id.img);

            edit = itemView.findViewById(R.id.Edit);
            delete = itemView.findViewById(R.id.Delete);
        }
    }
}
