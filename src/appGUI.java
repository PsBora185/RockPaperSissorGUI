import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class appGUI extends JFrame implements ActionListener{
    // player buttons
    JButton rockButton, paperButton, scissorButton ;

    JLabel compScore, compChoice, pScore;

    appLogic rps ;

    public appGUI(){
        // invoke jframe constructor
        super("Rock , Paper , Scissor");

        setSize(450,570);

        // to disable layout management , so we can set position as we want
        setLayout(null);

        // laod GUI in center
        setLocationRelativeTo(null);

        // when closing gUI stop program
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rps = new appLogic();
        addGUIcomponent();
    }

    private void addGUIcomponent(){

        // computer score label
        compScore = new JLabel("Computer : 0");

        // set x,y coordinates for position & width, height
        compScore.setBounds(0,40,380,40);

        compScore.setFont(new Font("Dialog", Font.BOLD, 26));

        // align in center
        compScore.setHorizontalAlignment(SwingConstants.CENTER);

        //add in frame
        add(compScore);

        // computer's choice
        compChoice = new JLabel("?");
        compChoice.setBounds(175,120,100,85);
        compChoice.setFont(new Font("Dialog", Font.PLAIN,18));
        compChoice.setHorizontalAlignment(SwingConstants.CENTER);

        //create border
        compChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(compChoice);

        // player score label
        pScore = new JLabel("Player : 0");
        pScore.setBounds(0,300,380,40);
        pScore.setFont(new Font("Dialog", Font.BOLD, 26));
        pScore.setHorizontalAlignment(SwingConstants.CENTER);
        add(pScore);

        // rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(30, 387, 100, 85);
        rockButton.setFont(new Font("Dialog",Font.PLAIN,18));
        rockButton.setActionCommand("Rock");
        rockButton.addActionListener(appGUI.this);
        add(rockButton);

        // paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(160, 387, 100, 85);
        paperButton.setFont(new Font("Dialog",Font.PLAIN,18));
        paperButton.addActionListener(appGUI.this);
        add(paperButton);

        // scissor button
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(290, 387, 100, 85);
        scissorButton.setFont(new Font("Dialog",Font.PLAIN,18));
        scissorButton.addActionListener(appGUI.this);
        add(scissorButton);

    }

    public void showDialog (String message){
        JDialog resultDialog = new JDialog(this,"Result",true);
        resultDialog.setSize(230,125);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        // message label
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Dialog",Font.BOLD,18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel);

        // try again button
        JButton tryAgain = new JButton("Try Again");
        tryAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // reset computer choice
                compChoice.setText("?");

                // close the dialog box
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgain, BorderLayout.SOUTH);

        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String pChoice = e.getActionCommand();

        String result = rps.play(pChoice);

        compChoice.setText(rps.getCompChoice());

        compScore.setText("Computer : "+rps.getCompScore());
        pScore.setText("Player : "+rps.getPlayerScore());

        showDialog(result);
    }

}
