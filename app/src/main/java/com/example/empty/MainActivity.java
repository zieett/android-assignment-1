package com.example.empty;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    LinearLayout linearLayout;
    Button add;
    AlertDialog alertDialog;
    LinearLayout layout;
    AlertDialog deleteDialog;
    Button deleteButton;
    ArrayList<Course> courses;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buildAddDialog();
        add = (AppCompatButton) findViewById(R.id.add);
        layout = (LinearLayout) findViewById(R.id.container);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.show();
            }
        });
        setCourses();
    }


    public void setCourses(){
        courses = new ArrayList<Course>();
        courses.add(new Course("COSC2457","Android Development"));
        courses.add(new Course("COSC3322","IOS Development"));
        courses.add(new Course("COSC2545","Software Development"));

        for (Course course:courses
             ) {
            View view = getLayoutInflater().inflate(R.layout.course_layout,null);
            TextView name = view.findViewById(R.id.courseName);
            TextView id = view.findViewById(R.id.courseId);
            RelativeLayout courseLayout = (RelativeLayout) view.findViewById(R.id.course);
            Button deleteButton = (Button) view.findViewById(R.id.deleteButton);
            name.setText(course.getName());
            id.setText(course.getId());
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    deleteCourse(view);
                }
            });
            courseLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(MainActivity.this, CourseDetailActivity.class);
                    i.putExtra("courseName",name.getText().toString());
                    i.putExtra("courseId",id.getText().toString());
                    startActivityForResult(i, 100);
                }
            });
            layout.addView(view);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100) {
            if (resultCode == RESULT_OK){
                System.out.println("Done");
            }
        }
        if (requestCode == 200) {
            if (resultCode == RESULT_OK){

            }
        }
    }
    private void buildAddDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.add_course_layout,null);
        builder.setView(view);
        builder.setTitle("Enter course detail")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText name = (EditText) view.findViewById(R.id.addName);
                        EditText id = (EditText) view.findViewById(R.id.addId);
                        if (name.length() == 0 || id.length() == 0){
                            Toast toast = new Toast(MainActivity.this);
                            toast.setText("Name and id must not be empty");
                            toast.show();
                        }
                        else{
                            Course course = new Course(id.getText().toString(),name.getText().toString());
                            addCourse(course);
                            name.setText("");
                            id.setText("");
                        }
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        alertDialog = builder.create();
    }
    private void addCourse(Course course){
        View view = getLayoutInflater().inflate(R.layout.course_layout,null);
        TextView name = view.findViewById(R.id.courseName);
        TextView id = view.findViewById(R.id.courseId);
        Button deleteButton = view.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               deleteCourse(view);
            }
        });
        name.setText(course.getName());
        id.setText(course.getId());
        layout.addView(view);
    }
    private void deleteCourse(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Are you sure you want to delete this course")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        layout.removeView(view);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        deleteDialog = builder.create();
        deleteDialog.show();
    }

}