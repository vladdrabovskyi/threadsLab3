public class Consumer implements Runnable {
    private final int itemNumbers;
    private final Manager manager;
    private final String name;

    public Consumer(int itemNumbers, Manager manager, String name) {
        this.itemNumbers = itemNumbers;
        this.manager = manager;
        this.name = name;

        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < itemNumbers; i++) {
            try {
                manager.empty.acquire();
                manager.access.acquire();

                String item = manager.storage.remove(0);
                System.out.println(name + " consumed " + item);

                manager.access.release();
                manager.full.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
