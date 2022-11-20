package com.example.empty;

import java.io.Serializable;
import java.util.ArrayList;

public class Course implements Serializable {
    String id;
    String name;
    ArrayList<Announcement>announcements;
    Syllabus syllabus;
    Module module;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Course(String id, String name,ArrayList<Announcement> announcements) {
        this.id = id;
        this.name = name;
        this.announcements = announcements;
    }

    public ArrayList<Announcement> getAnnouncement() {
        return announcements;
    }

    public void setAnnouncement(ArrayList<Announcement> announcements) {
        this.announcements = announcements;
    }

    public Syllabus getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(Syllabus syllabus) {
        this.syllabus = syllabus;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Announcement implements Serializable {
    String title;
    String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Announcement(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}

class Syllabus{

}

class Module{

}
