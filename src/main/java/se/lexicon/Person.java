package se.lexicon;

import java.util.Arrays;

public class Person {

    private static int sequencer=0;
    private int id;
    private String firstName;
    private String lastName;
    private Book[] loanedBooks;


    public Person(String firstName, String lastName) {
        this.id=Person.getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
        this.loanedBooks=new Book[]{};
    }

    private static int getNextId(){
        return sequencer++;
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

    public String name(){
        return getFirstName()+ " "+ getLastName();
    }

    public void loanBook(Book book){
        if(book.isAvailable()){
             book.setBorrower(this);
             bookList(book);
        }else{
            System.out.println("Book is not available");
            System.out.println("Book is borrowed by :"+book.getBorrower().name());
        }
        displayLoanedBooks();

    }

    public void bookList(Book book) {
        loanedBooks=Arrays.copyOf(loanedBooks,loanedBooks.length+1);
        loanedBooks[loanedBooks.length-1]=book;
    }

    public void returnBook(Book book){
        Book loanBooks[]=new Book[loanedBooks.length -1];
        int j=0;
        for(int i=0;i< loanedBooks.length;i++){
            if(loanedBooks[i]!=book){
                 book.setBorrower(null);
                 loanBooks[j]=loanedBooks[i];
                 j++;
            }

        }
        displayLoanedBooks();


    }

    private void displayLoanedBooks(){
        for(int i=0;i< loanedBooks.length;i++){
            System.out.println(loanedBooks[i].getBookInformation());

        }

            }

    public String getPersonInformation(){
        StringBuilder sb=new StringBuilder();
        sb.append("id: ");
        sb.append(id);
        sb.append(" , name: ");
        sb.append(name());

        return sb.toString();
    }
}
