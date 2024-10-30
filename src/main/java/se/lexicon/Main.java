package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Person person1=new Person("Sayana","Surendran");
    Book book1=new Book("Treasure Island","Stevenson", person1);
        Book book2=new Book("Romeo and Juliet","William Shakespeare");
       System.out.println(book1.getBookInformation());
        System.out.println(person1.getPersonInformation());

        person1.loanBook(book1);
        person1.loanBook(book2);
    }
}