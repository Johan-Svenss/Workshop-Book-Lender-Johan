package se.lexicon.model;

import java.util.ArrayList;
import java.util.List;

// A person in a book lending app. Each person has a book, a first and last name, and a list of book they borrow
public class Person {

    private static int sequencer = 0;
    private int id;
    private String firstName;
    private String lastName;
    private List<Book> lendedBooks;

    //Constructor

    public Person(String firstName, String lastName) {
        this.id = this.getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.lendedBooks = new ArrayList<Book>();
    }

    // Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Modificator

    private int getNextId(){
        return sequencer++;
    }

    /**
     * <p>
     * This method is to lend the book to the person
     * </p>
     *
     * <h3>Criteria:</h3>
     * <ol>
     *    <li>Book is available</li>
     * </ol>
     *
     * @param book
     */
    public void loanBook(Book book){
        // Book: If it is not already lended
        if(book.isAvailable()){
            // Person: Adding the book to the list
            this.lendedBooks.add(book);
            // Book: set Borrower and that it is not available right now
            book.setBorrower(this);
        } else {
            System.out.println("The book is currently not available.");
        }
    }

    /**
     *
     * @param book
     */
    public void returnBook(Book book){
        // Person: Remove the book to the list, if it exists
        if(lendedBooks.remove(book)){
            // Book: set Borrower to null and that it is available right now
            book.setBorrower(null);
        } else {
            System.out.println("The book is not in possesion of this person.");
        }

    }

    public String getPersonInformation(){

        String lendedBookListString = "\n";

        for (int i = 0; i < lendedBooks.size(); i++) {
            lendedBookListString = lendedBookListString + "\t\t[ " + lendedBooks.get(i).getTitle() + " ]\n";
        }
        return "Person[" +
                "\n\tId:" + id +
                ",\n\tName: '" + firstName + " " + lastName + '\'' +
                ",\n\tBook list: " + lendedBookListString +
                ']';
    }
}