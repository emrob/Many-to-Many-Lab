package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="instructors")

public class Instructor {

    private int id;
    private String name;
    private Course course;
    private Set<Lesson> lessons;

    public Instructor() {
    }

    public Instructor(String name, Course course) {
        this.name = name;
        this.course = course;
        this.lessons = new HashSet<Lesson>();
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

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany
    @JoinTable(name="instructor_lesson",
    joinColumns = {@JoinColumn(name="instructor_id", nullable = false, updatable = false)},
    inverseJoinColumns = {@JoinColumn(name="lesson_id", nullable = false, updatable = false)})
    public Set<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(Set<Lesson> lessons) {
        this.lessons = lessons;
    }

    public void addLesson(Lesson lesson){
        this.lessons.add(lesson);
    }
}
