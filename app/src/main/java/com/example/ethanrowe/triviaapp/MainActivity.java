package com.example.ethanrowe.triviaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements QuestionCreatorFragment.Callback{

    private QuestionCreatorFragment questionCreatorFragment;
    private List<Question> questionsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        questionsList = new ArrayList<>();
    }

    @OnClick(R.id.save_question_button)
    protected void addQuestionClicked() {

        questionCreatorFragment = QuestionCreatorFragment.newInstance();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, questionCreatorFragment).commit();



    }

    @Override
    public void questionSaved(Question question) {

        questionsList.add(question);
        Toast.makeText(this, "Question Saved!", Toast.LENGTH_SHORT).show();

        getSupportFragmentManager().beginTransaction().remove(questionCreatorFragment).commit();
    }
}
