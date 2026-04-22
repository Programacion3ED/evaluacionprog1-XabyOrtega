public class UsuarioSeguroAvanzado {
    private String username;
    private String password;
    private int intentosFallidos;
    private boolean bloqueado;
    private int maxIntentos;
    private boolean accesoExitoso;

    //Constructor
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

    //Metodos
    public String getUsername(){
        return username;
    }
    public int getIntentosFallidos(){
        return intentosFallidos;
    }
    public boolean isBloqueado() {
        return bloqueado;
    }

    public int getMaxIntentos() {
        return maxIntentos;
    }

    public boolean isAccesoExitoso() {
        return accesoExitoso;
    }

    public boolean autenticar(String passwordIngresada)
    {
        if(bloqueado)
            return false;

        if(password.equals(passwordIngresada))
        {
            intentosFallidos = 0;
            accesoExitoso = true;
            return true;
        }

        intentosFallidos++;

        if(intentosFallidos >= maxIntentos)
            bloqueado = true;

        return false;
    }

    public void reiniciarAcceso()
    {
        intentosFallidos = 0;
        bloqueado = false;
    }

    private boolean validarpasswordSegura(String nueva)
    {
        if(nueva.length() < 8)
            return false;

        boolean mayuscula = false;
        boolean numero = false;

        for(int i = 0; i< nueva.length(); i++)
        {
            char c = nueva.charAt(i);

            if(Character.isUpperCase(c))
                mayuscula = true;

            if(Character.isDigit(c))
                numero = true;
        }

        return mayuscula && numero;
    }

    public boolean cambiarPassword(String actual,
                                   String nueva)
    {
        if(bloqueado)
            return false;

        if(!password.equals(actual))
            return false;

        if(!validarpasswordSegura(nueva))
            return false;

        password = nueva;

        return true;
    }
}
