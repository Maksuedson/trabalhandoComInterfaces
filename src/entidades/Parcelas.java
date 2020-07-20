package InterfacesJava.src.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Parcelas {
    private Date vencimento;
    private Double montante;

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Parcelas(){        
    }

    public Parcelas(Date vencimento, Double montante) {
        this.vencimento = vencimento;
        this.montante = montante;
    }

    public Date getVencimento() {
        return this.vencimento;
    }

    public void setVencimento(Date vencimento) {
        this.vencimento = vencimento;
    }

    public Double getMontante() {
        return this.montante;
    }

    public void setMontante(Double montante) {
        this.montante = montante;
    }

    @Override
    public String toString() {
        return sdf.format(vencimento) + " - "+ String.format("%.2f", montante);
        
    }

}