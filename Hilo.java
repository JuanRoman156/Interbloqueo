public class Hilo implements Runnable {

    private String nombre;
    private Cuenta c1;
    private Cuenta c2;

    public Hilo(String nombre, Cuenta c1, Cuenta c2) {
        this.nombre = nombre;
        this.c1 = c1;
        this.c2 = c2;
    }

    @Override
    public void run() {

        Thread.currentThread().setName(nombre);

        System.out.println("Comienza el hilo: "
                + Thread.currentThread().getName());

        for (int i = 0; i < 1000; i++) {

            Transferencia.transferencia(c1, c2, 10);
        }

        System.out.println("Finaliza el hilo: "
                + Thread.currentThread().getName());
    }
}
