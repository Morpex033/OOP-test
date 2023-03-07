import java.util.*;

public class Main {
    public static void main(String[] args) {
        WorkerList workerList = new WorkerList(generateHourWorker(10),generateFixedWorker(10),5);
        System.out.println("--------------------------------------------------------------------------");
        workerList.sortById();
        for (int i = 0; i < 3; i++) {
            System.out.println(workerList.get(i));
        }
    }

    public static List<HourWorker> generateHourWorker(int size) {
        Random random = new Random();
        String[] name = {"Robert", "Julia", "Martin", "Bob", "Kleiner", "Chak", "Jacob", "William", "Michael"};
        List<HourWorker> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            double pay = random.nextDouble(100) + 5;
            result.add(new HourWorker(0, pay, name[random.nextInt(name.length)]));
        }
        return result;
    }

    public static List<FixedWorker> generateFixedWorker(int size) {
        Random random = new Random();
        String[] name = {"Robert", "Julia", "Martin", "Bob", "Kleiner", "Chak", "Jacob", "William", "Michael"};
        List<FixedWorker> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            double pay = random.nextDouble(100) + 5;
            result.add(new FixedWorker(0, pay, name[random.nextInt(name.length)]));
        }
        return result;
    }
}