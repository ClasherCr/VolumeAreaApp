package com.example.volumeareaapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Prism extends AppCompatActivity {
    EditText prismlength,prismwidth,prismheight;
    TextView title,result;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_prism);
        prismlength = findViewById(R.id.editText_prism_length);
        prismwidth = findViewById(R.id.editText_prism_width);
        prismheight = findViewById(R.id.editText_prism_height);
        title = findViewById(R.id.textView2);
        result = findViewById(R.id.textView3);
        btn = findViewById(R.id.btn1);

        btn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String length = prismlength.getText().toString();
                int l = Integer.parseInt(length);
                String width = prismwidth.getText().toString();
                int w = Integer.parseInt(width);
                String height = prismheight.getText().toString();
                int h = Integer.parseInt(height);


                double volume = l*w*h;
                result.setText("V = "+volume+"L*W*H");
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}