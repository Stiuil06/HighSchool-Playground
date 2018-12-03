import model.Student;
import repository.StudentRepository;
import repository.file.FileStudentRepository;
import repository.memory.MemoryStudentRepository;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Student s1 =new Student();
        s1.setId(1);
        s1.setName("Artur");
        s1.setSurname("Wegrzyn");

        Student s2 =new Student();
        s2.setId(2);
        s2.setName("Albert");

        StudentRepository studentRepository = new MemoryStudentRepository();

        studentRepository.save(s1);
        studentRepository.save(s2);

        for(Student s:studentRepository.getAll()){
            System.out.println(s.getId()+" "+s.getName());
        }

//        Optional<Student> studentOptional = studentRepository.findById(s1.getId());
//        System.out.println(studentOptional.isPresent());


    }


}
