import java.util.ArrayList;

public class SolucionSolid {

    /*
     * principios SOLID
     * parte de código de ejemplo elaborado por samuel villagomez y mathias giller
     * niurka roca y paola reyes harán diagramas
     * solución de los principios violados SOLID
     * */

    //1.- S: Single responsibility principle (principio de responsabilidad única)

    class coche{
        String placa;
        String modelo;
        double precio;
        double kilometraje;

        //constructor
        public coche(double kilometraje, String modelo, String placa, double precio) {
            this.kilometraje = kilometraje;
            this.modelo = modelo;
            this.placa = placa;
            this.precio = precio;
        }
        //métodos
        public void manejar(){
            System.out.println("el carro está avanzando.");
        }
        public void frenar(){
            System.out.println("el carro está frenando.");
        }
        /*aquí se elimina el método que calcula el impuesto a una clase separada. manteniendo funciones
        relacionadas con el coche en esta clase**/
    }

    // 2. O: Open-Closed Principle (Principio Abierto-Cerrado)
@SuppressWarnings("unused")
class calculadoraImpuesto{
        public double calcularImpuesto(coche c){
            return c.precio * 0.12;
        }
    }
    //solución:
    abstract class carro{
        String placa;
        String modelo;
        double precio;
        double kilometraje;
    }
    class renault extends carro{
        public void encenderAireAcondicionado(){
            System.out.println("Aire acondicionado encendido.");
        }
    }

    class ferrari extends carro{
        public void activarNitro(){
            System.out.println("Nitro activado.");
        }
    }

    class chevrolet extends carro{
        public void abrirCajuela(){
            System.out.println("Cajuela abierta.");
        }
    }
    /*
     * más clases aquí
     */
    public static void main(String[] args) {
        ArrayList<carro> carros = new ArrayList<>();
        carros.add(new SolucionSolid().new renault());
        carros.add(new SolucionSolid().new ferrari());
        carros.add(new SolucionSolid().new chevrolet());
    }

    public static void imprimirCarros(ArrayList<carro> carros) {
        for (carro c : carros) {
            System.out.println("Modelo: " + c.modelo + ", Placa: " + c.placa + ", Precio: " + c.precio
                    + ", Kilometraje: " + c.kilometraje);
        }
        /*
         * este método ahora puede aceptar cualquier tipo de carro sin necesidad de ser modificado.
         */

    

    }

    //3. L.- Liskov Substitution Principle (principio de sustitución de Liskov)

    class CocheDeLujo extends Coche {
    boolean tieneConductorPersonal;

    public CocheDeLujo(String placa, String modelo, double precio, boolean tieneConductorPersonal) {
        super(placa, modelo, precio);
        this.tieneConductorPersonal = tieneConductorPersonal;
    }

    // Método adicional para obtener información sobre el conductor personal, sin cambiar el cálculo de impuestos
    public boolean tieneConductorPersonal() {
        return tieneConductorPersonal;
    }

    // Opcionalmente, podemos agregar más comportamientos sin alterar los heredados
    public double obtenerPrecioConConductor() {
        // Podemos agregar un precio extra si tiene conductor, pero sin alterar el cálculo del impuesto
        return this.precio + (this.tieneConductorPersonal ? 5000 : 0);
    }


    }

    // Se soluciona de esta manera ya que, ahora es consistente y no modifica directamente el método calcularImpuesto
    // y sigue la lógica de la clase Coche, además si necesita otro comportamiento se puede agregar sin problemas otro método
    // sin alterar la lógica del método calcularImpuesto, de esta manera CocheDeLujo puede ser usado también como Coche sin
    // ningún problema

    //4. I.- Interface Segregation Principle (principio de segregación de interfaces)
    // aplicamos una interfaz base para todos los vehículos
    interface Vehiculo {
        void conducir();
        void detener();
        void cargarCombustible();
    }

    // interfaz para vehículos que pueden cargar carga
    interface VehiculoConCarga {
        void cargarCarga();
    }

    // clase Coche implementando solo lo que le corresponde
    class Coche implements Vehiculo {
        @Override
        public void conducir() {
            System.out.println("El coche está conduciendo.");
        }

        @Override
        public void detener() {
            System.out.println("El coche se está deteniendo.");
        }

        @Override
        public void cargarCombustible() {
            System.out.println("El coche está cargando combustible.");
        }
    }

    // clase Camión implementando tanto Vehiculo como VehiculoConCarga
    class Camion implements Vehiculo, VehiculoConCarga {
        @Override
        public void conducir() {
            System.out.println("El camión está conduciendo.");
        }

        @Override
        public void detener() {
            System.out.println("El camión se está deteniendo.");
        }

        @Override
        public void cargarCombustible() {
            System.out.println("El camión está cargando combustible.");
        }

        @Override
        public void cargarCarga() {
            System.out.println("El camión está cargando carga.");
        }
    }
        /*
         * con esta modificacion, cada clase implementa solo lo que le corresponde sin tener que ser forzada 
         * a implementar métodos innecesarios
         */

    //5. D.- Dependency Inversion Principle (principio de inversión de dependencias)
}
