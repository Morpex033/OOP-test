package org.example.sharipov.database;

import org.example.sharipov.models.FixedWorker;
import org.example.sharipov.models.HourWorker;
import org.example.sharipov.models.IWorker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkerList {

    private static List<IWorker> workerList;

    public IWorker get(int id) {
        return workerList.get(id);
    }

    public WorkerList(List<HourWorker> hourWorkerList, List<FixedWorker> fixedWorkerList, int size) {
        this.workerList = workerList(hourWorkerList, fixedWorkerList, size);

    }


    public static List<IWorker> workerList(List<HourWorker> hourWorkerList, List<FixedWorker> fixedWorkerList, int size) {
        int day = 31;
        IWorker temp = null;
        List<IWorker> workerList = new ArrayList<>();
        for (HourWorker worker : hourWorkerList) {
            workerList.add(worker);
        }
        for (FixedWorker worker : fixedWorkerList) {
            workerList.add(worker);
        }
        sortByPayroll(workerList, day);
        int intTemp = 0;
        for (IWorker worker : workerList) {
            System.out.println(worker.toString());
            intTemp++;
            if (intTemp == size) {
                break;
            }
        }
        return workerList;
    }

    public static void sortByPayroll(List<IWorker> list, int day) {
        boolean temp = false;
        int id = 0;
        while (!temp) {
            temp = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).payroll(day) < list.get(i + 1).payroll(day)) {
                    temp = false;

                    Collections.swap(list, i, i + 1);
                    list.get(i).setId(id++);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            IWorker userTemp = list.get(i);
            int idTemp = 0;
            if (userTemp.getId() == 0) {
                for (IWorker worker :
                        list) {
                    if (worker.getId() > idTemp) {
                        idTemp = worker.getId();
                    }
                }
                list.get(i).setId(idTemp + 1);
            }
        }
    }

    public void sortById() {
        boolean temp = false;
        while (!temp) {
            temp = true;
            for (int i = 0; i < workerList.size() - 1; i++) {
                if (workerList.get(i).getId() < workerList.get(i + 1).getId()) {
                    temp = false;

                    Collections.swap(workerList, i, i + 1);
                }
            }
        }
    }
}
