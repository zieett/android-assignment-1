package com.example.empty;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;

public class AnnouncementActivity extends AppCompatActivity {
    LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcement);
        layout = (LinearLayout) findViewById(R.id.announcementsContainer);
        Intent i = getIntent();
        ArrayList<Announcement> announcements = (ArrayList<Announcement>) i.getExtras().getSerializable("announcements");
        AppCompatButton backButton = (AppCompatButton) findViewById(R.id.announcementBackButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnnouncementActivity.this, CourseDetailActivity.class);
                intent.putExtra("announcements",announcements);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        AppCompatButton addAnnouncement = (AppCompatButton) findViewById(R.id.addAnnouncement);
        addAnnouncement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AnnouncementActivity.this);
                View view = getLayoutInflater().inflate(R.layout.add_announcement_layout,null);
                builder.setView(view);
                builder.setTitle("Enter announcement detail")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                EditText title = (EditText) view.findViewById(R.id.addAnnouncementTitle);
                                EditText content = (EditText) view.findViewById(R.id.addAnnouncementContent);
                                if (title.length() == 0 || content.length() == 0){
                                    Toast toast = new Toast(AnnouncementActivity.this);
                                    toast.setText("Name and id must not be empty");
                                    toast.show();
                                }
                                else{
                                    Announcement announcement = new Announcement(title.getText().toString(),content.getText().toString());
                                    addAnnounce(announcement);
                                    announcements.add(announcement);
                                    title.setText("");
                                    content.setText("");
                                }
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                builder.create();
                builder.show();
            }
        });
        for (Announcement announcement: announcements
             ) {
            View view = getLayoutInflater().inflate(R.layout.announcement_layout,null);
            TextView title = view.findViewById(R.id.announcementTitle);
            title.setText(announcement.getTitle());
            RelativeLayout announcementLayout = (RelativeLayout) view.findViewById(R.id.announcementContainer);
            announcementLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(AnnouncementActivity.this);
                    View announcementDetailLayoutView = getLayoutInflater().inflate(R.layout.announcement_detail_layout,null);
                    TextView announcementTitle = (TextView) announcementDetailLayoutView.findViewById(R.id.announcementTitleView);
                    TextView announcementContent = (TextView) announcementDetailLayoutView.findViewById(R.id.announcementContentView);
                    announcementTitle.setText(announcement.getTitle());
                    announcementContent.setText(announcement.getContent());
                    builder.setView(announcementDetailLayoutView);
                    builder.create();
                    builder.show();
                }
            });
            layout.addView(view);
        }
    }
    private void addAnnounce(Announcement announcement){
        View view = getLayoutInflater().inflate(R.layout.announcement_layout,null);
        TextView title = view.findViewById(R.id.announcementTitle);
        title.setText(announcement.getTitle());
        RelativeLayout announcementLayout = (RelativeLayout) view.findViewById(R.id.announcementContainer);
        announcementLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(AnnouncementActivity.this);
                View announcementDetailLayoutView = getLayoutInflater().inflate(R.layout.announcement_detail_layout,null);
                TextView announcementTitle = (TextView) announcementDetailLayoutView.findViewById(R.id.announcementTitleView);
                TextView announcementContent = (TextView) announcementDetailLayoutView.findViewById(R.id.announcementContentView);
                announcementTitle.setText(announcement.getTitle());
                announcementContent.setText(announcement.getContent());
                builder.setView(announcementDetailLayoutView);
                builder.create();
                builder.show();
            }
        });
        layout.addView(view);
    }
}