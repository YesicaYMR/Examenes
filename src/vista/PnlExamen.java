/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import baseDatos.Conexion;
import baseDatos.OperacionesTabla;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Aula;
import modelo.Profesor;
import utilidades.Fecha;

/**
 *
 * @author Yesica
 */
public class PnlExamen extends javax.swing.JPanel {

    Conexion conexion;
    OperacionesTabla operaciones;
    DefaultComboBoxModel modeloComboProf;
    DefaultComboBoxModel modeloComboAula;

    /**
     * Creates new form PnlExamen
     */
    public PnlExamen() {
        initComponents();
        conexion = new Conexion();
        if (conexion.establecer("jdbc:mysql://localhost:3306/centromachor") == -1) {
            JOptionPane.showMessageDialog(null, "Errores en la base de datos");
            System.exit(-1);
        } else {
            operaciones = new OperacionesTabla(conexion);
        }
        modeloComboProf = new DefaultComboBoxModel();//creamos el modeloCombo de los datos
        cmbDni.setModel(modeloComboProf);//insertamos los datos

        modeloComboAula = new DefaultComboBoxModel();//creamos el modeloCombo de los datos
        cmbAula.setModel(modeloComboAula);//insertamos los datos
        cmbAula.setVisible(false);
        scrollTexto.setVisible(false);
        cargarInfoComboProf();
        lblCodigo.setVisible(false);
        lblDescripcion.setVisible(false);
        btnAceptar.setEnabled(false);
    }

    private void cargarInfoComboAulas(String dni, String fecha, int hora) {
        modeloComboAula.addElement("Seleccione una opción");//sale como primera opcion la frase
        ArrayList<Aula> aulas = operaciones.aulasLibres(dni, fecha, hora);
        modeloComboAula.addAll(aulas);

    }

    private void cargarInfoComboProf() {
        modeloComboProf.addElement("Seleccione una opción");//sale como primera opcion la frase
        ArrayList<Profesor> profesores = operaciones.todosProfesores();
        modeloComboProf.addAll(profesores);

    }

    private void limpiar() {
        txtFecha.setText("");
        txtHora.setText("");
        cmbDni.setSelectedIndex(0);
        cmbAula.removeAllItems();
        txtFecha.setEditable(true);
        txtHora.setEditable(true);
        cmbDni.setEnabled(true);
        cmbAula.setVisible(false);
        txtDescripcion.setText("");
        scrollTexto.setVisible(false);
        lblCodigo.setVisible(false);
        lblDescripcion.setVisible(false);
        btnAceptar.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbDni = new javax.swing.JComboBox<>();
        cmbAula = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        btnDisponible = new javax.swing.JButton();
        txtHora = new javax.swing.JTextField();
        txtFecha = new javax.swing.JTextField();
        scrollTexto = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbDni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 280, 40));

        cmbAula.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(cmbAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 270, 290, 40));

        btnCancelar.setBackground(new java.awt.Color(153, 204, 255));
        btnCancelar.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(0, 51, 153));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 450, -1, -1));

        btnAceptar.setBackground(new java.awt.Color(153, 204, 255));
        btnAceptar.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        btnAceptar.setForeground(new java.awt.Color(0, 51, 153));
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 450, -1, -1));

        btnDisponible.setBackground(new java.awt.Color(153, 204, 255));
        btnDisponible.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        btnDisponible.setForeground(new java.awt.Color(0, 51, 153));
        btnDisponible.setText("Buscar disponibilidad");
        btnDisponible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibleActionPerformed(evt);
            }
        });
        add(btnDisponible, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, -1, -1));

        txtHora.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHoraKeyTyped(evt);
            }
        });
        add(txtHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 100, 30));

        txtFecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFechaKeyTyped(evt);
            }
        });
        add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, 100, 30));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        scrollTexto.setViewportView(txtDescripcion);

        add(scrollTexto, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 390, 70));

        jLabel3.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Hora");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, -1, -1));

        jLabel4.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 153));
        jLabel4.setText("Profesor");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, -1, -1));

        lblCodigo.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        lblCodigo.setForeground(new java.awt.Color(0, 51, 153));
        lblCodigo.setText("Código aula");
        add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, -1));

        jLabel1.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Fecha  (aaaa/mm/dd)");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel2.setFont(new java.awt.Font("SimSun", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Alta Examen");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        lblDescripcion.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        lblDescripcion.setForeground(new java.awt.Color(0, 51, 153));
        lblDescripcion.setText("Descripción");
        add(lblDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnDisponibleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibleActionPerformed
        String fechaString = txtFecha.getText();
        String horaString = txtHora.getText();
        int hora = 0;
        Profesor p;
        if (fechaString.isBlank() || horaString.isBlank()) {
            JOptionPane.showMessageDialog(this, "Rellene todos los datos", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Fecha fechaExamen = new Fecha();
            if (!fechaExamen.comprobarFechaAnno(fechaString)) {
                JOptionPane.showMessageDialog(this, "Introduzca una fecha correcta", "Error", JOptionPane.ERROR_MESSAGE);
                txtFecha.setText("");
                txtFecha.requestFocus();
            } else {
                Fecha fechaHoy = new Fecha();
                if (!fechaHoy.comprobarFechaMenor(fechaExamen)) {
                    JOptionPane.showMessageDialog(this, "La fecha del examen no puede ser posterior a la actual", "Error", JOptionPane.ERROR_MESSAGE);
                    txtFecha.setText("");
                    txtFecha.requestFocus();
                } else {
                    try {
                        hora = Integer.parseInt(horaString);
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "La hora debe de ser un valor numérico", "Error", JOptionPane.ERROR_MESSAGE);
                        txtHora.setText("");
                        txtHora.requestFocus();
                    }
                    if (hora < 0 || hora > 23) {
                        JOptionPane.showMessageDialog(this, "La hora no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
                        txtHora.setText("");
                        txtHora.requestFocus();
                    } else {
                        int pos = cmbDni.getSelectedIndex();
                        if (pos == 0) {
                            JOptionPane.showMessageDialog(this, "Seleccione un profesor", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            p = (Profesor) modeloComboProf.getElementAt(pos);
                            if (operaciones.profesorDisponible(p.getDni(), fechaString, hora)) {
                                JOptionPane.showMessageDialog(this, "El profesor no está disponible", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                cmbDni.setEnabled(false);
                                txtFecha.setEditable(false);
                                txtHora.setEditable(false);
                                cmbAula.setVisible(true);
                                scrollTexto.setVisible(true);
                                lblCodigo.setVisible(true);
                                lblDescripcion.setVisible(true);
                                cargarInfoComboAulas(p.getDni(), fechaString, hora);
                                btnAceptar.setEnabled(true);
                            }
                        }
                    }
                }
            }
        }


    }//GEN-LAST:event_btnDisponibleActionPerformed

    private void txtHoraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHoraKeyTyped
        //Limita a escribir un máximo de 3 caracteres        
        if (txtHora.getText().length() >= 2) {
            evt.consume();
        }
    }//GEN-LAST:event_txtHoraKeyTyped

    private void txtFechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFechaKeyTyped
        //Limita a escribir un máximo de 3 caracteres        
        if (txtFecha.getText().length() >= 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtFechaKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String fecha = txtFecha.getText();
        int hora = Integer.parseInt(txtHora.getText());
        Profesor z = (Profesor) cmbDni.getSelectedItem();
        String dni = z.getDni();

        int pos = cmbDni.getSelectedIndex();
        if (pos == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un aula", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            Aula a = (Aula) modeloComboAula.getSelectedItem();
            String codAula = a.getCodAula();
            String texto = txtDescripcion.getText();
            operaciones.crearExamen(fecha, hora, dni, codAula, texto);
            JOptionPane.showMessageDialog(this, "Examen establecido", "Información", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnDisponible;
    private javax.swing.JComboBox<String> cmbAula;
    private javax.swing.JComboBox<String> cmbDni;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JScrollPane scrollTexto;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHora;
    // End of variables declaration//GEN-END:variables
}
