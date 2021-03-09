/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;
import java.awt.*;
import javax.swing.border.Border;
import java.awt.event.*;
/**
 *
 * @author David Castillo
 */
public class Calculadora extends Frame{
    public static double suma(double a, double b)
    {
        return a+b;
    }
    public static double resta(double a, double b)
    {
        return a-b;
    }
    public static double multiplicacion(double a, double b)
    {
        return a*b;
    }
    public static double division(double a, double b)
    {
        return a/b;
    }
    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    private Button bDec,bMas,bMenos,bPor,bDiv,bIgual,bBorrar;
    private TextField tfDisplay;
    public Calculadora()
    {
        super();
        setLayout(new BorderLayout());
        tfDisplay = new TextField();
        add(tfDisplay,BorderLayout.NORTH);
        Panel pTeclado = _crearTeclado();
        add(pTeclado, BorderLayout.CENTER);
        pack();
        bIgual.addActionListener(new EscuchaAgregar());
        b0.addActionListener(new EscuchaAgregar());
        b1.addActionListener(new EscuchaAgregar());
        b2.addActionListener(new EscuchaAgregar());
        b3.addActionListener(new EscuchaAgregar());
        b4.addActionListener(new EscuchaAgregar());
        b5.addActionListener(new EscuchaAgregar());
        b6.addActionListener(new EscuchaAgregar());
        b7.addActionListener(new EscuchaAgregar());
        b8.addActionListener(new EscuchaAgregar());
        b9.addActionListener(new EscuchaAgregar());
        setVisible(true);
        addWindowListener(new EscuchaVentana());
    }
    
    class EscuchaAgregar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if()
            tfDisplay.add(miTexto);
        }
    }
    
    private Panel _crearTeclado()
    {
        // instancio los 16 botones
        b0 = new Button("0");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        bDec = new Button(".");
        bMas=new Button("+");
        bMenos=new Button("-");
        bPor = new Button("*");
        bDiv = new Button("/");
        bIgual = new Button("=");
        // instancio un Panel (un container) con GridLayout de 4 x 4
        Panel p = new Panel( new GridLayout(4,4) );
        // Agrego los botones al panel
        // fi la 0 (la mas de mas arriba)
        p.add(b7);
        p.add(b8);
        p.add(b9);
        p.add(bDiv);
        // fi la 1 (la segunda comenzando desde arriba)
        p.add(b4);
        p.add(b5);
        p.add(b6);
        p.add(bPor);
        // fi la 2 (la tercera comenzando desde arriba)
        p.add(b1);
        p.add(b2);
        p.add(b3);
        p.add(bMenos);
        // fi la 3 (la cuarta comenzando desde arriba)
        p.add(bDec);
        p.add(b0);
        p.add(bIgual);
        p.add(bMas);
        // retorno el Panel con todos los botones agregados
        return p;
     }
    class EscuchaVentana implements WindowListener
    {
        public void windowClosing(WindowEvent e)
        {
            System.out.println("Oculto...");
            setVisible(false);
            System.out.println("Libero...");
            dispose();
            System.out.println("Bye bye...");
            System.exit(0);
        }
        public void windowActivated(WindowEvent e){}
        public void windowClosed(WindowEvent e){}
        public void windowDeactivated(WindowEvent e){}
        public void windowDeiconified(WindowEvent e){}
        public void windowIconified(WindowEvent e){}
        public void windowOpened(WindowEvent e){}
    }
     public static void main(String[] args)
     {
        Calculadora c = new Calculadora();
     }
}
