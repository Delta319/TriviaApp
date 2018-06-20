package com.example.ethanrowe.triviaapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class QuizFragment extends Fragment {

    @BindView(R.id.quiz_question_textview)
    protected TextView quizQuestion;

    @BindView(R.id.answer_1_button)
    protected Button answer_1_button;
    @BindView(R.id.answer_2_button)
    protected Button answer_2_button;
    @BindView(R.id.answer_3_button)
    protected Button answer_3_button;
    @BindView(R.id.answer_4_button)
    protected Button answer_4_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    public static QuizFragment newInstance() {

        Bundle args = new Bundle();

        QuizFragment fragment = new QuizFragment();
        fragment.setArguments(args);
        return fragment;


    }

    @OnClick(R.id.answer_1_button)
    protected void buttonOneClicked() {

    }

    @OnClick(R.id.answer_2_button)
    protected void buttonTwoClicked() {

    }

    @OnClick(R.id.answer_3_button)
    protected void buttonThreeClicked() {

    }

    @OnClick(R.id.answer_4_button)
    protected void buttonFourClicked() {

    }

    @OnClick(R.id.next_button)
    protected void nextButtonClicked() {

    }
}
