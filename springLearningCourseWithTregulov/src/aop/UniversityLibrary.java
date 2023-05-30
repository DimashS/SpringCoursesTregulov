package aop;

import org.springframework.stereotype.Component;

@Component
public class UniversityLibrary extends AbstractLibrary {
    public void getBook() {
        System.out.println("Book has been taken University Library");
        System.out.println("--------------");
    }

    public String returnBook() {
        int age = 10/0;
        System.out.println("Book has been returned to University Library");
        return "War and Peace";
    }

    public void getMagazine() {
        System.out.println("Magazine has been taken from University Library");
        System.out.println("--------------");
    }
    public void returnMagazine() {
        System.out.println("Magazine has been returned to University Library");
        System.out.println("--------------");
    }

    public void addBook(String name, Book book) {
        System.out.println("We add book to University Library");
        System.out.println("--------------");
    }
    public void addMagazine() {
        System.out.println("We add magazine to University Library");
        System.out.println("--------------");
    }

}
