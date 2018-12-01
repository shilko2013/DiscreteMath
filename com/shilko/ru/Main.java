package com.shilko.ru;

import java.io.FileNotFoundException;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        System.out.println("Строки, включающие d, также нужно вводить!");
        Bool b = new Bool();
        try {
            b.input("1.txt");
        }
        catch (FileNotFoundException ignored) {}
        while (b.getSteps()>0) {
            b.step();
            b.output(true);
        }
    }
}
