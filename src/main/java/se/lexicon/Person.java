package se.lexicon;

public class Person {

    private static int sequencer=0;
    private int id;
    private String firstName;
    private String lastName;


    public Person(String firstName, String lastName) {
        this.id=Person.getNextId();
        this.firstName = firstName;
        this.lastName = lastName;
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
            System.out.println("Book is available");
        }else{
            System.out.println("Book is not available");
            System.out.println("Book is borrowed by :"+book.getBorrower().name());
        }

    }

    public void returnBook(Book book){
        book.returnBook();
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
