package lambda_recap;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda01 {

    public static void main(String[] args) {

        List<Integer> sayi = new ArrayList<>(Arrays.asList(-5, -8, -12, 0, 1, 12, 5, 5, 6, 9, 15, 8));

        printPositiveCoupleElement(sayi);
        System.out.println();
        printPositiveCoupleElement2(sayi);
        System.out.println();
        printSquareElement(sayi);
        System.out.println();
        printSquareElement2(sayi);
        System.out.println();
        printDistinctSquareElement(sayi);
        System.out.println();
        buyuktenKucugeSirala(sayi);
        System.out.println();
        gorev(sayi);
        System.out.println();
        toplamMetRef(sayi);
        toplamLambdaEx(sayi);
        System.out.println();
        System.out.println(printCoupleElementSquareSort(sayi));
        System.out.println(printCoupleElementSquareSort2(sayi));


    }


    //SORU1: List elemanlarının çift ve pozitif olanlarını,
    // Lambda Expression kullanarak aralarında bosluk olacak sekilde yazdırın.

    public static void printPositiveCoupleElement(List<Integer> myList) {
        myList.
                stream().
                filter(t -> t > 0).
                filter(t -> t % 2 == 0).
                forEach(t -> System.out.print(t + " "));
    }

    //SORU2: List elemanlarının çift ve pozitif olanlarını, Method Referances kullanarak
    // aralarında bosluk olacak sekilde yazdırın.

    public static void printPositiveCoupleElement2(List<Integer> myList) {
        myList.stream().filter(t -> t % 2 == 0 && t > 0).forEach(Utils::yazdir);
    }

    //SORU3 : List elemanlarının karelerini, aralarında bosluk olacak sekilde yazdırın.
    public static void printSquareElement(List<Integer> myList) {
        myList.
                stream().
                map(t -> t * t).
                forEach(Utils::yazdir);
    }

    public static void printSquareElement2(List<Integer> myList) {
        myList.
                stream().
                map(Utils::kareBul).
                forEach(Utils::yazdir);
    }

    //SORU4 : List elemanlarının karelerini, tekrarsiz yazdırın.
    public static void printDistinctSquareElement(List<Integer> myList) {
        myList.stream().map(Utils::kareBul).distinct().forEach(Utils::yazdir);
    }

    //SORU5: List elemanlarını buyukten kucuge sıralayarak yazdırın
    public static void buyuktenKucugeSirala(List<Integer> myList) {
        myList.stream().sorted(Comparator.reverseOrder()).forEach(Utils::yazdir);

    }

    // SORU6 : List elemanlarının pozitif olanlarının, kuplerini bulup, birler basamagı 5 olanları yazdırınız
    public static void gorev(List<Integer> myList) {
        myList.stream().filter(t -> t > 0).map(t -> t * t * t).filter(t -> t % 10 == 5).forEach(Utils::yazdir);
    }

    // SORU7: List elemanlarının Method References ile toplamını bulun ve yazdırın.
    public static void toplamMetRef(List<Integer> myList) {

        Optional<Integer> sonuc = myList.stream().reduce(Integer::sum);

        System.out.println(sonuc);

    }

    // SORU8: List elemanlarının Lambda Expression ile toplamını bulun ve yazdırın.
    public static void toplamLambdaEx(List<Integer> myList) {

        int toplam = myList.stream().reduce(0, (t, u) -> t + u);
        System.out.println(toplam);

    }

    //SORU9 : Listin cift elemanlarının, karelerini, kucukten buyuge sıralayıp
    // list halinde return ederek yazdırınız
    //Lambda Expression ile

    public static List<Integer> printCoupleElementSquareSort(List<Integer> myList) {
        return myList.
                stream().
                filter(t -> t % 2 == 0).
                map(t->t*t).
                sorted().
                collect(Collectors.toList());
    }

    //Method Referances ile
    public static List<Integer> printCoupleElementSquareSort2(List<Integer> myList) {
        return myList.
                stream().
                filter(Utils::ciftMi).
                map(Utils::kareBul).
                sorted().
                collect(Collectors.toList());

    }



}
