
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import org.math.plot.Plot2DPanel;
import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.math.plot.plotObjects.BaseLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AMPR
 */
public class RegresionDatos {
    
    
    SimpleRegression sr=new   SimpleRegression ();
    Plot2DPanel plot = new Plot2DPanel();
    JTextArea  resultados = new JTextArea();
    public RegresionDatos() {
        double [] x= new  double[consoleAB.listax.size()];
    double [] y= new double[consoleAB.listaY.size()];
        for ( int i = 0 ; i < consoleAB.listax.size(); i++) {
            System.out.println("From Regresion: " + consoleAB.listax.get(i));
            double val = consoleAB.listax.get(i);
            x[i] = val;        
        }
        for ( int i = 0 ; i < consoleAB.listaY.size(); i++) {
            double val = consoleAB.listaY.get(i);
            y[i] = val;        
        }
        
        for(int i=0; i<consoleAB.listax.size(); i++){
            sr.addData(x[i], y[i]);
        }
        double[] yc= new double [consoleAB.listaY.size()];
        for(int i=0; i<consoleAB.listax.size(); i++){
            yc[i]=sr.predict(x[i]);
        }
        plot.addLegend("South");
        plot.addScatterPlot("Datos Originales", x, y);
        plot.addLinePlot("Regresion",x, yc);
        
        BaseLabel titulo = new BaseLabel("Regresion Lineal", Color.BLUE, 0.5, 1.1);
        plot.addPlotable(titulo);
        
        resultados.setBackground(Color.LIGHT_GRAY);
        resultados.append("Datos leidos" +sr.getN());
        resultados.append("\n Ordenada al origen: "+sr.getIntercept());
        resultados.append("\n Pendiente: " +sr.getSlope());
        
        
        
        JFrame frame= new JFrame("Regresion Lineal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,500);
        frame.add(plot, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    
    public static void main (String[] args){
        new RegresionDatos();
    }
    
    
}
