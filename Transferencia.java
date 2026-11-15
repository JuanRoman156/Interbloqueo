public class Transferencia {

    public static boolean transferencia(Cuenta c1, Cuenta c2, int cantidad) {

        synchronized (c1) {

            System.out.println(Thread.currentThread().getName()
                    + " ha bloqueado la cuenta " + c1.getNumeroCuenta());

            try {
                // Damos tiempo para que el otro hilo bloquee la otra cuenta
                Thread.sleep(1);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }

            synchronized (c2) {

                System.out.println(Thread.currentThread().getName()
                        + " ha bloqueado la cuenta " + c2.getNumeroCuenta());

                if (c1.getSaldo() >= cantidad) {
                    c1.sacarCantidad(cantidad);
                    c2.ingresaCantidad(cantidad);

                    System.out.println(Thread.currentThread().getName()
                            + " ha transferido " + cantidad
                            + " de " + c1.getNumeroCuenta()
                            + " a " + c2.getNumeroCuenta());

                    return true;
                }
            }
        }
        return false;
    }
}
