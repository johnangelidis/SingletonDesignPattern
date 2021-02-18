package SingletonDesignPattern;

import java.util.HashMap;
/**
 * Create a singleton for a library
 */
public class Library {
    private static HashMap<String, Integer> books;
    private static Library library;

    private Library() {
        books = new HashMap<String, Integer>();
    }

    /**
     * Static method that creates an instance of a library
     * @return an object of type Library
     */
    public static Library getInstance() {
        if (library == null) {
            library = new Library();
        }
        System.out.println("Creating our Library. Time to begin reading.");
        return library;
    }

    /**
     * Method that checks out a given book by reducing the number of copies by 1
     * @param bookName
     */
    public void checkoutBook(String bookName){
        if(books.containsKey(bookName) && books.get(bookName) >= 1){ //check if book is in library and if it has at least one copy
            books.put(bookName, books.get(bookName)-1); //update the number of copies by reducing it by 1
            System.out.println(bookName + " was successfully checked out.");
        }
        else{
            System.out.println("Sorry, " + bookName + " is not in stock.");
        }
    }

    /**
     * Method that checks in a book given its name and number of copies to be added
     * @param bookname, numToAdd
     */
    public void checkInBook(String bookname, int numToAdd){
          
        if(books.containsKey(bookname)){ //check if book is already in the library
            books.put(bookname,books.get(bookname)+numToAdd); //if it is, add numToAdd number of copies
            System.out.println("A new copy of " + bookname + " was added to the library.");
        }
        else{ //else add the book and number of copies given
            books.put(bookname, numToAdd);
            System.out.println(bookname + " was added to the library.");
        }
    }
    /**
     * Method that prints the inventory by printing all the keys and values in the hash map
     */
    public void displayBooks(){
        System.out.println("Inventory:");
        for(String i:books.keySet()){
            System.out.println("- " + i + ", " + "copies: " + books.get(i));
        }
    }
}