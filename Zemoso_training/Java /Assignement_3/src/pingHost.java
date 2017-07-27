import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.IOException;

public class pingHost
{
    /**
     * Method to return the median time taken to ping a host
     * @param host host adsress
     * @throws IOException
     */
    public void Median(String host) throws IOException {
        try {
            Process p = Runtime.getRuntime().exec(host); //Excecuting the command
            BufferedReader inputStream = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String s = " ";
            List<String> times = new ArrayList<>(); //List to store the times
            List<String> result = new ArrayList<>(); //List to store the ping results

            Pattern pattern = Pattern.compile(".*?time=(.*?ms)"); //Regex pattern to extract time

            /**
             * Loop which will add the ping results to the list
             */
            while((s = inputStream.readLine()) != null) {
                    result.add(s + "\n");
            }

            System.out.println("The Ping results : " + "\n" + result + "\n \n" );
            /**
             * Lopp which searches the list for the regex pattern and returns the time and adds it to the list
             */
            for(String str:result) {
                if (!str.isEmpty() && str != null) {
                    Matcher m = pattern.matcher(str);

                    if (m.find()) {
                        String timeInMs = m.group(1);
                        times.add(timeInMs);
                    }
                }
            }

            Collections.sort(times); //Sorting the times in the List
            System.out.println("The times taken to ping " + times + "\n \n" );

            int l = times.size();
            if(l % 2 == 0)
                System.out.println("The median time is : " + times.get((times.get(l/2) + times.get(l / 2 - 1)) / 2));
            else
                System.out.println("The median time is : " + times.get(l/2));

            } catch(Exception e){
                e.printStackTrace();
            }
    }

    public static void main(String[] args) throws IOException{
        pingHost pingHost = new pingHost();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the host address you want to ping");
        String string = sc.next();
        System.out.println("Enter the number of times you want to ping");
        int n = sc.nextInt();
        String s = "ping -c "+ n + " "+ string;
        pingHost.Median(s);
    }
}
