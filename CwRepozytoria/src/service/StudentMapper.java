package service;

import model.Student;

public class StudentMapper {
    enum VARIABLE_NAME{
        ID,NAME,SURENAME,AGE
    }


    public static final String SEPARATOR = ";";

    static public String studentToCsvRecord(Student student) {
        return student.getId() +
                SEPARATOR +
                student.getName() +
                SEPARATOR +
                student.getSurname() +
                SEPARATOR +
                student.getAge();
    }

    static public Student CsvRecordToStudent(String line){
        String[] varaibleArray = line.split(SEPARATOR);

        Student student = new Student();
        student.setId(Long.valueOf(varaibleArray[VARIABLE_NAME.ID.ordinal()]));
        student.setName(varaibleArray[VARIABLE_NAME.NAME.ordinal()]);
        student.setSurname(varaibleArray[VARIABLE_NAME.SURENAME.ordinal()]);
        student.setAge(Integer.valueOf(varaibleArray[VARIABLE_NAME.AGE.ordinal()]));

        return student;
    }
}
