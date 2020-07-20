package InterfacesJava.src.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import InterfacesJava.src.entidades.Contrato;
import InterfacesJava.src.entidades.Parcelas;
import InterfacesJava.src.services.ContratoService;
import InterfacesJava.src.services.PaypalService;

public class Programa {
    public static void main(String[] args) throws ParseException {
       // PagamentoOnlineService po = new PaypalService();
       

        Locale.setDefault(Locale.US);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("Entre com a data do contrato: ");
        System.out.print("Número: ");
        Integer numero = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date data = sdf.parse(sc.next());
        System.out.print("Valor do contrato: ");
        Double valorTotal = sc.nextDouble();
        System.out.print("Entre com o número de parcelas: ");
        Integer qtdMeses = sc.nextInt();

        Contrato contrato = new Contrato(numero, data, valorTotal);
        ContratoService cs = new ContratoService(new PaypalService()); //Injeção de depenência
       // ContratoService cs = new ContratoService(po);
        cs.processarContrato(contrato, qtdMeses);

        System.out.println("Parcelas: ");
        for (Parcelas pc : contrato.getParcelas()){
            System.out.println(pc);
        }



        sc.close();

    }
}