public class UsuarioSeguroAvanzado {
    private String username;
    private String password;
    private int intentosFallidos;
    private boolean bloqueado;
    private int maxIntentos;
    private boolean accesoExitoso;

    public UsuarioSeguroAvanzado(String username, String password, int maxIntentos){
        this.username=username;
        this.password=password;

        intentosFallidos=0;
        bloqueado=false;
        accesoExitoso=false;

        if(maxIntentos <= 0)
            this.maxIntentos=3;
        else
            this.maxIntentos=maxIntentos;
    }
}
