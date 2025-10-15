
import java.util.ArrayList;

public class violacionSolid {
    /*
     * principios SOLID
     * parte de código de ejemplo elaborado por samuel villagomez, mathias giller
     * niurka roca y paola reyes.
     * En esta clase se elaborarán un ejemplo de violación de cada principio SOLID.
     * En la clase SolucionSolidSamuel se elaborarán las soluciones a cada
     * violación.
     */

    // *1. S.- Single responsibility principle (principio de responsabilidad única)
<<<<<<< Updated upstream
    public class coche {
=======
    class coche {
        MotorGasolina motor; // violación de DIP
>>>>>>> Stashed changes
        String placa;
        String modelo;
        double precio;
        double kilometraje;

        // constructor
        public coche(double kilometraje, String modelo, String placa, double precio) {
            this.kilometraje = kilometraje;
            this.modelo = modelo;
            this.placa = placa;
            this.precio = precio;
        }

        // métodos
        public void manejar() {
            System.out.println("el carro está avanzando.");
        }

        public void frenar() {
            System.out.println("el carro está frenando.");
        }

        // violación del SRP
        public double calcularImpuesto() {
            return this.precio * 0.12;
        }
        /*
         * este principio se viola porque la clase coche tiene dos responsabilidades:
         * 1. representar un coche con sus atributos y métodos.
         * 2. calcular el impuesto del coche.
         */

    }

    // 2. O.- Open-Closed principle (principio de abierto-cerrado)
    public static void main(String[] args) {
        
        ArrayList<coche> carros = new ArrayList<>();
        carros.add(new violacionSolid().new coche(15000, "Toyota", "ABC123", 20000));
        carros.add(new violacionSolid().new coche(30000, "Honda", "DEF456", 25000));
        carros.add(new violacionSolid().new coche(5000, "Ford", "GHI789", 30000));
    }
     //método que viola el principio OCP
        public static void imprimirCarros(ArrayList<coche> carros) {
            for (coche c : carros) {
                System.out.println("Modelo: " + c.modelo + ", Placa: " + c.placa + ", Precio: " + c.precio
                        + ", Kilometraje: " + c.kilometraje);
            }
        }

        /*
         * este principio se viola porque al querer imprimir otro tipo de vehículo, el método tendra que ser 
         * cambiado una y otra vez, en lugar de extenderse para soportar nuevos tipos de vehículos.
         */

    // 3. L.- Liskov Substitution Principle (principio de sustitución de Liskov)
    class CocheDeLujo extends Coche {
    boolean tieneConductorPersonal;

    public CocheDeLujo(String placa, String modelo, double precio, boolean tieneConductorPersonal) {
        super(placa, modelo, precio);
        this.tieneConductorPersonal = tieneConductorPersonal;
    }

    // Sobreescribimos el método para calcular el impuesto, lo que cambia la lógica
    @Override
    public double calcularImpuesto() {
        if (this.tieneConductorPersonal) { // Cambiamos el cálculo de impuesto si tiene conductor personal
            return super.calcularImpuesto() + 1000;  // Añadimos un impuesto extra si tiene conductor
        }
        return super.calcularImpuesto();
    }
    }
    // Este principio se viola debido a que CocheDeLujo cambia la lógica totalmente
    // del método calcularImpuesto, lo que hace que el comportamiento de CocheDeLujo no
    // sea sustituible por el de un Coche, ya que el método calcularImpuesto funciona diferente
    // dependiendo del tipo de coche 
}





    //4. I.- Interface Segregation Principle (principio de segregación de interfaces)
    
    
    // interfaz con métodos no aplicables a todos los vehículos
    interface Vehiculo {
        void conducir();
        void detener();
        void cargarCombustible();
        void cargarCarga();  // violación del ISP: método irrelevante para algunos vehículos
    }

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

        @Override
        public void cargarCarga() {
            throw new UnsupportedOperationException("Un coche no carga carga.");
        }
    }

    class Camion implements Vehiculo {
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

    //viola el principio de ISP porque la interfaz vehiculo tiene metodos que no son relevantes para todas las clases
    //y se ven forzadas a implementarlas de todas formas.

    //5. D.- Dependency Inversion Principle (principio de inversión de dependencias)
    
    class MotorGasolina {
        public void encender() {
            System.out.println("Motor de gasolina encendido.");
        }
        /*
         * este principio se viola porque la clase coche depende de una clase concreta(MotorGasolina), lo que impide cambiar fácilmente a otro tipo de motor.
         */
    }


}
