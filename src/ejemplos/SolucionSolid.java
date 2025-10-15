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
    //5. D.- Dependency Inversion Principle (principio de inversión de dependencias)

}
