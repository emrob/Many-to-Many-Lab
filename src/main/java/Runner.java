import db.DBHelper;
import models.Course;
import models.Instructor;
import models.Lesson;
import models.Student;

import java.text.SimpleDateFormat;

public class Runner {

    public static void main(String[] args) {

        Course course1 = new Course("Mathematics", "BSc", (10-9-2018), (10-05-2019));
        DBHelper.save(course1);

        Course course2 = new Course("Psychology", "BA", '10-9-2018', '10-05-2019');
        DBHelper.save(course2);

        Instructor instructor1 = new Instructor("Prof Harry", course1);
        DBHelper.save(instructor1);

        Instructor instructor2 = new Instructor("Prof Gee", course2);
        DBHelper.save(instructor2);

        Student student1 = new Student("Ed", 31, 20081211, course1);
        DBHelper.save(student1);

        Student student2 = new Student("Emma", 27, 1345632, course2);
        DBHelper.save(student2);

        Lesson lesson1 = new Lesson("Life, The Universe and Everything", 201, course1);
        DBHelper.save(lesson1);

        Lesson lesson2 = new Lesson("Applied Mathematics", 301, course1);
        DBHelper.save(lesson2);

        Lesson lesson3 = new Lesson("Introduction to Psychology", 401, course2);
        DBHelper.save(lesson3);

        Lesson lesson4 = new Lesson("Child Behaviour", 233, course2);
        DBHelper.save(lesson4);

        DBHelper.addStudentToLesson(student1, lesson1);
        DBHelper.addStudentToLesson(student2, lesson4);

        DBHelper.addInstructorToLesson(instructor1, lesson1);
        DBHelper.addInstructorToLesson(instructor2, lesson2);


    }
}
