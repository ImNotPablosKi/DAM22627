package Estudio;

import java.util.Random;

public class SynchronycedBascio {
    static void main() {
        Progreso progreso = new Progreso();
        Thread hiloProceso = new Thread(progreso);
        hiloProceso.start();

        for (int i = 0; i < 10; i++) {
            Thread h;
            if (i>=5){
                h = new Thread(new Hilo(1, "Hilo"+i, progreso));
            } else {
                h = new Thread(new Hilo(2, "Hilo"+i, progreso));
            }
            h.start();
        }
    }
}

class Progreso implements Runnable {

    private int meta = 100;
    private int progreso = meta / 2;
    private int ronda = 1;
    private int rondaMax = 3;
    private boolean empezada = true;

    public Progreso(int progreso, int meta, int ronda, int rondaMax) {
        this.progreso = progreso;
        this.meta = meta;
        this.ronda = ronda;
        this.rondaMax = rondaMax;
    }

    public Progreso() {
    }

    public synchronized boolean reducir(String s) throws InterruptedException {
        if (progreso >= 0 && progreso <= meta && empezada) {
            wait();
            int resta = new Random().nextInt(0, 21);
            progreso -= resta;
            System.out.println("---- HILO:" + s + " RESTA:" + resta + " ----" + (resta > 14 ? "!!!" : ""));
            return true;

        }
        return ronda <= rondaMax;
    }

    public synchronized boolean aumentar(String s) {
        if (progreso >= 0 && progreso <= meta && empezada) {
            int suma = new Random().nextInt(0, 21);
            progreso += suma;
            System.out.println("++++ HILO:" + s + " SUMA:" + suma + " ++++" + (suma > 14 ? "!!!" : ""));
            notifyAll();
            return true;
        }
        return ronda <= rondaMax;
    }

    @Override
    public void run() {
        System.out.println(" ====== RONDA " + ronda + " ====== ");
        try {
            while (true) {
                int actual;
                synchronized (this) {
                    actual = progreso;
                }

                if (actual >= 0 && actual <= meta) {
                    // Para imprimirlo de una uso StringBuilder
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < meta; i++) {
                        if (i < actual) sb.append("█");
                        else if (i > actual) sb.append("░");
                        else sb.append("◇");
                    }
                    System.out.println(sb);
                    Thread.sleep(500);
                } else {
                    boolean ultima;
                    synchronized (this) {
                        empezada = false;
                        if (progreso < 0) System.out.println("> Ha ganado el equipo 2!!");
                        if (progreso > meta) System.out.println("> Ha ganado el equipo 1!!");
                        ultima = (ronda == rondaMax);
                        if (!ultima) System.out.println("> Ronda " + ronda + " acabada, empezando la siguiente...");
                        ronda++;
                    }

                    if (ultima) {
                        System.out.println(" === FIN === ");
                        break;
                    }

                    Thread.sleep(6000); // fuera del synchronized

                    synchronized (this) {
                        System.out.println(" ====== RONDA " + ronda + " ====== ");
                        progreso = meta / 2;
                        empezada = true;
                    }
                }
            }
        } catch (InterruptedException e) {
            System.out.println("Progreso finalizado");
        }
    }
}

class Hilo implements Runnable{
    Integer equipo;
    String nombre;
    Progreso progreso;

    public Hilo(Integer equipo, String nombre, Progreso progreso) {
        this.equipo = equipo;
        this.nombre = nombre;
        this.progreso = progreso;
    }

    @Override
    public void run() {
        try {
            boolean seguir = true;
            if (equipo == 1) {
                while (seguir) {
                    Thread.sleep(new Random().nextInt(1000, 5001));
                    seguir = progreso.aumentar(nombre);
                }
            } else {
                while (seguir) {
                    Thread.sleep(new Random().nextInt(1000, 5001));
                    seguir = progreso.reducir(nombre);
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}