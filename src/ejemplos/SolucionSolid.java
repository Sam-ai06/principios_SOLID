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

}
