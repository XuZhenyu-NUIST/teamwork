/**
 * ClassName: Store
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author: xzy
 * @Create: 2024/11/9 - 13:51
 */
public class Store {
    public Book[] books;
    private int total = 0;
    public Store(int numberBooks){
        books = new Book[numberBooks];
    }
    private boolean isFull() {
        return total == books.length;
    }
    private boolean isEmpty() {
        return total == 0;
    }
    public boolean add(Book book){
        if (isFull()){
            return false;
        }else{
            books[total] = book;
            total++;
            return true;
        }
    }




    public void change(int b, String newBookName, int newBookCode, int newBookDate){
        Book book = books[b];
        book.setBookName(newBookName);
        book.setBookCode(newBookCode);
        book.setBookDate(newBookDate);

    }
    public String listBooks() {
        if (isEmpty()) {
            return "No books in the store";
        } else {
            String listOfBooks = "";
            for (int i = 0; i < total; i++) {
                listOfBooks += i + ": " + books[i] + "\n";
            }
            return listOfBooks;



        }
    }

    public Book findFirstBookToReturn() {
        if (isEmpty()) {
            return null;
        }
        Book firstBook = books[0];
        for (int i = 1; i < total; i++) {
            if (books[i].getBookDate() < firstBook.getBookDate()) {
                firstBook = books[i];
            }
        }
        return firstBook;
    }

}
