import java.io.*;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Pattern;

public class Find_file {
    /**
     * Class that extends java class SimpleFileVisitor to traverse the file tree
     */
    public static class Find extends SimpleFileVisitor<Path> {
        private Pattern p;
        /**
         * Constructor which initializes the regex pattern
         * @param pattern the regex pattern
         */
        Find(String pattern) {
            p = Pattern.compile(pattern);
        }
        /**
         * Method which takes file name as a input and checks it with the Regex Pattern
         * @param file name of the file
         * @param attr attributes of the directory
         * @return Continues searching through the tree
         * @throws IOException
         */
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attr) throws IOException {
            if(file != null){
                if(p.matcher(file.toString()).matches())
                    System.out.println(file.toFile().getAbsoluteFile());
            }
            return FileVisitResult.CONTINUE;
        }

        /**
         * Method which skips the file when it is unable to visit the file
         * @return It Skips the Subtree
         * @throws IOException
         */
        @Override
        public FileVisitResult visitFileFailed(Path path, IOException e) throws IOException {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }

    public static void main(String a[]) throws IOException {
        System.out.println("Enter the RegExp or '-1' to exit ");
        Scanner scan = new Scanner(System.in);
        String regularExp = scan.next();
        Path sDir = Paths.get("/home"); //Directory to be searched

        try {
            while (!(regularExp.equalsIgnoreCase("-1"))) {
                Find f = new Find(regularExp);
                Files.walkFileTree(sDir, f); //traverses through the whole directory and sub directories
                System.out.println("Enter the RegExp '-1' to exit");
                regularExp = scan.next();
            }
            scan.close();
        } catch (IOException e){System.out.println(e);}
    }
}



















