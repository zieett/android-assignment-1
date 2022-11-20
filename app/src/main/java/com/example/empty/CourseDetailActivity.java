package com.example.empty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        Intent i = getIntent();
        String nameValue = (String) i.getExtras().get("courseName");
        String idValue = (String) i.getExtras().get("courseId");
        TextView nameText = (TextView) findViewById(R.id.courseNameTitle);
        TextView idText = (TextView) findViewById(R.id.courseIdTitle);
        nameText.setText(nameValue);
        idText.setText(idValue);
        Button backButton = (Button) findViewById(R.id.backButton);
        LinearLayout annonucement = (LinearLayout) findViewById(R.id.announcementContainer);
        backButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseDetailActivity.this, MainActivity.class);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        annonucement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CourseDetailActivity.this, AnnouncementActivity.class);
                startActivityForResult(i, 200);
            }
        });
    }
}