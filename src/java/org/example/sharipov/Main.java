package org.example.sharipov;

import org.example.sharipov.database.WorkerList;
import org.example.sharipov.models.FixedWorker;
import org.example.sharipov.models.HourWorker;

import java.util.*;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        WorkerList workerList = new WorkerList(generateHourWorker(1000), generateFixedWorker(1000), 5);
        System.out.println("--------------------------------------------------------------------------");
        workerList.sortById();
        for (int i = 0; i < 3; i++) {
            System.out.println(workerList.get(workerList.size() - 1 - i));
        }
    }

    public static List<HourWorker> generateHourWorker(int size) {
        String[] name = {"Robert", "Julia", "Martin", "Bob", "Kleiner", "Chak", "Jacob", "William", "Michael"};
        List<HourWorker> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            double pay = random.nextDouble(100) + 5;
            result.add(new HourWorker(0, pay, name[random.nextInt(name.length)]));
        }
        return result;
    }

    public static List<FixedWorker> generateFixedWorker(int size) {
        String[] name = {"Robert", "Julia", "Martin", "Bob", "Kleiner", "Chak", "Jacob", "William", "Michael"};
        List<FixedWorker> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            double pay = random.nextDouble(100) + 5;
            result.add(new FixedWorker(0, pay, name[random.nextInt(name.length)]));
        }
        return result;
    }
}