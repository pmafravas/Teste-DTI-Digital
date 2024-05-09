/**
 * Classe Lojas - classe utilizada para as criações dos petshops
 */
public class Lojas {

    String nome;
    int precoP; //Preço para cachorros pequenos
    int precoG; //Preço oara cachorros grandes
    double precoPA; //PrecoP Alternativo
    double precoGA; //PrecoG Alternativo

    /**
     * Construtor para uma loja sem alteração de preço aos finais de semana.
     * Atribui valor automaticamante para cada parametro da loja.
     * @param nome - Nome do PetShop
     * @param precoP - Preço para cachorros pequenos
     * @param precoG - Preço para cachorros grandes
     */
    Lojas(String nome, int precoP, int precoG){
        this.nome = nome;

        //Definindo preço padrão
        this.precoP = precoP;
        this.precoG = precoG;
    }

    /**
     * Construtor para uma loja com variações de preços aos finais de semana.
     * Recebe um valor incrementado já fixo
     * @param nome - Nome do PetShop
     * @param precoP - Preço para cachorros pequenos
     * @param precoG - Preço para cachorros grandes
     * @param precoPA - Preço alternativo para finais de semana para cachorros pequenos
     * @param precoGA - Preço alternativo para finais de semana para cachorros pequenos
     */
    Lojas(String nome, int precoP, int precoG, float precoPA, float precoGA){
        this.nome = nome;

        //Definindo preço padrão
        this.precoP = precoP;
        this.precoG = precoG;

        //Definindo preço alternativo
        this.precoPA = precoPA;
        this.precoGA = precoGA;
    }

    /**
     * Construtor para uma loja com variações de preços aos finais de semana.
     * Recebe um int que representa um número em % para realizar a conta e fazer o aumento do preço
     * @param nome - Nome do PetShop
     * @param precoP - Preço para cachorros pequenos
     * @param precoG - Preço para cachorros grandes
     * @param aumento - int que representa um valor em % para o aumento dos preços alternativos
     */
    Lojas(String nome, int precoP, int precoG, double aumento){
        this.nome = nome;
        this.precoP = precoP;
        this.precoG = precoG;

        //REalizando calculo de aumento de preço
        double incremento = (aumento/100) + 1; //Transfomando o valor de int em um número que representa seu aumento para calculo do valor final
        this.precoPA = precoP * incremento;
        this.precoGA = precoG * incremento;
    }


}