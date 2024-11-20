/**
 * ClassName: Driver
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author: xzy
 * @Create: 2024/10/29 - 20:11
 */
import java.util.Scanner;
public class Driver {
    Scanner input = new Scanner(System.in);
    private Store store;
    public static void main(String[] args) {
        new Driver();
    }
    public Driver(){
        login();
        processBooks();
        runMenu();
    }
    private void login(){
        System.out.println("Please enter your name: ");
        String name = input.nextLine();
        System.out.println("Please enter your library card code: ");
        int card = input.nextInt();
        System.out.println("Hi honorific "+ name +"!");
    }


    private int mainMenu(){
        System.out.print("""
               Library Menu
               ---------
                  1) List the books
                  2) Display the first book you need to return
                  3) Revise your book information
                  0) Exit
               ==>> """);
        int option = input.nextInt();
        return option;
    }
    private void runMenu(){
        int option = mainMenu();

        while (option != 0) {
            switch (option) {
                case 1 -> printBooks();
                case 2 -> firstBook();
                case 3 -> revise();
                default -> System.out.println("Invalid option entered: " + option);
            }
            System.out.println("\nPress enter key to continue...");
            input.nextLine();
            input.nextLine();
            option = mainMenu();
        }
        System.out.println("Exiting...bye");
        System.exit(0);
    }


    private void revise(){
        System.out.println(store.listBooks());
        System.out.println("Which book do you want to review: ");
        int a = input.nextInt();
        Book b = store.books[a];
        System.out.println("Enter the new Book's Name:  ");
        input.nextLine();
        String newBookName = input.nextLine();
        System.out.println("Enter the new Book's Code:  ");
        int newBookCode = input.nextInt();
        System.out.println("Enter the new days you want to borrow:  ");
        int newBookDate = input.nextInt();
        store.change(a, newBookName, newBookCode, newBookDate);
        System.out.println("Book information has been updated.");

    }


    private void processBooks(){
        System.out.println("How many Books would you like to borrow");
        int numberBooks = input.nextInt();
        store = new Store(numberBooks);

        for (int i = 0; i < numberBooks; i++) {
            addBooks();
        }
    }
    private void addBooks(){
        input.nextLine();

        System.out.println("Enter the Book's Name:  ");
        String bookName = input.nextLine();
        System.out.println("Enter the Book's Code:  ");
        int bookCode = input.nextInt();
        System.out.println("Enter the days you want to borrow:  ");
        int bookDate = input.nextInt();
        System.out.println("Do you want the book in your current list: (y/n)");
        char whether = input.next().charAt(0);
        boolean inCurrent = false;
        if ((whether == 'y')||(whether == 'Y')){
            inCurrent = true;
        }
        boolean isAdded = store.add(new Book(bookName,bookCode,bookDate));
    }



    private void printBooks(){
            System.out.println("List of Books are:");
            System.out.println(store.listBooks());
        }
    public void firstBook() {
        Book firstToReturn = store.findFirstBookToReturn();
        if (firstToReturn!= null) {
            System.out.println("The first book to return is: " + firstToReturn);
        } else {
            System.out.println("No books to return.");
        }
    }
}







