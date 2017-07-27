import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.junit.Assert.*;

public class AllowableDateRangeTest {
    @org.junit.Test
    public void getRange() throws Exception
    {
        AllowableDateRange allowableDateRange = new AllowableDateRange();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
        Calendar[] calendars = new Calendar[2];
        calendars[0]=Calendar.getInstance();
        calendars[1]=Calendar.getInstance();

        calendars[0].setTime(simpleDateFormat.parse("16-06-2017"));
        calendars[1].setTime(simpleDateFormat.parse("27-06-2017"));
        allowableDateRange.ConvertToDate("16-07-1998 27-06-2017");
        assertArrayEquals(calendars,allowableDateRange.getRange());

        calendars[0].setTime(simpleDateFormat.parse("14-01-2017"));
        calendars[1].setTime(simpleDateFormat.parse("15-03-2017"));
        allowableDateRange.ConvertToDate("13-02-1998 27-06-2017");
        assertArrayEquals(calendars,allowableDateRange.getRange());
    }

}