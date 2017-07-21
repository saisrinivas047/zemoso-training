import java.io.*;
import java.util.*;

public class char_count {
    public static void main(String args[]) throws IOException {

        if (args.length != 0) {
            /**
             * Reading the input text file as command line argument
             */
            File f = new File(args[0]);
            BufferedReader file = new BufferedReader(new FileReader(f));
            /**
             * Creating a new text file to store the output values
             */
            BufferedWriter out_put = new BufferedWriter(new FileWriter("output"));

            Map<Character, Integer> map = new HashMap<>(); //map to store the key, values
            /**
             * converting the character in the file into a single line
             */
            StringBuilder out = new StringBuilder();
            String line;
            while ((line = file.readLine()) != null) {
                out.append(line);
            }
            String string = out.toString();
            file.close();

            /**
             * counting the frequency of characters in the text file
             */
            for (int i = 0; i < string.length(); i++) {
                char ch = string.charAt(i);
                if (ch == ' ')
                    continue;
                if (map.containsKey(ch))
                    map.put(ch, map.get(ch) + 1);
                else
                    map.put(ch, 1);
            }

            out_put.write(" " + "Character \tCount\n");

            /**
             * Writing the output into a text file
             */
            for (Map.Entry m : map.entrySet()) {
                out_put.write(" " + m.getKey() + "  \t\t " + m.getValue() + "\n");
                System.out.println(m.getKey() + "---" + m.getValue());
            }
            out_put.close();
            file.close();
        }
    }
}
