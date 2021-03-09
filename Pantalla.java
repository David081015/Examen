/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Examen;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author David Castillo
 */
public class Pantalla extends Frame{
    private Button bAgregar;
    private TextField tfNombre;
    private TextField tfApellido;
    private List lista;
    public Pantalla()
    {
        super("Pantalla");
        setLayout(new BorderLayout());
        Panel pN = _getNombreCompleto();
        add(pN,BorderLayout.NORTH);
        lista = new List();
        add(lista,BorderLayout.CENTER);
        bAgregar.addActionListener(new EscuchaAgregar());
        tfNombre.addActionListener(new EscuchaAgregar());
        tfApellido.addActionListener(new EscuchaAgregar());
        lista.addActionListener(new EscuchaDobleClick());
        this.addWindowListener(new EscuchaVentana());
        setSize(300,300);
        setVisible(true);
    }
    class EscuchaAgregar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String miTexto1 = tfNombre.getText();
            tfNombre.selectAll();
            tfNombre.requestFocus();
            
            String miTexto2 = tfApellido.getText();
           tfApellido.selectAll();
            tfApellido.requestFocus();
            lista.add(miTexto1 +" "+miTexto2);
        }
    }
    class EscuchaDobleClick implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            int indice = lista.getSelectedIndex();
            tfNombre.setText(lista.getSelectedItem());
            lista.remove(indice);
            tfNombre.selectAll();
            tfNombre.requestFocus();
            
            tfApellido.setText(lista.getSelectedItem());
            lista.remove(indice);
            tfApellido.selectAll();
            tfApellido.requestFocus();
        }
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
    private Panel _getNombreCompleto()
    {
        Panel p = new Panel(new FlowLayout(FlowLayout.LEFT));
        p.add(new Label("Nombre: "));
        tfNombre = new TextField(15);
        p.add(tfNombre);
        p.add(new Label("Apellido: "));
        tfApellido = new TextField(15);
        p.add(tfApellido);
        bAgregar = new Button("Agregar");
        p.add(bAgregar);
        return p;
    }
    
    public static void main(String[] args)
    {
        new Pantalla();
    }
}
