import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class mainApp extends JFrame {
    private JPanel contentPane;

    // Variables
    double sin60 = Math.sin(Math.PI / 3); // Precalculamos el valor de sin(60°)
    int nivel_de_recursividad = 5; // Aumenta para más detalle

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    mainApp frame = new mainApp();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public mainApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        setBounds(800, 0, 600, 600);
    }

    public void paint(Graphics g) {
        super.paint(g);
        
        // Establecemos el color negro explícitamente
        g.setColor(Color.BLACK);

        // Coordenadas iniciales del triángulo
        double xp1 = 300, yp1 = 300;
        double lado = 200; // Lado del triángulo equilátero

        // Dibujamos los tres lados del triángulo inicial
        double xp2 = xp1 - lado * Math.cos(Math.PI / 3);
        double yp2 = yp1 + lado * Math.sin(Math.PI / 3);

        double xp3 = xp1 + lado * Math.cos(Math.PI / 3);
        double yp3 = yp1 + lado * Math.sin(Math.PI / 3);

        // Dibujamos las tres líneas iniciales
        paintRecursivo(g, nivel_de_recursividad, xp1, yp1, xp2, yp2);
        paintRecursivo(g, nivel_de_recursividad, xp2, yp2, xp3, yp3);
        paintRecursivo(g, nivel_de_recursividad, xp3, yp3, xp1, yp1);
    }

    // Función recursiva para dibujar el fractal
    private void paintRecursivo(Graphics g, int i, double xp12, double yp12,
                                double xp22, double yp22) {
        double dx = (xp22 - xp12) / 3.;
        double dy = (yp22 - yp12) / 3.;
        double xx = xp12 + 3 * dx / 2. - dy * sin60;
        double yy = yp12 + 3 * dy / 2. + dx * sin60;
        
        if (i <= 0) {
            g.drawLine((int) xp12, (int) yp12, (int) xp22, (int) yp22);
        } else {
            paintRecursivo(g, i - 1, xp12, yp12, xp12 + dx, yp12 + dy);
            paintRecursivo(g, i - 1, xp12 + dx, yp12 + dy, xx, yy);
            paintRecursivo(g, i - 1, xx, yy, xp22 - dx, yp22 - dy);
            paintRecursivo(g, i - 1, xp22 - dx, yp22 - dy, xp22, yp22);
        }
    }
}
