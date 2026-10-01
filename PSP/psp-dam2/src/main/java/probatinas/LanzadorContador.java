package probatinas;


public class LanzadorContador implements Runnable {

    private int value = 0;
    private static Counter counter = new Counter();
    public LanzadorContador(int value) {
        super();
        this.value = value;
    }
    public static void main(String[] args) {
        try {
            Thread t1 = new Thread(new LanzadorContador(100000));
            Thread t2 = new Thread(new LanzadorContador(-100000));
            t1.start();
            t2.start();
            t1.join();
            t2.join();
// resultado esperado: 0
            System.out.println(counter.getValue());
        } catch (InterruptedException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @Override
    public void run() {
        if(value>=0) {
            for (int i = 0; i < value; i++) {
                counter.increment();
            }
        } else {
            for (int i = 0; i > value; i--) {
                counter.decrement();
            }
        }
    }

}

class Counter {
    private int c = 0;
    public void increment() {
        c++;
    }
    public void decrement() {
        c--;
    }
    public int getValue() {
        return c;
    }
}
