public class Main {
    public static void main(String[] args) {
        Cola cola = new Cola(10); // tamaño de la cola

       /* cola.meter(1);
        cola.meter(2);
        cola.meter(3);

        System.out.println(cola.sacar());
        System.out.println(cola.sacar());
        System.out.println(cola.sacar());

        for(int i = 0; i < 100; i++) {
            cola.meter(i);
        }
        for(int i = 0; i < 100; i++) {
            System.out.println(cola.sacar());
        }*/

        Productor productor = new Productor(cola, 10);
        try {
            Thread hiloProductor = new Thread(productor);
            hiloProductor.start();
            hiloProductor.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }








    }
}