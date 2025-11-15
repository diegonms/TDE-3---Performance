import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class SemSemaforo {
    static int contador = 0;
    public static void main(String[] args) throws InterruptedException {
        int threads = 8;
        int incrementos = 100000;

        ExecutorService pool = Executors.newFixedThreadPool(threads);

        Runnable r = () -> {
            for (int i = 0; i < incrementos; i++) {
                contador++;
            }
        };

        long tempoInicial = System.currentTimeMillis();
        for (int i = 0; i < threads; i++) {
            pool.submit(r);
        };
        pool.shutdown();
        pool.awaitTermination(1, TimeUnit.MINUTES);

        long tempoFinal = System.currentTimeMillis();
        System.out.println("\nTotal threads: " + threads);
        System.out.println("\nTotal incrementos: " + incrementos);
        System.out.println("\n\n-----------------------------------");
        System.out.println("\nEsperado: " + threads * incrementos);
        System.out.println("\nObtido: " + contador);
        long tempoTotal = tempoFinal - tempoInicial;
        System.out.println("\nTempo total: " + tempoTotal + "ms");

    }
}