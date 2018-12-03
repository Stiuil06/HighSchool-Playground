package repository.file;

import model.Student;
import repository.StudentRepository;
import service.StudentMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;


public class FileStudentRepository implements StudentRepository {
    private static final Path repositoryFilePath = Path.of("D:\\tmp\\repository.csv");

    @Override
    public void save(Student student) {
        try {
            Optional<Student> studentOptional = findById(student.getId());
            if (!studentOptional.isPresent()) {
                List<Student> students = getAll();
                students.add(student);
                String repositoryFile = students.stream()
                        .map(StudentMapper::studentToCsvRecord)
                        .collect(Collectors.joining("\n"));
                Files.writeString(repositoryFilePath, repositoryFile);
            }
        } catch (IOException e) {
            //TODO do zrobienia
        }

    }

    @Override
    public Optional<Student> findById(long id) {
        return getAll().stream()
                .filter(student -> student.getId() == id)
                .findFirst();
    }

    @Override
    public List<Student> getAll() {
        List<Student> students = new LinkedList<>();
        try {
            String repositoryFile = Files.readString(repositoryFilePath);
            students = repositoryFile.lines()
                    .map(StudentMapper::CsvRecordToStudent)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            //TODO do zrobienia
        }
        return students;
    }
}
