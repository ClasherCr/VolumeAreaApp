package com.example.volumeareaapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        GridView gridView;
        ArrayList<Shape> shapeArrayList;
        MyCustomAdapter adapter;

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        gridView = findViewById(R.id.gridView);
        shapeArrayList = new ArrayList<>();

        Shape s1 = new Shape(R.drawable.sphere,"Sphere");
        Shape s2 = new Shape(R.drawable.cylinder,"Cylinder");
        Shape s3 = new Shape(R.drawable.cube,"Cube");
        Shape s4 = new Shape(R.drawable.prism,"Prism");
        shapeArrayList.add(s1);
        shapeArrayList.add(s2);
        shapeArrayList.add(s3);
        shapeArrayList.add(s4);





        adapter = new MyCustomAdapter(shapeArrayList,getApplicationContext());
        gridView.setAdapter(adapter);
        gridView.setNumColumns(2);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), Sphere.class);
                startActivity(i);
                Intent i1 = new Intent(getApplicationContext(), Cylinder.class);
                startActivity(i1);
                Intent iii = new Intent(getApplicationContext(), Cube.class);
                startActivity(iii);
                Intent iiii = new Intent(getApplicationContext(), Prism.class);
                startActivity(iiii);
            }
        });




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}