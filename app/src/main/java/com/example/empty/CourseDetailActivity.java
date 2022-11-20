package com.example.empty;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class CourseDetailActivity extends AppCompatActivity {
    Intent i;
    ArrayList<Announcement> announcements;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);
        i = getIntent();
        String nameValue = (String) i.getExtras().get("courseName");
        String idValue = (String) i.getExtras().get("courseId");
        announcements  = (ArrayList<Announcement>) i.getExtras().getSerializable("announcements");
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
                intent.putExtra("announcements",announcements);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        annonucement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = new Intent(CourseDetailActivity.this, AnnouncementActivity.class);
                if(!i.hasExtra("announcements") ){
                    i.putExtra("announcements",announcements);
                }
                startActivityForResult(i, 200);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200) {
            if (resultCode == RESULT_OK){
                announcements = (ArrayList<Announcement>) data.getExtras().getSerializable("announcements");
                i.putExtra("announcements",announcements);
            }
        }

    }

}