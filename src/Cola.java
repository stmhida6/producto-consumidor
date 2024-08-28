import java.util.LinkedList;
import java.util.Queue;

public class Cola {
    private final Queue<Integer> cola = new LinkedList<>();
    private final int capacidad;

    public Cola(int capacidad) {
        this.capacidad = capacidad;
    }

    public   synchronized void meter(int valor)    throws InterruptedException {
        while (cola.size() == capacidad) {
            System.out.println("Cola llena, ");
            //esperar a que se saque un elemento
            wait();


        }
        cola.add(valor);

    }

    public  int sacar()   {

        int valor = cola.poll();

        return valor;
    }

}
