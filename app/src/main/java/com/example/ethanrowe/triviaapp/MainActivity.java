package com.example.ethanrowe.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private QuestionCreatorFragment questionCreatorFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @OnClick(R.id.save_question_button)
    protected void addQuestionClicked() {

        questionCreatorFragment = QuestionCreatorFragment.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, questionCreatorFragment).commit();

    }

}
