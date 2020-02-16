package com.gdg.bhopal.gdgfeedbackapp;

import android.os.Bundle;

import com.gdg.gdgfeedbackapp.FeedbackAdapter;
import com.gdg.gdgfeedbackapp.GDGFeedback;
import com.gdg.gdgfeedbackapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Adapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class ThankYouActivity extends AppCompatActivity {

    TextView thankYouTV;
    FeedbackAdapter fadapter;
    RecyclerView feedbackRCV;
    ArrayList<GDGFeedback> gfList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thank_you);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        thankYouTV=(TextView)findViewById(R.id.ThankyouTV);
        gfList=new ArrayList<GDGFeedback>();
        String s= getIntent().getStringExtra("name");
        GDGFeedback gf=(GDGFeedback) getIntent().getSerializableExtra("feedback");
        gfList.add(gf);
        fadapter = new FeedbackAdapter(this,gfList);
        feedbackRCV=(RecyclerView)findViewById(R.id.feedbackRecyclerView);
        feedbackRCV.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        feedbackRCV.setAdapter(fadapter);
        thankYouTV.setText(thankYouTV.getText()+" "+s);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}