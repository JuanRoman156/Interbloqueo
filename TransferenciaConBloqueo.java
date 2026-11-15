public class TransferenciaConBloqueo {

    public static void main(String[] args) {

        Cuenta c1 = new Cuenta("ES388388433883838388484", 20500);
        Cuenta c2 = new Cuenta("ES99090499388484889399", 50000);

        System.out.println(c1);
        System.out.println(c2);

        // Hilo 1: transfiere de c1 a c2
        Thread h1 = new Thread(
                new Hilo("Juan Román Castillo Gonzalez", c1, c2)
        );

        // Hilo 2: transfiere de c2 a c1
        Thread h2 = new Thread(
                new Hilo("Castillo Gonzalez Juan Roman", c2, c1)
        );

        h1.start();
        h2.start();

        try {

            // Damos tiempo a que los hilos bloqueen las cuentas
            Thread.sleep(100);

            // Mostramos información de los hilos
            System.out.println("ESTADO DE LOS HILOS");
            System.out.println(h1.getName() + ": " + h1.getState());
            System.out.println(h2.getName() + ": " + h2.getState());

            h1.join();
            h2.join();

        } catch (InterruptedException e) {
            System.out.println("El hilo principal ha sido interrumpido.");
            Thread.currentThread().interrupt();
        }

        // Mostramos los saldos finales aunque estos jamás se ejecutaran ya que los hilos están bloqueados
        System.out.println("SALDOS FINALES");
        System.out.println(c1);
        System.out.println(c2);

        System.out.println("Fin del programa.");
    }
}
