package com.example.files;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.File;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.MyViewHolder> {

    File[] files;
    Context context;

    // the context and the data is passed to the adapter
    public ImageListAdapter(Context ct, File[] fl) {
        context = ct;
        files = fl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // The 'image_row.xml' file in layout folder defines
        // the style for each row
        View view = inflater.inflate(R.layout.image_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // use the data passed to the adapter above
        // and set the data to the text views below
        File image_file = files[position];
        // convert the file to bitmap
        Bitmap bitmap = BitmapFactory.decodeFile(image_file.getPath());
        holder.image.setImageBitmap(bitmap);
    }

    @Override
    public int getItemCount() {
        // return the length of the recycler view
        return files.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageFile);
        }
    }
}