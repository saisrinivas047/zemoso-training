import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AllowableDateRange
{
    Calendar signupDate, currentDate; //Initializing the KYC's Signup and Current date
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy"); //Setting the Date format

    /**
     * Method that Converts the Given string into two dates
     * @param dates input date string
     * @throws ParseException
     */
    public void ConvertToDate(String dates) throws ParseException {
        signupDate = Calendar.getInstance();
        currentDate = Calendar.getInstance();
        String[] strings =dates.split(" ");

        signupDate.setTime(simpleDateFormat.parse(strings[0]));
        currentDate.setTime(simpleDateFormat.parse(strings[1]));
    }

    /**
     * Method to get the range of the KYC Form
     * @return range
     * @throws IndexOutOfBoundsException
     */
    public Calendar[] getRange() throws IndexOutOfBoundsException {
        Calendar[] range = new Calendar[2];
        Calendar KYC_startDate, KYC_endDate;

        KYC_startDate = (Calendar) signupDate.clone();
        KYC_startDate.set(Calendar.YEAR, currentDate.get(Calendar.YEAR));
        KYC_startDate.add(Calendar.DAY_OF_MONTH, -30);

        KYC_endDate= (Calendar) signupDate.clone();
        KYC_endDate.set(Calendar.YEAR,currentDate.get(Calendar.YEAR));
        KYC_endDate.add(Calendar.DATE,30);

        if(currentDate.after(KYC_startDate)) {
            range[0] = KYC_startDate;
            if (currentDate.after(KYC_endDate)) {
                range[1] = KYC_endDate;
            } else {
                range[1] = currentDate;
            }
        }else
            throw new IndexOutOfBoundsException("KYC is in future");

        return range;
                }

    /**
     * Method to print the Range of the KYC
     * @param str input string
     * @throws ParseException
     */
    public void printRange(String str) throws ParseException {
        ConvertToDate(str);
        try {
            Calendar[] calendars = getRange();
            StringBuilder s=new StringBuilder(simpleDateFormat.format(calendars[0].getTime()));
            s.append(" ");
            s.append(simpleDateFormat.format(calendars[1].getTime()));
            System.out.println(s);
        }catch (IndexOutOfBoundsException e){
            System.out.println("No Range");
        }
    }

    public static void main(String a[]) throws ParseException {
        AllowableDateRange allowableDateRange = new AllowableDateRange();
        allowableDateRange.printRange("16-07-1998 27-06-2017");
        allowableDateRange.printRange("04-02-2016 04-04-2017");
        allowableDateRange.printRange("04-05-2017 04-04-2017");
        allowableDateRange.printRange("04-04-2015 04-04-2016");
        allowableDateRange.printRange("04-04-2015 15-03-20167");
    }
}


