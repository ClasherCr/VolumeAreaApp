package com.example.volumeareaapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Shape> {

    private ArrayList<Shape> shapeArrayList;
    Context context;

    public MyCustomAdapter(ArrayList<Shape> shapeArrayList, Context context1) {
        super(context1, R.layout.grid_item_layout,shapeArrayList);
        this.shapeArrayList = shapeArrayList;
        this.context = context1;
    }

    private static class MyViewHolder {
        TextView ShapeName;
        ImageView ShapeImg;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Shape shapes = getItem(position);

        MyViewHolder myViewHolder;

        if (convertView == null) {
            myViewHolder = new MyViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());

            convertView = inflater.inflate(R.layout.grid_item_layout,parent,false);


            myViewHolder.ShapeName = (TextView) convertView.findViewById(R.id.textView);
            myViewHolder.ShapeImg = (ImageView) convertView.findViewById(R.id.imageView);
            convertView.setTag(myViewHolder);

        }else {
            myViewHolder = (MyViewHolder) convertView.getTag();

        }
        myViewHolder.ShapeName.setText(shapes.getShapeName());
        myViewHolder.ShapeImg.setImageResource(shapes.getShapeImg());

        return convertView;

    }
}
