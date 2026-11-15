public class Cuenta {

    private String numeroCuenta;
    private double saldo;

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public synchronized void ingresaCantidad(double cantidad) {
        saldo += cantidad;
    }

    public synchronized void sacarCantidad(double cantidad) {
        if (saldo >= cantidad) {
            saldo -= cantidad;
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    @Override
    public String toString() {
        return "Cuenta: " + numeroCuenta
                + " | Saldo: " + getSaldo();
    }
}
