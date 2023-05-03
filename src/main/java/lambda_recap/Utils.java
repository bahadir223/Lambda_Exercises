package lambda_recap;

import java.util.List;

public class Utils {

    public static void yazdir(Object a) {    //niye int demedik? cünkü biz String elemanlari da yazdirabiliriz, //bize kolaylik saglamasi icin
        System.out.print(a + " ");

    }

    public static int kareBul(int a){
        return a*a;
    }


    public static boolean ciftMi(int a){
        return a%2==0;
    }


}
