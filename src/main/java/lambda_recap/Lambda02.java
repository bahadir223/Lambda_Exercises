package lambda_recap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda02 {

    public static void main(String[] args) {

        List<String> meyve = new ArrayList<>(Arrays.asList("elma", "portakal", "uzum", "cilek", "greyfurt",
                "nar", "mandalina", "armut", "elma", "keciboynuzu", "elma"));


        printFirstLetterEorC(meyve);
        System.out.println();
        printaddStarElement(meyve);
        System.out.println();
        System.out.println(printSortedElement(meyve));
    }


    // SORU1 : List elemanlarının ilk harfi 'e' veya 'c' olanlari yazdıralım.
    public static void printFirstLetterEorC(List<String> myList) {
        myList.
                stream().
                filter(t -> t.substring(0, 1).equals("e") || t.substring(0, 1).equals("c")).
                forEach(t -> System.out.print(t + " "));
    }

    // SORU2 : List elemanlarının hepsinin basina ve sonuna yildiz ekleyerek yazdiralim.
    public static void printaddStarElement(List<String> myList) {
        myList.stream().map(t -> "*" + t + "*").forEach(Utils::yazdir);
    }

    // SORU3 : List elemanlarını karakter sayısına gore buyukten kucuge sıralayınız,
    // karakter sayısı en buyuk ilk 3 elemanı List halinde return ederek yazdırınız.
    public static List<String> printSortedElement(List<String> myList) {
        return myList.
                stream().
                sorted(Comparator.comparing(t->t.toString().length()).reversed()).limit(3).
                collect(Collectors.toList());
    }

    //toString() i niye kullandik?
    //length ilk basta kizardi ama biz t.toString()
    // koyarak oraya karakter sayisinin bos olmayacaginin teminatini vermis olduk.


}
