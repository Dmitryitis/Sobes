package ru.kpfu.itis.group905.gerasimov.primer.Sob;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static java.util.Map.Entry.comparingByValue;
// Считываем с файла в хэш мапу, все товары с подсчетом повторения товаров, дальше сортируем от макс до минимума, и сортируем
// ключи в хэш мапе, то есть сортируем по популятности наши товары

public class Task2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir") + "/gerasimov_905_2/src/ru/kpfu/itis/group905/gerasimov/primer/Sob/transactions.csv"));
        HashMap<String, Integer> map = new HashMap<>();

        int count = 1;
        while (reader.ready()) {
            String[] line = reader.readLine().split(";");
            if (map.containsKey(line[0])) {
                map.put(line[0], map.get(line[0]) + 1);
            } else {
                map.put(line[0], count);
            }
        }

        map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(System.out::println);
        for (Map.Entry<String, Integer> s : map.entrySet()){
            System.out.println(s.getKey());
            System.out.println(s.getValue());
        }
    }
}
