package CITSIM21_02.ModeloControlador;//

public class Foto {
    private String titulo;

    public Foto()
    {
        this.titulo="vacio";
    }

    public Foto(String titulo)
    {
        this.titulo=titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
