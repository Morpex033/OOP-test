package org.example.sharipov.database;

import org.example.sharipov.models.FixedWorker;
import org.example.sharipov.models.HourWorker;
import org.example.sharipov.models.Worker;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkerList {

    private static List<Worker> list;

    private static int counter;
    private static final int day = 31;

    public Worker get(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public WorkerList(List<HourWorker> hourWorkerList, List<FixedWorker> fixedWorkerList, int size) {
        list = workerList(hourWorkerList, fixedWorkerList);
        sortByPayroll(day);
        for (int i = size; i > 0; i--) {
            System.out.println(list.get(i).toString());
        }
    }


    public static List<Worker> workerList(List<HourWorker> hourWorkerList, List<FixedWorker> fixedWorkerList) {
        List<Worker> workerList = new ArrayList<>();
        for (HourWorker worker : hourWorkerList) {
            worker.setId(counter++);
            workerList.add(worker);
        }
        for (FixedWorker worker : fixedWorkerList) {
            worker.setId(counter++);
            workerList.add(worker);
        }
        return workerList;
    }

    public static void sortByPayroll(int day) {
        long testTime = System.currentTimeMillis();
        for (int i = 0; i < WorkerList.list.size(); i++) {
            Comparator<Worker> comparator = Comparator.comparing(worker -> worker.payroll(day));
            list.sort(comparator);
        }
        System.err.println("Сортировка по выплатам завершена за: " + ((double) System.currentTimeMillis() - testTime) / 1000);
    }

    public void sortById() {
        long testTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Comparator<Worker> comparator = Comparator.comparing(worker -> worker.getId());
            list.sort(comparator);
        }
        System.err.println("Сортировка по ID завершена за: " + ((double) System.currentTimeMillis() - testTime) / 1000);
    }
}
