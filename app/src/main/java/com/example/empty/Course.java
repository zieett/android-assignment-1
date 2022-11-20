package com.example.empty;

public class Course {
    String id;
    String name;
    Announcement announcement;
    Syllabus syllabus;
    Module module;

    public Course(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Course(String id, String name,Announcement announcement) {
        this.id = id;
        this.name = name;
    }

    public Announcement getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(Announcement announcement) {
        this.announcement = announcement;
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

class Announcement{
    String title;
    String content;
}

class Syllabus{

}

class Module{

}
