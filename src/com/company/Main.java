package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        lvl(100);
        System.out.println("Победа!");
        BufferedReader sc = new BufferedReader(new FileReader("score.txt"));
        String str;
        ArrayList<String> list = new ArrayList<>();
        while ((str = sc.readLine()) != null) {
            if(!str.isEmpty()) {
                list.add(str);
            }
        }
        System.out.println("В лучшей игре число угадано с " + Collections.min(list) + " попытки");
    }
    private static void lvl(int scope) {
        int number = (int) (Math.random() * scope);
        System.out.println("Попробуй угадать число от 1 до " + scope);
        int i = 0;
        while (i < scope) {
            int input_number = scanner.nextInt();
            i++;
            if (input_number == number) {
                System.out.println("Число " + number + " угадано с " + i + " попытки");
                try(FileWriter writer = new FileWriter("score.txt", true))
                {
                    writer.write(i + "\n");
                }
                catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            } else if (input_number > number) {
                System.out.println("Не ожидал от тебя такого. Загаданное число меньше, брат");
            } else {
                System.out.println("Я сам в шоке, но, загаданное число больше, брат");
            }
        }
    }
}
