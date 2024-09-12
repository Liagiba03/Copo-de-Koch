package packageMain;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class mainApp extends JFrame {

    private JPanel contentPane;
    
    //Variables 
    double xp1=300;
    double yp1=300;
    double xp2=10;
    double yp2=300;
    double sin60=Math.sin(3.14/3.);
    int nivel_de_recursividad=6;
    /**
     * Launch the application.
     */
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

    /**
     * Create the frame.
     */
    public mainApp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setBounds(500, 500, 900, 900);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        //contentPane.setLayout(null);
        setBounds(800,0,330,500);
    }
    
    public void paint (Graphics g)
    {
       // super.paint(g);

        paintRecursivo(g,nivel_de_recursividad,xp1,yp1,xp2,yp2);
    }
    
    //Función para hacer ercursiva la función
    private void paintRecursivo(Graphics g, int i, double xp12, double yp12,
    	double xp22, double yp22 ) {
    	double dx=(xp22-xp12)/3.;
    	double dy=(yp22-yp12)/3.;
    	double xx=xp12+3*dx/2.-dy*sin60;
   		double yy=yp12+3*dy/2.+dx*sin60;
    	if(i<=0){
    		g.drawLine((int)xp12,(int)yp12,(int)xp22,(int)yp22);
    	}
    	else{
    		paintRecursivo(g,i-1,xp12,yp12,xp12+dx,yp12+dy);
    		paintRecursivo(g,i-1,xp12+dx,yp12+dy,xx,yy);
    		paintRecursivo(g,i-1,xx,yy,xp22-dx,yp22-dy);
    		paintRecursivo(g,i-1,xp22-dx,yp22-dy,xp22,yp22);
    	}
   	}
}