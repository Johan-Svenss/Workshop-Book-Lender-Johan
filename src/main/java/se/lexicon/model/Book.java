package se.lexicon.model;

// This is the book lending system where each book has a unique ID, title, author and availability status, and if theres a borrower it refers to it.

public class Book {
    private static int sequencer = 0;
    private String id;
    private String title;
    private String author;
    private boolean available;  // = false
    private Person borrower;

    //Constructor

       //Constructs a new book that is initially available
    public Book(String title, String author) {
        this.id = "Book-"+this.getNextId();
        this.title = title;
        this.author = author;
        this.available = true;
        this.borrower = null;
    }

    public Book(String title, String author, Person borrower) {
        //this.title = title;
        //this.author = author;
        this(title, author);

        if(borrower!= null){
            this.available = false;
            this.borrower = borrower;
        } else {
            this.available = true;
            this.borrower = null;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        this.available = (borrower == null);
    }

    // Modificator

    public int getNextId(){
        return sequencer++;
    }

    public String getBookInformation(){
        return "Book[" +
                "\n\tId: '" + id + '\'' +
                ",\n\tTitle: '" + title + '\'' +
                ",\n\tAuthor: '" + author + '\'' +
                ",\n\tAvailable: " + available +
                ",\n\tBorrower:" + borrower == null ? borrower.getFirstName() + " " + borrower.getLastName() : "" +
                ']';
    }
}