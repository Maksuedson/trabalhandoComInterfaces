package InterfacesJava.src.services;

import java.util.Calendar;
import java.util.Date;

import InterfacesJava.src.entidades.Contrato;
import InterfacesJava.src.entidades.Parcelas;

public class ContratoService {

    private PagamentoOnlineService pagamentoOnlineService;


    public ContratoService(PagamentoOnlineService pagamentoOnlineService) {
        this.pagamentoOnlineService = pagamentoOnlineService;
    }

    public void processarContrato(Contrato contrato, int meses){
        double parcelaBasica =contrato.getValorTotal() / meses;
        //parcelaBasica = 200
        for (int i =1; i<=meses; i++){
            double parcelaAtualizada = parcelaBasica + pagamentoOnlineService.juros(parcelaBasica, i);
            //taxaAtualizada = 202;
            double parcelaCompleta = parcelaAtualizada + pagamentoOnlineService.taxaPagamento(parcelaAtualizada);
            //taxaCompleta = 206.04
            Date vencimento = adicionarMeses(contrato.getData(), i);
            contrato.getParcelas().add(new Parcelas(vencimento, parcelaCompleta));
        }

    }

    private Date adicionarMeses(Date data, int N){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(data);
        calendar.add(Calendar.MONTH, N);
        return calendar.getTime();

    }


}