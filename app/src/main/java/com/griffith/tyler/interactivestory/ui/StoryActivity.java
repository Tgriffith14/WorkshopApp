package com.griffith.tyler.interactivestory.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.griffith.tyler.interactivestory.R;
import com.griffith.tyler.interactivestory.model.Page;
import com.griffith.tyler.interactivestory.model.Story;

public class StoryActivity extends AppCompatActivity {
    public static final String TAG = StoryActivity.class.getSimpleName();

    private Story story = new Story();
    private ImageView imgView;
    private TextView txtView;
    private Button choice1;
    private Button choice2;
    private String name;
    private Page currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));

        if(name == null) {
            name = "Friend";
        }
        Log.d(TAG, name);

        imgView = (ImageView) findViewById(R.id.storyImageView);
        txtView = (TextView) findViewById(R.id.storyTextView);
        choice1 = (Button) findViewById(R.id.choiceButton1);
        choice2 = (Button) findViewById(R.id.choiceButton2);

        loadPage(0);

    }

    private void loadPage (int choice) {
        currentPage = story.getPage(choice);

        Drawable drawable = getResources().getDrawable(currentPage.getImageID());
        imgView.setImageDrawable(drawable);

        String storyText = currentPage.getText();
        storyText = String.format(storyText, name);
        txtView.setText(storyText);
        if(currentPage.isFinal() == false) {
            choice1.setText(currentPage.getChoice1().getText());
            choice2.setText(currentPage.getChoice2().getText());
            choice1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = currentPage.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });
            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int nextPage = currentPage.getChoice2().getNextPage();
                    loadPage(nextPage);
                }
            });
        } else {
            choice1.setVisibility(View.INVISIBLE);
            choice2.setText("PLAY AGAIN");

            choice2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }


    }
}