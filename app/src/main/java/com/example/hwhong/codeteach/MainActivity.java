package com.example.hwhong.codeteach;

import android.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//adding fragments during runtime
public class MainActivity extends AppCompatActivity {

    private TextView textView, question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragment_container,new QuestionFragment());
        ft.commit();

        question = (TextView) findViewById(R.id.question);
        textView = (TextView) findViewById(R.id.answer);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                question.setText("The answer is ... ");
                textView.setText("");
                FragmentManager fm = getSupportFragmentManager();
                android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, new AnswerFragment());
                ft.commit();
            }
        });
    }
}
