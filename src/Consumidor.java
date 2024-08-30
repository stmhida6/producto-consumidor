
public class Consumidor implements Runnable {
    private final Cola cola;
    private final int[] cuentaDecenas;

    public Consumidor(Cola cola) {
        this.cola = cola;
        //inicializar el arreglo entero para guardar la cuenta de las decenas
        this.cuentaDecenas = new int[10];

    }

    @Override
    public void run() {
        try {
            while (true) {
                int valor = cola.sacar();
                if (valor == -1) {
                    break;  //sale del ciclo cuando la cola esta llena
                }
                int indice = (valor )/10;
                cuentaDecenas[indice]++;
                System.out.println("Consumidor procesó: " + valor);

                //System.out.println("Consumio: " + valor);
               // Thread.sleep(1000);

            } //cierra while
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}