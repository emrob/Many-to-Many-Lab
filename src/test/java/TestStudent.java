import db.DBHelper;
import models.Course;
import models.Lesson;
import models.Student;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestStudent {
    private Student student;
    private Course course;
    private Lesson lesson;

    @Before
    public void before(){
        course = new Course("Psychology", "BA");
        student = new Student("Ed", 31, 20081211, course);
        lesson = new Lesson("Life, The Universe and Everything", 201, course);
        DBHelper.save(course);
        DBHelper.save(student);
        DBHelper.save(lesson);
    }

    @After
    public void after(){
        DBHelper.delete(lesson);
        DBHelper.delete(student);
        DBHelper.delete(course);
    }


    @Test
    public void canSave(){
        List<Course> courseResults = DBHelper.getAll(Course.class);
        List<Student> studentResults = DBHelper.getAll(Student.class);
        List<Lesson> lessonResults = DBHelper.getAll(Lesson.class);
        assertEquals(1, courseResults.size());
        assertEquals(1, studentResults.size());
        assertEquals(1, lessonResults.size());
    }

    @Test
    public void canUpdate(){
        Student found =DBHelper.find(Student.class, student.getId());
        found.setName("Jeff");
        DBHelper.update(found);
        found = DBHelper.find(Student.class, student.getId());
        assertEquals("Jeff", found.getName());
    }


}

