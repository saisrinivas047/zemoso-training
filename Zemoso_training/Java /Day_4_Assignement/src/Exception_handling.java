
public class Exception_handling {
    static void exceptions(int i) throws Exception_1, Exception_2, Exception_3
    {
        /**
         *content of the exceptions
         */
        if(i == 18)
            throw new Exception_1("you are 18 so not valid");
        else if(i<18)
            throw new Exception_2("you are less than 18 so not valid");
            else if(i>100)
                throw new Exception_3("you are greater than 100 so not valid");
            else
                throw new NullPointerException("its ok");
    }
}
