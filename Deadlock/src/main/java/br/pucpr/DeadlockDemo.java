package br.pucpr;

public class DeadlockDemo {
    static final Object LOCK_A = new Object();
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("T1: tenta pegar LOCK_A");
            synchronized (LOCK_A) {
                System.out.println("T1: pegou LOCK_A");
                dormir(100);

                System.out.println("T1: tentou pegar LOCK_B");
                synchronized (LOCK_B) {
                    System.out.println("T1 concluiu");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            System.out.println("T2: tenta pegar LOCK_B");
            synchronized (LOCK_B) {
                System.out.println("T2: pegou LOCK_B");
                dormir(100);

                System.out.println("T2: tentou pegar LOCK_A");
                synchronized (LOCK_A) {
                    System.out.println("T2 concluiu");
                }
            }
        });

        t1.start();
        t2.start();
    }

    // sleep para o codigo não rodar instantanemente
    // impede que o T1 pegue os dois locks antes do T2 acordar
    static void dormir(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
