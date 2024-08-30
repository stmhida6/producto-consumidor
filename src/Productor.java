
import java.util.Random;
public class Productor  implements Runnable {
    private final Cola cola;
    private final int cantidad;

    public Productor(Cola cola, int cantidad) {
        this.cola = cola;
        this.cantidad = cantidad;
    }

    @Override
    public void run() {
        Random random = new Random();
        System.out.println("Productor iniciado");
        try {

            for (int i = 0; i < cantidad; i++) {
                int numero = random.nextInt(100);
                cola.meter(numero);
                System.out.println("metio: " + numero);
            }
            //al terminar agregar un -1 para indicar que termino
            cola.meter(-1);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        //generar valores aleatorios

    }

}