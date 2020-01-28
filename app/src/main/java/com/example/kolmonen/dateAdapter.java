package com.example.kolmonen;


import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class dateAdapter extends ArrayAdapter<Date> {
    private Context context;
    int resource;
    ArrayList<Date> objects = new ArrayList<Date>();

    public dateAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Date> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @Override
    public int getCount() {
        return objects.size();
    }

    @Nullable
    @Override
    public Date getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(R.layout.adapter_view_layout, parent, false);

        TextView teksti = convertView.findViewById(R.id.teksti);
        teksti.setText(objects.get(position).toString());


        Button remove = convertView.findViewById(R.id.Remove);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //notifyDataSetChanged();
            }
        });
        return convertView;
    }
}
