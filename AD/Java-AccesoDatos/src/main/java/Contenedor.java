public class Contenedor<T> {

    private T objeto;

    public T getObjeto() {
        return objeto;
    }

    public void setObjeto(T objeto) {
        this.objeto = objeto;
    }

    public Contenedor(T objeto) {
        this.objeto = objeto;
    }
}
