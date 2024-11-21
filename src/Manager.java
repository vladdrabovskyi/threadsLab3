import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Manager {

    public Semaphore access; // Семафор для доступу до сховища
    public Semaphore full; // Семафор для перевірки, чи є місце в сховищі
    public Semaphore empty; // Семафор для перевірки, чи є продукція в сховищі

    public ArrayList<String> storage = new ArrayList<>();

    public Manager(int storageSize) {
        access = new Semaphore(1);
        full = new Semaphore(storageSize);
        empty = new Semaphore(0);
    }
}
