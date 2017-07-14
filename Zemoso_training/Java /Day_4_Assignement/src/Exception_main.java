public class Exception_main
{
    public static void main(String args[])
    {
        try
        /**
         * Exception handling unsing try-catch method
         */
        {
            Exception_handling.exceptions(80);
        } catch (Exception e) {
            System.out.println(e);
        }
        finally{
            /**
             * will always be executed whether exception is handled or not
             */
            System.out.println("Finally is the boss its always gets printed");
        }
    }
}
