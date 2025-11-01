package se.lexicon;


import se.lexicon.model.Book;
import se.lexicon.model.Person;

public class App {
    public static void main(String[] args) {

        // Create a book instance
        Book HarryPotter = new Book("Harry Potter", "J. K. Rowling");
        // Display book information
        System.out.println(HarryPotter.getBookInformation());

        // Create a book instance
        Book abc = new Book("Abc", "Johan Svensson");
        // Display book information
        System.out.println(abc.getBookInformation());

        // Create a person instance
        Person AnnaHaul = new Person("Anna", "Haul");
        // Display person information
        System.out.println(AnnaHaul.getPersonInformation());

        // Loan a book to the person
        AnnaHaul.loanBook(HarryPotter);

        // Display person information after borrowing a book
        System.out.println("\n\n" + AnnaHaul.getPersonInformation());
        // Display book information after borrowing a book
        System.out.println(HarryPotter.getBookInformation());
        // Return the borrowed book
        AnnaHaul.returnBook(HarryPotter);

        // Display person information after returning the book
        System.out.println("\n\n" + AnnaHaul.getPersonInformation());
        // Display book information after returning the book
        System.out.println(HarryPotter.getBookInformation());


    }

}
