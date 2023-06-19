/*
 This code is avilable in my personal git ripository  you can check it.
https://github.com/Jaswanthkrish1/WordIndexer
 */
public class Main {
// Calling BookPageWordIndexer
    public static void main(String[] args) {
        // Creating object for bookPageWordIndexer
        BookPageWordIndexer indexer = new BookPageWordIndexer();
        //invoking genarateINdex
        indexer.generateIndex();
        // Invoked method work perfectly  then this msg will display.
        System.out.println("Index generated successfully!");
    }  
}
