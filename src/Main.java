public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        int storageSize = 5;
        int itemNumbers = 20;
        int producersCount = 2;
        int consumersCount = 3; 

        main.starter(storageSize, itemNumbers, producersCount, consumersCount);
    }

    private void starter(int storageSize, int itemNumbers, int producersCount, int consumersCount) {
        Manager manager = new Manager(storageSize);

        // Створення виробників
        for (int i = 0; i < producersCount; i++) {
            new Producer(itemNumbers / producersCount, manager, "Producer-" + i);
        }

        // Створення споживачів
        for (int i = 0; i < consumersCount; i++) {
            new Consumer(itemNumbers / consumersCount, manager, "Consumer-" + i);
        }
    }
}
