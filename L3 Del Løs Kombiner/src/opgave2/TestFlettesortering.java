package opgave2;

import java.util.ArrayList;
import java.util.Arrays;

import opgave1.Summering;
import src.fletning.FletteSorteringMedTODO;

public class TestFlettesortering {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        list.addAll(Arrays.asList(new Integer[] { 1, 2, 3, 4, 0, 5 }));
        System.out.println(TællerElementer.værdiNul(list));
    }

}
