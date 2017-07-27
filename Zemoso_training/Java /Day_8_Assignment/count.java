import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class count {
    BufferedWriter writes;
    BufferedReader reads;
    Map<Character, Integer> map;
    String string;

    /**
     * Method to Read the input text file as command line argument
     * @param filename name of the input file
     * @throws IOException
     */
    void read(String filename) throws IOException {
        reads = new BufferedReader(new FileReader(filename));
        map = new HashMap<>();
    }

    /**
     * Method to convert the characters in the file into a single line
     * @throws IOException
     */
    void convert() throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reads.readLine()) != null) {
            sb = sb.append(line);
        }
        string = sb.toString();
        reads.close();
    }

    /**
     * Method to count the frequency of characters in the text file
     * @throws IOException
     */
    void counts() throws IOException {
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (ch == ' ')
                continue;
            else if (map.containsKey(ch))
                map.put(ch, map.get(ch) + 1);
            else
                map.put(ch, 1);
        }
        reads.close();
    }

    /**
     * Method to write the output into a new file
     * @throws IOException
     */
    void write() throws IOException {
        writes = new BufferedWriter(new FileWriter("new"));
        writes.write(" " + "Character \tCount\n");
        for (Map.Entry m : map.entrySet())
            writes.write(" " + m.getKey() + "  \t\t " + m.getValue() + "\n");

        System.out.println("The output file is created");
        writes.close();
        reads.close();

    }

    public static void main(String args[]) throws IOException {
        if (args.length != 0) {
            try {
                count c = new count();
                c.read(args[0]);
                c.convert();
                c.counts();
                c.write();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
