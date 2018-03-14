package models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    @Temporal(TemporalType.DATE)
    private int id;
    private String title;
    private String level;
    private Set<Student> students;
    private Set<Lesson> lessons;
    private Set<Instructor> instructors;
    private SimpleDateFormat startDate;
    private SimpleDateFormat endDate;

    public Course() {
    }

    public Course(String title, String level, SimpleDateFormat startDate, SimpleDateFormat endDate) {
        this.title = title;
        this.level = level;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name="level")
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    @OneToMany(mappedBy="course", fetch = FetchType.LAZY)
    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    @Column(name="start_date")
    public SimpleDateFormat getStartDate() {
        return startDate;
    }

    public void setStartDate(SimpleDateFormat startDate) {
        this.startDate = startDate;
    }

    @Column(name="end_date")
    public SimpleDateFormat getEndDate() {
        return endDate;
    }

    public void setEndDate(SimpleDateFormat endDate) {
        this.endDate = endDate;
    }
}

