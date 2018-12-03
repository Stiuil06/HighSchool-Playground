package repository.memory;

import model.Student;
import repository.StudentRepository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class MemoryStudentRepository implements StudentRepository {
    List<Student> students = new LinkedList<>();

    @Override
    public void save(Student student) {
        students.add(student);
    }

    @Override
    public Optional<Student> findById(long id) {

        for(Student student: students){
            if(student.getId()==id)
                return Optional.of(student);
        }
        return Optional.empty();
    }

    @Override
    public List<Student> getAll() {
        return students;
    }
}
