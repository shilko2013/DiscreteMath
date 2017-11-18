package com.shilko.ru;

import javafx.util.Pair;

import java.io.FileNotFoundException;
import java.util.*;

public class Main{
    public static void main(String[] args) {
        System.out.println("Строки, включающие d, также нужно вводить!");
        Bool b = new Bool();
        try {
            b.input(new String("D://1.txt"));
        }
        catch (FileNotFoundException e) {}
        while (b.getSteps()>0) {
            b.step();
            b.output(true);
        }
    }
}
