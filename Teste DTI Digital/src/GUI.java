import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GUI extends JFrame {
    private JPanel PainelGUI;
    private JButton procurarPetShopButton;
    private JSpinner spinnerCachorroG;
    private JSpinner spinnerCachorroP;
    private JTextField dataTextField;
    private JLabel resultado;
    private JLabel ErrorLabel;
    public int cachorrosP;
    public int cachorrosG;

    public GUI() {
        setContentPane(PainelGUI);
        setTitle("Teste DTI Digital");
        setSize(320, 380);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        procurarPetShopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String data = dataTextField.getText();
                cachorrosP = (Integer) spinnerCachorroP.getValue();
                cachorrosG = (Integer) spinnerCachorroG.getValue();

                System.out.println(cachorrosG);
                DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

                try{
                    //Transformando data para dia da semana
                    LocalDate dataMarcada = LocalDate.parse(data, formatador);
                    DayOfWeek diaSemana = dataMarcada.getDayOfWeek();
                    Main.resultado = Main.calculaValor(diaSemana, cachorrosP, cachorrosG, Main.MeuCanino, Main.VaiRex, Main.ChowChawgas, Main.resultado);
                    resultado.setText(Main.resultado.nome);
                    resultado.setOpaque(true);
                    resultado.setBackground(Color.WHITE);
                    ErrorLabel.setText("");
                    ErrorLabel.setOpaque(false);
                }
                catch (DateTimeException error){
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
