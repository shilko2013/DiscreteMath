package com.shilko.ru;

import javafx.util.Pair;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Bool {
    private List<Pair<String,Set<Integer>>> a;
    private int lines;
    private int n;
    private int steps;
    public Bool() {
        a = new ArrayList<Pair<String,Set<Integer>>>();
    }
    public int getSteps() {
        return steps;
    }
    private void stable() {
        for (int i = 0; i < a.size()-1; ++i)
            for (int j = i + 1; j < a.size(); ++j)
                if ((a.get(i).getKey().equalsIgnoreCase(a.get(j).getKey()))&&(i != j)) {
                    for (Integer e : a.get(j).getValue())
                        a.get(i).getValue().add(e);
                    a.remove(j);
                }
        lines = a.size();
        for (int i = 0; i < a.size(); ++i) {

        }
    }
    public void input(){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество переменных: ");
        n = in.nextInt();
        System.out.print("Введите количество строк: ");
        lines = in.nextInt();
        System.out.print("Введите количество итераций: ");
        steps = in.nextInt();
        in.nextLine();
        /*Scanner file = new Scanner(new FileInputStream("D://1.txt"));
        for (int i = 0; i < lines; ++i) {
            String s = file.nextLine();
            Set<Integer> l = new TreeSet<Integer>();
            l.add(i);
            a.add(new Pair(s,l));
        }*/
        for (int i = 0; i < lines; ++i) {
            System.out.print("Введите " + (i + 1) + "ую строку: ");
            String s = in.nextLine();
            Set<Integer> l = new TreeSet<Integer>();
            l.add(i);
            a.add(new Pair(s,l));
        }
    }
    public void input(String way) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите количество переменных: ");
        n = in.nextInt();
        System.out.print("Введите количество строк: ");
        lines = in.nextInt();
        System.out.print("Введите количество итераций: ");
        steps = in.nextInt();
        in.nextLine();
        Scanner file = new Scanner(new FileInputStream(way));
        for (int i = 0; i < lines; ++i) {
            String s = file.nextLine();
            Set<Integer> l = new TreeSet<Integer>();
            l.add(i);
            a.add(new Pair(s,l));
        }
    }
    public void output(boolean numberOfLines) {
        System.out.println();
        for (int i = 0; i < lines; ++i) {
            if (numberOfLines == true)
                System.out.print((i + 1) + " ");
            System.out.print(a.get(i).getKey() + " ");
            for (Integer e: a.get(i).getValue())
                System.out.print((e + 1) + " ");
            System.out.println();
        }
        System.out.println();
    }
    public void step() {
        if (steps <= 0)
            return;
        List<Pair<String,Set<Integer>>> temp = new ArrayList<Pair<String,Set<Integer>>>();
        String s = "";
        for (int i = 0; i < a.size()-1; ++i)
            for (int j = i + 1; j < a.size(); ++j) {
                int cnt = 0;
                for (int k = 0; k < n; ++k)
                    if (a.get(i).getKey().charAt(k) != a.get(j).getKey().charAt(k)) {
                        ++cnt;
                        s = a.get(i).getKey().substring(0,k) + "x" + a.get(i).getKey().substring(k+1,a.get(i).getKey().length());
                    }
                if (cnt == 1) {
                    Set<Integer> l = new TreeSet<Integer>();
                    for (Integer e: a.get(i).getValue())
                        l.add(e);
                    for (Integer e: a.get(j).getValue())
                        l.add(e);
                    Pair p = new Pair(s,l);
                    if (!temp.contains(p))
                        temp.add(p);
                }

            }
        a = temp;
        --steps;
        stable();
    }
}