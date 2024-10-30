package se.lexicon;

import java.util.Random;


public class Book {
    private String id;
    private String title;
    private String author;
    private boolean available;
    private Person borrower;


    public Book(String title, String author) {
        this.id=generateRandomId();
        this.title = title;
        this.author = author;
        this.setBorrower(null);


    }



    public Book(String title, String author, Person borrower) {
        this(title,author);
        this.setBorrower(borrower);
        borrower.bookList(this);

    }


    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }


    public Person getBorrower() {
        return borrower;
    }

    public void setBorrower(Person borrower) {
        this.borrower = borrower;
        if(borrower!= null) {
            this.available = false;
        }else{
            this.available=true;
        }

    }



    private String displayBorrowerName(){
        String name="None";
        if(borrower!=null){
          name = borrower.name();
       }
      return name;
   }



    private String generateRandomId() {
        Random random=new Random();
        int randomId= random.nextInt(1000);
        return "BK-"+ randomId;
    }



    public String getBookInformation(){
        StringBuilder sb=new StringBuilder();
        sb.append("ID: ");
        sb.append(getId());
        sb.append(", Book: ");
        sb.append(title);
        sb.append(" , Author: ");
        sb.append(author);
        sb.append(" , Available: ");
        sb.append(available);
        sb.append(" , Borrower:");
        sb.append(displayBorrowerName() );
        return sb.toString();
    }

}
