package org.example;

public class Registro {
    String fecha;
    String nombre;
    String provincia;
    Float tmin;
    String horatmin;
    Float tmax;
    String horatmax;

    // Saco el año y més para poder agrupar por estos
    String mesYAno;

    public void calcularFecha(){
        mesYAno = fecha.substring(0, 5).concat(fecha.substring(5, 7));
    }

    public Registro(String fecha, String nombre, String provincia, Float tmin, String horatmin, Float tmax, String horatmax) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.provincia = provincia;
        this.tmin = tmin;
        this.horatmin = horatmin;
        this.tmax = tmax;
        this.horatmax = horatmax;
        calcularFecha();
    }

    public Registro() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public Float getTmin() {
        return tmin;
    }

    public void setTmin(Float tmin) {
        this.tmin = tmin;
    }

    public String getHoratmin() {
        return horatmin;
    }

    public void setHoratmin(String horatmin) {
        this.horatmin = horatmin;
    }

    public Float getTmax() {
        return tmax;
    }

    public void setTmax(Float tmax) {
        this.tmax = tmax;
    }

    public String getHoratmax() {
        return horatmax;
    }

    public void setHoratmax(String horatmax) {
        this.horatmax = horatmax;
    }

    public String getMesYAno() {
        return mesYAno;
    }

    public void setMesYAno(String mesYAno) {
        this.mesYAno = mesYAno;
    }

    @Override
    public String toString() {
        return "Fecha - " + fecha +
                " | Localidad - " + nombre +
                " | Provincia - " + provincia +
                " | Temperatura maxima - " + tmax +
                " | Temperatura minima - " + tmin +
                " | horatmin - " + horatmin +
                " | horatmax - " + horatmax +
                " | mesYAno - " + mesYAno;
    }
}
