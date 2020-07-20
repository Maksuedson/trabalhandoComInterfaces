package InterfacesJava.src.services;

public class PaypalService implements PagamentoOnlineService {
    private static final double TAXA_JURO = 0.02;
    private static final double JURO_MENSAL = 0.01;

    @Override
    public double taxaPagamento(double montante) {
        return montante *TAXA_JURO;
    }

    @Override
    public double juros(double montante, int meses) {
        return montante * meses * JURO_MENSAL;
    }
    
}