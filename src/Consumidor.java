public class Consumidor {
    private final Cola cola;
    public Consumidor(Cola cola) {
        this.cola = cola;

    }

    public void consumir() {
        try {
            while (true) {
                int valor = cola.sacar();
                System.out.println("Consumio: " + valor);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}