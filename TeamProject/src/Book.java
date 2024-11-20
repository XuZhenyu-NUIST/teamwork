/**
 * ClassName: Book
 * Package: PACKAGE_NAME
 * Description:
 *
 * @Author: xzy
 * @Create: 2024/11/9 - 13:51
 */
public class Book {
    private String bookName = "";
    private  int bookCode = -1;
    private  int bookDate = 0;

    public Book(String bookName, int bookCode, int bookDate){
        this.bookName = bookName;
        this.bookCode = bookCode;
        this.bookDate = bookDate;
    }
    public String getBookName(){
        return bookName;
    }
    public int getBookCode(){
        return bookCode;
    }
    public int getBookDate(){
        return bookDate;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }
    public void setBookCode(int bookCode){
        this.bookCode = bookCode;
    }
    public void setBookDate(int bookDate){
        this.bookDate = bookDate;
    }
    public String toString(){
        return "Book name: " + bookName
                +", bookCode: " + bookCode
                +", bookDate: " + bookDate;
    }
}
