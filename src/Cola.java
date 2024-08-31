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
        //avisaa que puede sacfar un elemento
        notifyAll();

    }

    public  synchronized  int sacar()   throws InterruptedException {
while (cola.isEmpty()) {
    //sila cola esta vacia esperar a que se meta un elemento
    // o no hay nada que sacar


    wait();
}
        int valor = cola.poll();
        //avisar que se puede meter un elemento
    notifyAll();
        return valor;
    }

}
