import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lojas MeuCanino = new Lojas("Meu Canino Feliz", 20, 40, 20);
        Lojas VaiRex = new Lojas("Vai Rex", 15, 50, 20, 55);
        Lojas ChowChawgas = new Lojas("Chow Chawgas", 30, 45);
        Lojas resultado = new Lojas(null, 0,0); //Inicialização de variável que será utilizado para exibição do resultado


        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        //Inputs manuais - teste de backend (apenas temporário, será removido assim que o frontend for implementado)
        System.out.print("Insira a data desejada no formato YYYY-MM-DD: ");
        String data = scanner.nextLine();

        //Transformando data para dia da semana
        LocalDate dataMarcada = LocalDate.parse(data, formatador);
        DayOfWeek diaSemana = dataMarcada.getDayOfWeek();

        System.out.print("Digite quantos cachorros pequenos serão levados: ");
        int cachorrosP = scanner.nextInt();

        System.out.print("Digite quantos cachorros grandes serão levados: ");
        int cachorrosG = scanner.nextInt();

        resultado = calculaValor(diaSemana, cachorrosP, cachorrosG, MeuCanino, VaiRex, ChowChawgas, resultado);
        System.out.println("Resultado: " + resultado.nome);

    }

    public static Lojas calculaValor(DayOfWeek diaSemana, int cachorrosP, int cachorrosG, Lojas MeuCanino, Lojas VaiRex, Lojas ChowChawgas, Lojas resultado){
        double valorMeuCanino;
        double valorVaiRex;
        double valorChowChawgas;

        //Calculo de valor para finais de semana
        if(diaSemana == DayOfWeek.SATURDAY || diaSemana == DayOfWeek.SUNDAY){
            //Calculo Meu Canino
            valorMeuCanino = (cachorrosP * MeuCanino.precoPA) + (cachorrosG * MeuCanino.precoGA);

            //Calculo Vai Rex
            valorVaiRex = (cachorrosP * VaiRex.precoPA) + (cachorrosG * VaiRex.precoGA);
        }

        //Calculo de valor para dias úteis
        else{
            //Calculo Meu Canino
            valorMeuCanino = (cachorrosP * MeuCanino.precoP) + (cachorrosG * MeuCanino.precoG);

            //Calculo Vai Rex
            valorVaiRex = (cachorrosP * VaiRex.precoP) + (cachorrosG * VaiRex.precoG);
        }

        //Calculo Chow Chawgas
        valorChowChawgas = (cachorrosP * ChowChawgas.precoP) + (cachorrosG * ChowChawgas.precoG);

        //Fazendo comparações sobre qual valor é o menor
        if(valorChowChawgas < valorMeuCanino && valorChowChawgas < valorVaiRex){
            resultado = ChowChawgas;
        } else if (valorMeuCanino < valorChowChawgas && valorMeuCanino < valorVaiRex) {
            resultado = MeuCanino;
        } else if (valorVaiRex < valorChowChawgas && valorVaiRex < valorMeuCanino) {
            resultado = VaiRex;
        }

        //Há pelo menos dois valores iguais e deve ser buscado o petshop mais próximo
        else{
            if(valorChowChawgas == valorMeuCanino || valorChowChawgas == valorVaiRex){ //Como ChowChawgas é o PetShop mais próximo, o resultado sempre será ele em caso de empate
                resultado = ChowChawgas;
            } else if (valorVaiRex == valorMeuCanino) { //Dentre as opções restantes, o usuário fica com o Vai Rex e Meu Canino
                resultado = VaiRex;
            }
        }

        return resultado;
    }
}
