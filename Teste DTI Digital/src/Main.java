import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main{
    public static Lojas resultado = new Lojas(null, 0,0); //Inicialização de variável que será utilizado para exibição do resultado
    public static Lojas MeuCanino = new Lojas("Meu Canino Feliz", 20, 40, 20);
    public static Lojas VaiRex = new Lojas("Vai Rex", 15, 50, 20, 55);
    public static Lojas ChowChawgas = new Lojas("Chow Chawgas", 30, 45);

    public static void main(String[] args) {
        new GUI();
    }

    /**
     * Método para realizar calculo de quantos reais será gasto em cada PetShop definido, retornando o petshop mais barato, ou mais próximo em caso de empate de preço.
     *
     * @param diaSemana - Data definida por usuário
     * @param cachorrosP - Quantidade de cachorros pequenos
     * @param cachorrosG - Quantidade de cachorros grandes
     * @param MeuCanino - Variável do PetShop
     * @param VaiRex - Variável do PetShop
     * @param ChowChawgas - Variável do PetShop
     * @param resultado - Variável que carregará o petshop escolhido
     * @return - Petshop com menor gasto ou menor distância
     */
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
