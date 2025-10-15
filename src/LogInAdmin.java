public class LogInAdmin extends LogIn {
    private boolean userIsAdmin;
    
    @Override
    public void log (User user) {
        this.userIsAdmin = verifyIfTheUserIsAdmin(user); // Se llama al método verifyIfTheUserIsAdmin 
        if (userIsAdmin) {    // Si es admin, llama al método de LogIn, no a un método propio
            super.log(user);  // Llama a la implementación de log() de LogIn para que no cambie la lógica
            System.out.println("Has access to the website in admin mode");
        } else {
            System.out.println("Access denied: Admin privileges required");
        }
    }
    // Ahora el código funcionaría de forma consistente.
    private boolean verifyIfTheUserIsAdmin(User user){
        return user.getNickname().equals("admin");
    }
}

// Tercera violación: LSP
// La clase LogInAdmin sobreescribe log(), pero este no siempre funciona como un Login porque puede tener un comportamiento inesperado,
// ya que LogIn siempre realiza una acción al llamar al método que es insertar, pero si este no es admin, no retorna nada, causando
// inconsistencia.

// Solución Tercera violación: LSP
// Cambiamos la lógica del método log para que valide primero si es admin y en base a eso decida si hacer el log o no.
// Implementa el métood verifyIfTheUserIsAdmin dentro del log para esto

