package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    String[] data1;
    String[] data2;
    Context context;

    // the context and the data is passed to the adapter
    public MyAdapter(Context ct, String s1[], String s2[]) {
        context = ct;
        data1 = s1;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        // The 'row.xml' file in layout folder defines
        // the style for each row
        View view = inflater.inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // use the data passed to the adapter above
        // and set the data to the text views below
        holder.lang.setText(data1[position]);
        holder.desc.setText(data2[position]);

        // detect if an item is clicked using the root layout of the 'row.xml' file
        holder.main_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display the language of the row that is clicked
                Toast.makeText(context, data1[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        // return the length of the recycler view
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        // Each row will contain two text views
        // for displaying the data
        TextView lang,desc;
        // Select the root layout of the 'row.xml' file
        ConstraintLayout main_layout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            // Set the text view from the 'row.xml' file in layout folder
            lang = itemView.findViewById(R.id.language);
            desc = itemView.findViewById(R.id.description);
            main_layout = itemView.findViewById(R.id.row_layout);
        }
    }
}
