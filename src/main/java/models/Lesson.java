package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="lessons")
public class Lesson {

    private int id;
    private String title;
    private int classroomNumber;
    private Course course;
    private Set<Student> students;
    private Set<Instructor> instructors;

    public Lesson() {
    }

    public Lesson(String title, int classroomNumber, Course course) {
        this.title = title;
        this.classroomNumber = classroomNumber;
        this.course = course;
        this.students = new HashSet<Student>();
        this.instructors = new HashSet<Instructor>();
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

    @Column(name="classroom_number")
    public int getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(int classroomNumber) {
        this.classroomNumber = classroomNumber;
    }

    @ManyToOne
    @JoinColumn(name="course_id", nullable = false)
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToMany(mappedBy = "lessons", fetch = FetchType.LAZY)
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student){
        this.students.add(student);
    }

    @ManyToMany(mappedBy = "lessons", fetch = FetchType.LAZY)
    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public void setInstructors(Set<Instructor> instructors) {
        this.instructors = instructors;
    }

    public void addInstructor(Instructor instructor){
        this.instructors.add(instructor);
    }
}
