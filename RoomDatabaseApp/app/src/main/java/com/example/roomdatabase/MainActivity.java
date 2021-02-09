package com.example.roomdatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

// classes annotated as entity
// are used to define the structure of the table in the database
// which defines the columns of the table and their types
@Entity
class Student {
    // each entity must include one non-nullable field
    // annotated as the primary key
    // here the 'name' column is set as the primary key of the table
    @NonNull
    @PrimaryKey
    private String name;
    private int age;

    // define the getters and setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // define the constructor
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

// interfaces annotated as dao
// are data access objects
// they define the methods for
// inserting, deleting and updating in the database
@Dao
interface StudentDAO {
    // methods annotated as Insert are used to
    // insert a new entity to the database
    // we have multiple insert methods
    // for adding a single entity or collections of entities
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertStudents(List<Student> students);
    @ Insert
    public void insertStudent(Student student);

    // for updating and deleting
    // the primary key of each received method parameter
    // will be used to find entities withtin the database
    // and update/delete them

    // methods annotated as Update are used to
    // update entity/entities within the database
    @Update
    public void updateStudents(List<Student> students);
    @Update
    public void updateStudent(Student student);

    // methods annotated as Delete are used to
    // delete an entity within the database
    @Delete
    public void deleteStudent(Student student);

    // methods annotated as Query can be used to
    // perform any SQL queries in the database
    // the SQL query is defined in the annotation value
    @Query("SELECT * FROM student")
    public List<Student> load_students();
    // to use method parameters within the SQL query statement
    // we can reference them by prepending
    // a colon (:) to the parameter name
    @Query("SELECT * FROM student WHERE name=:student_name")
    public Student load_student(String student_name);
}

// classes annotated as database
// are used as the main access point
// for the underlying sqlite connection
// we specify the entities and data access objects(DAO)
@Database(entities = {Student.class}, version = 1)
abstract class StudentDatabase extends RoomDatabase {
    public abstract StudentDAO studentDAO();
}

// class used to create and maintain the database instance
class StudentDatabaseAccess {
    private static StudentDatabase studentDatabase;
    private static final String STUDENT_DB_NAME = "student";

    private StudentDatabaseAccess() {}
    public static StudentDatabase getInstance(Context context) {
        if (studentDatabase == null) {
            studentDatabase = Room.databaseBuilder(context, StudentDatabase.class, STUDENT_DB_NAME).allowMainThreadQueries().build();
        }
        return studentDatabase;
    }
}

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // access database instance
        StudentDatabase database = StudentDatabaseAccess.getInstance(getApplicationContext());

        // add new records to the database
        //database.studentDAO().insertStudent(new Student("Surya Verma", 23));
        //database.studentDAO().insertStudent(new Student("Bisht Manu", 53));

        // update records in the database
        //database.studentDAO().updateStudent(new Student("Ram Sarkar", 24));

        // query the database
        List<Student> all_students = database.studentDAO().load_students();

        for (Student s : all_students) {
            Log.i("STUDENT_INFO", s.getName() + " " + s.getAge());
        }
    }
}