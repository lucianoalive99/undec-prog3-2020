package clases;

import java.time.LocalDateTime;

public class Vuelo {
    private String CodigoVuelo;
    private LocalDateTime Salida;
    private LocalDateTime Arribo;
    private Aeropuerto AeropuertoSalida;
    private Aeropuerto AeropuertoArribo;
    private Avion Avion;
    private Piloto Comandante;
    private Piloto Copiloto;
    private Aerolinea Aerolinea;

    //Getter y Setter

    public String getCodigoVuelo() {
        return CodigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        CodigoVuelo = codigoVuelo;
    }

    public LocalDateTime getSalida() {
        return Salida;
    }

    public void setSalida(LocalDateTime salida) {
        Salida = salida;
    }

    public LocalDateTime getArribo() {
        return Arribo;
    }

    public void setArribo(LocalDateTime arribo) {
        Arribo = arribo;
    }

    public Aeropuerto getAeropuertoSalida() {
        return AeropuertoSalida;
    }

    public void setAeropuertoSalida(Aeropuerto aeropuertoSalida) {
        AeropuertoSalida = aeropuertoSalida;
    }

    public Aeropuerto getAeropuertoArribo() {
        return AeropuertoArribo;
    }

    public void setAeropuertoArribo(Aeropuerto aeropuertoArribo) {
        AeropuertoArribo = aeropuertoArribo;
    }

    public clases.Avion getAvion() {
        return Avion;
    }

    public void setAvion(clases.Avion avion) {
        Avion = avion;
    }

    public Piloto getComandante() {
        return Comandante;
    }

    public void setComandante(Piloto comandante) {
        Comandante = comandante;
    }

    public Piloto getCopiloto() {
        return Copiloto;
    }

    public void setCopiloto(Piloto copiloto) {
        Copiloto = copiloto;
    }

    public clases.Aerolinea getAerolinea() {
        return Aerolinea;
    }

    public void setAerolinea(clases.Aerolinea aerolinea) {
        Aerolinea = aerolinea;
    }



    public Vuelo(String pCodigoVuelo, LocalDateTime pSalida, LocalDateTime pArribo,
                 Aeropuerto pAeropuertoSalida, Aeropuerto pAeropuertoLlegada,
                 Avion pAvion, Piloto pComandante, Piloto pCopiloto, Aerolinea pAeroliena) {

        this.CodigoVuelo = pCodigoVuelo;
        this.Salida = pSalida;
        this.Arribo = pArribo;
        this.AeropuertoSalida = pAeropuertoSalida;
        this.AeropuertoArribo = pAeropuertoLlegada;
        this.Avion = pAvion;
        this.Comandante = pComandante;
        this.Copiloto = pCopiloto;
        this.Aerolinea = pAeroliena;
    }


}
