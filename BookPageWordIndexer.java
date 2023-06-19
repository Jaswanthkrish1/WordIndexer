import java.io.*;
import java.util.*;
//Thsi code is Updated in git 
public class BookPageWordIndexer {
    private Map<String, Set<Integer>> wordIndex;

    public BookPageWordIndexer() {
        wordIndex = new TreeMap<>();
    }
    //Invoked by the Main Class.
    public void generateIndex() {
        try {
            // Read book pages and exclude words
            List<String> bookPages = readBookPages();
            Set<String> excludeWords = readExcludeWords();

            // Process each page
            for (int pageNum = 1; pageNum <= bookPages.size(); pageNum++) {
                String pageContent = bookPages.get(pageNum - 1);
                processPage(pageContent, pageNum, excludeWords);
            }

            // Write the index to file
            writeIndexToFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<String> readBookPages() throws IOException {
        List<String> bookPages = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            String fileName = "Page" + i + ".txt";
            bookPages.add(readFileContent(fileName));
        }
        return bookPages;
    }

    private Set<String> readExcludeWords() throws IOException {
        String fileName = "exclude-words.txt";
        String content = readFileContent(fileName);
        return new HashSet<>(Arrays.asList(content.split("\\s+")));
    }

    private void processPage(String pageContent, int pageNum, Set<String> excludeWords) {
        String[] words = pageContent.split("\\W+");
        for (String word : words) {
            word = word.toLowerCase();
            if (!excludeWords.contains(word)) {
                if (!wordIndex.containsKey(word)) {
                    wordIndex.put(word, new TreeSet<>());
                }
                wordIndex.get(word).add(pageNum);
            }
        }
    }

    private void writeIndexToFile() throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("index.txt"))) {
            for (Map.Entry<String, Set<Integer>> entry : wordIndex.entrySet()) {
                writer.write(entry.getKey() + " : ");
                writer.write(pagesToString(entry.getValue()));
                writer.newLine();
            }
        }
    }

    private String pagesToString(Set<Integer> pages) {
        StringBuilder builder = new StringBuilder();
        boolean first = true;
        for (int page : pages) {
            if (!first) {
                builder.append(", ");
            }
            builder.append(page);
            first = false;
        }
        return builder.toString();
    }

    private String readFileContent(String fileName) throws IOException {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        }
        return builder.toString();
    }

    
}
