package br.pucpr;

public class DeadlockResolvido {

    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> acquireInOrder("T1"));
        Thread t2 = new Thread(() -> acquireInOrder("T2"));

        t1.start();
        t2.start();
    }

    // ambas vao usar a mesma ordem a => b
    static void acquireInOrder(String nomeThread) {
        System.out.println(nomeThread + ": tentando adquirir LOCK_A");
        synchronized (LOCK_A) {
            System.out.println(nomeThread + ": adquiriu LOCK_A");
            dormir(50);

            System.out.println(nomeThread + ": tentando adquirir LOCK_B");
            synchronized (LOCK_B) {
                System.out.println(nomeThread + ": adquiriu LOCK_B");
                System.out.println(nomeThread + ": concluiu execução");
            }
        }
    }

    static void dormir(long ms) {
        try { Thread.sleep(ms); } catch (InterruptedException e) {}
    }
}
// sempre adquirir LOCK_A antes de LOCK_B
// isso elimina a condição de espera circular