package InterfacesJava.src.services;

public interface PagamentoOnlineService {
    double taxaPagamento(double montante);
    double juros(double montante, int meses);
}