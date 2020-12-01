package com.example.tp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class chooseActivity extends AppCompatActivity {

    private Button courseB,quizB;
    private ImageView backB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        courseB=findViewById(R.id.courses_button);
        quizB=findViewById(R.id.quiz_button);
        backB=findViewById(R.id.back_button);


        backB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        courseB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(chooseActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        quizB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(chooseActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}