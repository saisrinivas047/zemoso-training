import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Crawler2 {
    public static void main(String[] args) throws IOException {

        String dept = "";
        String dsc = "";
        String code = "";
        String rate = "";


        StringBuilder html =new StringBuilder(" ");
        int flag = -1;

        FileWriter fileWriter = null;
        final String NewLineSeparator = "\n";
        final String FileHeader = "Department,Code,Description,Rate"; //Heading to the CSV file


        try {


            fileWriter = new FileWriter("data.csv");
            fileWriter.append(FileHeader);
            fileWriter.append(NewLineSeparator);

            URL MyUrl = new URL("http://dme.ap.nic.in/ma/nims.html");
            BufferedReader br = new BufferedReader(new InputStreamReader(MyUrl.openStream()));
            String strTemp = "";
            while (null != (strTemp = br.readLine())) {
                html.append(strTemp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Document doc = Jsoup.parse(String.valueOf(html)); //parsing the html string
        Elements links = doc.select("p"); //Extracting the data in between the <p> tags

        String strTemp = "";

        for (Element elem : links) {

            strTemp = elem.text();


            strTemp = strTemp.replaceAll("\u00A0", ""); //replacing the space code

            if (strTemp.contains("ACCOMMODATION CHARGES"))
                break;

            if (strTemp.contains("DEPARTMENT")) {
                dept = strTemp.substring(strTemp.indexOf("OF") + 3);
                flag = 1;
                continue;
            }

            if (strTemp.contains("==") || strTemp.contains("--") || strTemp.equals("") || strTemp.equals("\n") || (strTemp.contains("CODE") && strTemp.contains("DESCRIPTION")))
                continue;

            if (flag == 1) {

                String data[] = strTemp.split(" ");

                if (data.length >= 3) {
                    code = strTemp.substring(0, strTemp.indexOf( ' ')).trim(); //Extracting the code
                    dsc = strTemp.substring(strTemp.indexOf(' '), strTemp.lastIndexOf(' ')); //Extracting the Description
                    rate = strTemp.substring(strTemp.lastIndexOf(' ')).trim(); //Extracting the Rate
                    System.out.println("Code : " + code + " Dsc : " + dsc + " Rate : " + rate);
                    exportToCSV(fileWriter, dept, code, dsc, rate);
                }

            }
        }

    }

    public static void exportToCSV(FileWriter fileWriter, String dept, String code, String desc, String rate) throws IOException {
        fileWriter.append(dept + "," + code + "," + desc + "," + rate);
        fileWriter.append("\n");
    }
}

