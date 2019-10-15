package student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By wegrzyna on 15.10.2019
 */
public class StudentHomeWork1 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        fillList(students);
        lambdaApproach(students);
    }

    private static void lambdaApproach(List<Student> students) {
        // Student z najlepszym wynikiem studiow w roku 2018
        students.stream()
                .filter(s -> s.getDataUkonczeniaStudiow().getYear() == 2018)
                .max(StudentHomeWork1::sredniaOcenRosnacoComparator)
                .ifPresent(System.out::println);

        breakLine();
        // Student z najslabszym wynikiem studiow w roku 2018
        students.stream()
                .filter(s -> s.getDataUkonczeniaStudiow().getYear() == 2018)
                .min(StudentHomeWork1::sredniaOcenRosnacoComparator)
                .ifPresent(System.out::println);

        breakLine();
        // Wszystkich studentow którzy mają nazwisko Kowalski
        students.stream()
                .filter(s -> s.getNazwisko().equals("Kowalski"))
                .forEach(System.out::println);

        breakLine();
        // Usunąć studentów którzy mają średnią ocen gorszą od 3.0
        // * Bez modyfikacji źródłowej listy
        List<Student> wynik = students.stream()
                .filter(s -> s.getSredniaOcenNaZakonczenieStudiow() >= 3.0)
                .collect(Collectors.toList());
        System.out.println(wynik);

        // * Z modyfikacjią źródłowej listy
        students.removeIf(s -> s.getSredniaOcenNaZakonczenieStudiow() < 3.0);
        System.out.println(students);
    }

    private static void fillList(List<Student> students) {
        students.add(new Student("Jan", "Kowalski", LocalDate.now().minusYears(1), 4.82));
        students.add(new Student("Mateusz", "Szczerek", LocalDate.now().minusYears(1), 4.88));
        students.add(new Student("Cezary", "Gruszczyński", LocalDate.now().minusYears(1), 4.84));
        students.add(new Student("Mikołaj", "Kopeć", LocalDate.now().minusYears(1), 4.85));
        students.add(new Student("Krzysztof", "Pietrzczyk", LocalDate.now().minusYears(1), 4.86));
        students.add(new Student("Marcin", "Kowalski", LocalDate.now().minusYears(2), 4.02));
        students.add(new Student("Michał", "Kowalski", LocalDate.now(), 2.52));
        students.add(new Student("Paweł", "Gołąb", LocalDate.now(), 4.83));
        students.add(new Student("Mateusz", "Moskal", LocalDate.now(), 4.85));
        students.add(new Student("Kinga", "Usnarski", LocalDate.now(), 4.87));
        students.add(new Student("Adam", "Zawada", LocalDate.now(), 4.69));
        students.add(new Student("Piotr", "Wrona", LocalDate.now(), 4.81));
    }

    private static void breakLine() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
    }

    private static int sredniaOcenRosnacoComparator(Student s1, Student s2) {
        if (s1.getSredniaOcenNaZakonczenieStudiow().equals(s2.getSredniaOcenNaZakonczenieStudiow()))
            return 0;

        return s1.getSredniaOcenNaZakonczenieStudiow() > s2.getSredniaOcenNaZakonczenieStudiow() ? 1 : -1;
    }
}
