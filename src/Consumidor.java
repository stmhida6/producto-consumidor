
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
                int indice = (valor -1)/10;
                cuentaDecenas[indice]++;
                System.out.println("consumidor procesó: " + valor);

                //System.out.println("Consumio: " + valor);
               // Thread.sleep(1000);

            } //cierra while
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }

        int total = 0;
        // Imprime los resultados
        for (int i = 0; i < cuentaDecenas.length; i++) {
            System.out.println("valores entre " + (i * 10 + 1) + " y " + ((i + 1) * 10) + ": " + cuentaDecenas[i]);
            total += cuentaDecenas[i];
        }
        System.out.println("total de numeros procesados: " + total);
// Verifica si se generaron y procesaron exactamente 1000 números
        if (total == 1000) {
            System.out.println("se generaron  1000 números.");
        } else {
            System.out.println("¡Error!");
        }
    }
}