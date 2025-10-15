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

@SuppressWarnings("unused")
class calculadoraImpuesto{
        public double calcularImpuesto(coche c){
            return c.precio * 0.12;
        }
    }
    //3. L.- Liskov Substitution Principle (principio de sustitución de Liskov)
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
