/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autodiagnostico;
import fuentes.Fuentes;
import java.awt.Font;
import org.jpl7.Query;
import Animacion.*;
import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import org.jpl7.Atom;
import org.jpl7.Term;
import org.jpl7.Variable;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class InicioFrame extends javax.swing.JFrame {

    public Fuentes tipofuente;
    public InicioFrame() {
        tipofuente= new Fuentes();
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelIniFrame = new javax.swing.JPanel();
        lTitulo = new javax.swing.JLabel();
        panelIniciarDia = new javax.swing.JPanel();
        lIniciarDia = new javax.swing.JLabel();
        lAuto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Autodiagnóstico");
        setBackground(new java.awt.Color(77, 77, 77));
        setIconImage(new ImageIcon(getClass().getResource("/assets/wrench.png")).getImage());
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 500));
        getContentPane().setLayout(null);

        panelIniFrame.setBackground(new java.awt.Color(64, 64, 64));
        panelIniFrame.setPreferredSize(new java.awt.Dimension(600, 400));
        panelIniFrame.setLayout(null);

        lTitulo.setFont(tipofuente.fuente(tipofuente.DODGER,0,30));
        lTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lTitulo.setText("Autodiagnóstico");
        lTitulo.setFocusable(false);
        lTitulo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelIniFrame.add(lTitulo);
        lTitulo.setBounds(0, 54, 800, 40);

        panelIniciarDia.setBackground(new java.awt.Color(153, 0, 0));
        panelIniciarDia.setForeground(new java.awt.Color(153, 0, 0));

        lIniciarDia.setFont(tipofuente.fuente(tipofuente.CENTURY,0,14));
        lIniciarDia.setForeground(new java.awt.Color(255, 255, 255));
        lIniciarDia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lIniciarDia.setText("INICIAR DIAGNÓSTICO");
        lIniciarDia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lIniciarDiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lIniciarDiaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lIniciarDiaMousePressed(evt);
            }
        });

        javax.swing.GroupLayout panelIniciarDiaLayout = new javax.swing.GroupLayout(panelIniciarDia);
        panelIniciarDia.setLayout(panelIniciarDiaLayout);
        panelIniciarDiaLayout.setHorizontalGroup(
            panelIniciarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelIniciarDiaLayout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(lIniciarDia, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        panelIniciarDiaLayout.setVerticalGroup(
            panelIniciarDiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lIniciarDia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        panelIniFrame.add(panelIniciarDia);
        panelIniciarDia.setBounds(0, 390, 800, 30);

        lAuto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/iconic_cars_07.png"))); // NOI18N
        panelIniFrame.add(lAuto);
        lAuto.setBounds(-600, 160, 430, 150);
        if((lAuto.getX()+(lAuto.getWidth())) < 600){
            Animacion.mover_derecha(lAuto.getX(), 190, 3, 2, lAuto);
            /*Los parámetros a utilizar son:
            Animacion.mover_izquierda(
                coordenada X inicial,
                coordenada X final o destino,
                retardo en milisegundos para cada iteración,
                cantidad de pixeles a recorrer en cada iteración hasta llegar a la coordenada final,
                componente (frame, panel, jdialog)
            );
            A MAYOR CANTIDAD DE MILISEGUNDOS, MAS LENTO SE MOVERÁ EL FRAME.
            A MAYOR CANTIDAD DE PIXELES A RECORRER EN CADA ITERACIÓN, MÁS "BRUSCO" SALTARÁ EL FRAME DE UNA POSICIÓN A OTRA.
            */
        }

        getContentPane().add(panelIniFrame);
        panelIniFrame.setBounds(0, 0, 800, 500);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lIniciarDiaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lIniciarDiaMousePressed
        
        if((lAuto.getX()+(lAuto.getWidth())) < 1000){
            Animacion.mover_derecha(lAuto.getX(), 800, 3, 2, lAuto);
        }
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000); //Pausa el hilo para que el carro se termine de mover a la derecha antes de que se cargue el siguiente frame
                    new DiagnosticoFrame().setVisible(true); //Hace visible el frame diagnostico
                    dispose(); //Elimina el frame actual
                } catch (InterruptedException ex) {
                }
            }
        }).start();
           
    }//GEN-LAST:event_lIniciarDiaMousePressed

    private void lIniciarDiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lIniciarDiaMouseExited
        lIniciarDia.setFont(tipofuente.fuente(tipofuente.CENTURY,Font.PLAIN,14));
    }//GEN-LAST:event_lIniciarDiaMouseExited

    private void lIniciarDiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lIniciarDiaMouseEntered
        lIniciarDia.setFont(tipofuente.fuente(tipofuente.CENTURY,Font.BOLD,14));
    }//GEN-LAST:event_lIniciarDiaMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
       
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lAuto;
    private javax.swing.JLabel lIniciarDia;
    private javax.swing.JLabel lTitulo;
    private javax.swing.JPanel panelIniFrame;
    private javax.swing.JPanel panelIniciarDia;
    // End of variables declaration//GEN-END:variables
}