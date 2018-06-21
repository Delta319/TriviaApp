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

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.example.ethanrowe.triviaapp.MainActivity.QUESTIONS_LIST;


public class QuizFragment extends Fragment {

    @BindView(R.id.quiz_question_textview)
    protected TextView quizQuestion;

    @BindView(R.id.answerOneButton)
    protected Button answerOneButton;
    @BindView(R.id.answerTwoButton)
    protected Button answerTwoButton;
    @BindView(R.id.answerThreeButton)
    protected Button answerThreeButton;
    @BindView(R.id.answerFourButton)
    protected Button answerFourButton;

    private List<Question> questionsList;
    private Question question;
    private int questionListPosition = 0;
    private int correctAnswers = 0;
    private QuizCallback quizCallback;

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

    @Override
    public void onStart() {
        super.onStart();

        questionsList = getArguments().getParcelableArrayList(QUESTIONS_LIST);

        populateQuizContent();

    }

    //Algorithm to make choices on different buttons each time
    private void populateQuizContent() {
        question = questionsList.get(questionListPosition);
        quizQuestion.setText(question.getQuestion());

        List<Button> buttonList = new ArrayList<>();
        buttonList.add(answerOneButton);
        buttonList.add(answerTwoButton);
        buttonList.add(answerThreeButton);
        buttonList.add(answerFourButton);

        List<String> possibleAnswersList = new ArrayList<>();
        possibleAnswersList.add(question.getCorrectAnswer());
        possibleAnswersList.add(question.getWrongAnswerOne());
        possibleAnswersList.add(question.getWrongAnswerTwo());
        possibleAnswersList.add(question.getWrongAnswerThree());

        //For Each Loop takes the arrayLists we made and actually allows us to randomize what answer goes on which button
        for (Button button : buttonList) {

            int random = (int) Math.ceil(Math.random() * (possibleAnswersList.size() - 1));

            button.setText(possibleAnswersList.get(random));
            possibleAnswersList.remove(random);
        }

    }

    private void checkAnswer(String answer) {
        //Increments questionList position so we can go to the next question
        questionListPosition++;
        //Sets the textview to show the user to show they were correct
        if (question.getCorrectAnswer().equals(answer)) {
            quizQuestion.setText(R.string.correct);
            //Increments the correct answers the user has gotten
            correctAnswers++;
        } else {
            quizQuestion.setText(getString(R.string.wrong_answer_text, question.getCorrectAnswer()));
        }
    }

    @OnClick(R.id.answerOneButton)
    protected void buttonOneClicked() {

        checkAnswer(answerOneButton.getText().toString());
    }

    @OnClick(R.id.answerTwoButton)
    protected void buttonTwoClicked() {

        checkAnswer(answerTwoButton.getText().toString());
    }

    @OnClick(R.id.answerThreeButton)
    protected void buttonThreeClicked() {

        checkAnswer(answerThreeButton.getText().toString());
    }

    @OnClick(R.id.answerFourButton)
    protected void buttonFourClicked() {

        checkAnswer(answerFourButton.getText().toString());
    }

    @OnClick(R.id.next_button)
    protected void nextButtonClicked() {

        if (questionListPosition <= questionsList.size() - 1) {
            populateQuizContent();
        } else {
            //Handling no more questions, taking user to MainActivity
            quizCallback.quizFinished(correctAnswers);
        }


    }

    public interface QuizCallback {

        void quizFinished(int correctAnswers);
    }
}
