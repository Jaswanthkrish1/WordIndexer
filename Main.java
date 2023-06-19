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
