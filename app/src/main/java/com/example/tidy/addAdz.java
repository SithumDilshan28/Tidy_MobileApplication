package com.example.tidy;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.tidy.database.dataHandler;
import com.example.tidy.database.dbConnector;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayOutputStream;

public class addAdz extends AppCompatActivity {

    ImageView img;
    SQLiteDatabase sqLiteDatabase;
    dbConnector db;
    TextInputLayout room, bathroom, flooring, storeys, location, contact;
    EditText prices;
    Button edit,submit;
    TextInputEditText Edit_room, Edit_bathroom, Edit_flooring, Edit_storeys, Edit_location, Edit_contact;

    int id = 0;

    com.example.tidy.database.dataHandler dataHandler = new dataHandler(this);

    private static final int PICK_IMAGE_REQUEST = 100;
    private Uri imageFilePath;
    private Bitmap imageToStore;


    public static final int CAMERA_REQUEST = 100;
    public static final int STORAGE_REQUEST = 101;
    String[] cameraPermission;
    String[] storagePermission;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_adz);

        room = findViewById(R.id.Room);
        bathroom = findViewById(R.id.Bathroom);
        flooring = findViewById(R.id.Flooring);
        storeys = findViewById(R.id.story);
        location = findViewById(R.id.Location);
        contact = findViewById(R.id.Mobile);
        prices = findViewById(R.id.price);
        edit = findViewById(R.id.Edit);
        submit = findViewById(R.id.submit);
        img = findViewById(R.id.imageView2);

        Edit_room = findViewById(R.id.editname);
        Edit_bathroom = findViewById(R.id.editname1);
        Edit_flooring = findViewById(R.id.editname2);
        Edit_storeys = findViewById(R.id.editname3);
        Edit_location = findViewById(R.id.editname4);
        Edit_contact = findViewById(R.id.editname5);

        //database
        dataHandler.openDB();
        db = new dbConnector(this);

        editData();

        edit.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                ContentValues cv = new ContentValues();
                cv.put("Rooms", room.getEditText().getText().toString());
                cv.put("Bathrooms", bathroom.getEditText().getText().toString());
                cv.put("Flooring", flooring.getEditText().getText().toString());
                cv.put("Storeys", storeys.getEditText().getText().toString());
                cv.put("Location", location.getEditText().getText().toString());
                cv.put("Contact", contact.getEditText().getText().toString());
                cv.put("Price", prices.getText().toString());


                sqLiteDatabase = db.getReadableDatabase();
                long recedit = sqLiteDatabase.update("Adz", cv, "id="+id, null);
                if (recedit != -1) {
                    Toast.makeText(addAdz.this, "Data Updated Successfully", Toast.LENGTH_SHORT).show();
                    submit.setVisibility(android.view.View.VISIBLE);
                    edit.setVisibility(android.view.View.GONE);

                } else {
                    Toast.makeText(addAdz.this, "Data Updated Failed", Toast.LENGTH_SHORT).show();
                }
            }

        });

    }

    private void editData() {

        if (getIntent().getBundleExtra("userdata") != null) {
            Bundle bundle = getIntent().getBundleExtra("userdata");
            id=bundle.getInt("id");
            Edit_room.setText(bundle.getString("Rooms"));
            Edit_bathroom.setText(bundle.getString("Bathrooms"));
            Edit_flooring.setText(bundle.getString("Flooring"));
            Edit_storeys.setText(bundle.getString("Storeys"));
            Edit_location.setText(bundle.getString("Location"));
            Edit_contact.setText(bundle.getString("Contact"));
            prices.setText(bundle.getString("Price"));
            byte[]bytes=bundle.getByteArray("Image");
            Bitmap bitmap= BitmapFactory.decodeByteArray(bytes,0,bytes.length);
            img.setImageBitmap(bitmap);
            edit.setVisibility(android.view.View.VISIBLE);
            submit.setVisibility(android.view.View.GONE);
        }

    }

    private byte[] ImageViewToByte(ImageView img) {
        Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        byte[] bytes = stream.toByteArray();
        return bytes;
    }

    //Room validation
    private boolean validRoom() {
        String Room = room.getEditText().getText().toString().trim();

        if (Room.isEmpty()) {
            room.setError("Room is Empty.");
            return false;
        } else {
            room.setError(null);
            return true;
        }

    }

    //Bathroom validation
    private boolean validBathroom() {
        String Bathroom = bathroom.getEditText().getText().toString().trim();

        if (Bathroom.isEmpty()) {
            bathroom.setError("Bathroom is Empty.");
            return false;
        } else {
            bathroom.setError(null);
            return true;
        }

    }

    //Flooring validation
    private boolean validFlooring() {
        String Flooring = flooring.getEditText().getText().toString().trim();

        if (Flooring.isEmpty()) {
            flooring.setError("Flooring is Empty.");
            return false;
        } else {
            flooring.setError(null);
            return true;
        }

    }

    //storeys validation
    private boolean validStoreys() {
        String Storeys = storeys.getEditText().getText().toString().trim();

        if (Storeys.isEmpty()) {
            storeys.setError("Storeys is Empty.");
            return false;
        } else {
            storeys.setError(null);
            return true;
        }

    }

    //Location validation
    private boolean validLocation() {
        String Location = location.getEditText().getText().toString().trim();

        if (Location.isEmpty()) {
            location.setError("Location is Empty.");
            return false;
        } else {
            location.setError(null);
            return true;
        }

    }

    //Contact validation
    private boolean validContact() {
        String Contact = contact.getEditText().getText().toString().trim();

        if (Contact.isEmpty()) {
            contact.setError("Email is Empty.");
            return false;
        } else {
            contact.setError(null);
            return true;
        }

    }

    public void submit (android.view.View view) {

        String Rooms = room.getEditText().getText().toString().trim();
        String Bathroom = bathroom.getEditText().getText().toString().trim();
        String Flooring = flooring.getEditText().getText().toString().trim();
        String Storeys = storeys.getEditText().getText().toString().trim();
        String Location = location.getEditText().getText().toString().trim();
        String Contact = contact.getEditText().getText().toString().trim();
        String Price = prices.getText().toString().trim();


        if (!validRoom() | !validBathroom() | !validFlooring() | !validStoreys() | !validLocation() | !validLocation() | !validContact() ) {
            return;
        }

        ContentValues cv = new ContentValues();
        cv.put("Rooms", Rooms);
        cv.put("Bathrooms", Bathroom);
        cv.put("Flooring", Flooring);
        cv.put("Storeys", Storeys);
        cv.put("Location", Location);
        cv.put("Contact", Contact);
        cv.put("Price", Price);
        cv.put("Image", ImageViewToByte(img));
        sqLiteDatabase = db.getWritableDatabase();
        Long recinsert = sqLiteDatabase.insert("Adz", null, cv);

        if(recinsert!=null){
            Toast.makeText(addAdz.this,"Adz Added Successfully",Toast.LENGTH_SHORT).show();
            img.setImageResource(R.drawable.image);

        }

    }

    public void chooseImage(android.view.View view) {

        Intent intent = new Intent();
        intent.setType("image/*");

        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        try {
            if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                imageFilePath = data.getData();
                imageToStore = MediaStore.Images.Media.getBitmap(getContentResolver(), imageFilePath);

                img.setImageBitmap(imageToStore);
            }
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void cal(android.view.View view) {

        int Room = Integer.parseInt(room.getEditText().getText().toString().trim());

        if (Room <=2){
            prices.setText("Rs.2500");
        }else if (Room <=5){
            prices.setText("Rs.5000");
        }else if (Room <=10){
            prices.setText("Rs.7000");
        }
    }

    public void display_adz(android.view.View view) {
        Intent intent = new Intent(addAdz.this, display_adz.class);
        startActivity(intent);

    }
}
