import javax.swing.*;

public class mainApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                appGUI guiObj = new appGUI();

                guiObj.setVisible(true);
            }
        });
    }
}
