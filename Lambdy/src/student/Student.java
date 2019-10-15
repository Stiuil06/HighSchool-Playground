package student;

import java.time.LocalDate;

/**
 * Created By wegrzyna on 15.10.2019
 */
public class Student {
    private String imie;
    private String nazwisko;
    private LocalDate dataUkonczeniaStudiow;
    private Double sredniaOcenNaZakonczenieStudiow;

    public Student(String imie, String nazwisko, LocalDate dataUkonczeniaStudiow, Double sredniaOcenNaZakonczenieStudiow) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUkonczeniaStudiow = dataUkonczeniaStudiow;
        this.sredniaOcenNaZakonczenieStudiow = sredniaOcenNaZakonczenieStudiow;
    }

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public LocalDate getDataUkonczeniaStudiow() {
        return dataUkonczeniaStudiow;
    }

    public Double getSredniaOcenNaZakonczenieStudiow() {
        return sredniaOcenNaZakonczenieStudiow;
    }

    @Override
    public String toString() {
        return "Student{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", dataUkonczeniaStudiow=" + dataUkonczeniaStudiow +
                ", sredniaOcenNaZakonczenieStudiow=" + sredniaOcenNaZakonczenieStudiow +
                '}';
    }
}
