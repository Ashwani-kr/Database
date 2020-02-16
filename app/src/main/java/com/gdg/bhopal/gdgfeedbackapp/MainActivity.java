package com.gdg.bhopal.gdgfeedbackapp;

import android.content.Intent;
import android.os.Bundle;

import com.gdg.gdgfeedbackapp.GDGFeedback;
import com.gdg.gdgfeedbackapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Button SubmitBtn;
    EditText nameEdt;
    RatingBar rb;
    Spinner quali;
    RadioButton studentRB;
    RadioButton profRB;
    EditText suggestionET;
    SeekBar ageSb;
    CheckBox agreeSB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        nameEdt=(EditText)findViewById(R.id.nameEdt);
        setSupportActionBar(toolbar);

        SubmitBtn= (Button)findViewById(R.id.submitBtn);
        rb = (RatingBar)findViewById(R.id.feedbackRB);
        studentRB=(RadioButton)findViewById(R.id.studentRB);
        profRB=(RadioButton)findViewById(R.id.profRB);
        suggestionET=(EditText)findViewById(R.id.suggestionET);
        ageSb=(SeekBar)findViewById(R.id.ageSB);
        agreeSB=(CheckBox) findViewById(R.id.consentCB);
        quali=(Spinner)findViewById(R.id.qualificationSpn);

        SubmitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=nameEdt.getText().toString();
                int  rate= rb.getProgress();
                String qualification =quali.getSelectedItem().toString();
                String occupation=null;


                if(studentRB.isChecked())
                {
                    occupation="student";

                }
                if(profRB.isChecked())
                {
                    occupation="proff";

                }
                String suggestion=suggestionET.getText().toString();
                int age=ageSb.getProgress();
                Boolean isagree=agreeSB.isChecked();
                GDGFeedback gf=new GDGFeedback(name,occupation,rate,qualification,suggestion,age,isagree);
                Intent i= new Intent(MainActivity.this, com.gdg.bhopal.gdgfeedbackapp.ThankYouActivity.class);
                i.putExtra("name",nameEdt.getText().toString());
                i.putExtra( "feedback",gf);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}