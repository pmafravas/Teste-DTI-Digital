import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GUI extends JFrame {
    //Declarações de váriavéis da GUI
    private JPanel PainelGUI; //Painel principal
    private JButton procurarPetShopButton; //Botão de busca
    private JSpinner spinnerCachorroG; //Botão de quantidade de cachorros pequenos
    private JSpinner spinnerCachorroP; //Botão ed quantidade de cachorros grandes
    private JTextField dataTextField; // Caixa de texto par data
    private JLabel resultado; //Label com resultado
    private JLabel ErrorLabel; //Label para aviso de erro

    //Declarações de variáveis para uso do código
    public int cachorrosP; //Quantidade de cachorros pequenos
    public int cachorrosG; //Quantidade de cachorros grandes

    public GUI() {
        //Configurações básicacas da GUI
        setContentPane(PainelGUI);
        setTitle("Teste DTI Digital");
        setSize(320, 380);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //Comando de ação ao clicar o botão
        procurarPetShopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Recolhe todos os dados informados pelo usuário
                String data = dataTextField.getText();
                cachorrosP = (Integer) spinnerCachorroP.getValue();
                cachorrosG = (Integer) spinnerCachorroG.getValue();

                //Cria o formatador de data
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                //Tenta realizar o código
                try{
                    //Transformando data para dia da semana
                    LocalDate dataMarcada = LocalDate.parse(data, formatador);
                    DayOfWeek diaSemana = dataMarcada.getDayOfWeek();

                    //Envia dados para cálculo
                    Main.resultado = Main.calculaValor(diaSemana, cachorrosP, cachorrosG, Main.MeuCanino, Main.VaiRex, Main.ChowChawgas, Main.resultado);

                    //Exibe resultados na GUI
                    resultado.setText(Main.resultado.nome);
                    resultado.setOpaque(true);
                    resultado.setBackground(Color.WHITE);
                    ErrorLabel.setText("");
                    ErrorLabel.setOpaque(false);
                }
                catch (DateTimeException error){
                    //Realiza a comunicação do erro cometido pelo usuário
                    ErrorLabel.setText("Data incorreta! Coloque dd/MM/aaaa");
                    ErrorLabel.setOpaque(true);
                    ErrorLabel.setForeground(Color.RED);
                    resultado.setText("");
                    resultado.setOpaque(false);
                    error.printStackTrace();
                }
            }
        });
    }
}
