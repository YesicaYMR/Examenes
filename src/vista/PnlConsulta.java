/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

import baseDatos.Conexion;
import baseDatos.OperacionesTabla;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import modelo.Examen;
import modelo.MiModeloTabla;
import modelo.Profesor;

/**
 *
 * @author Yesica
 */
public class PnlConsulta extends javax.swing.JPanel {

    Conexion conexion;
    OperacionesTabla operaciones;
    DefaultComboBoxModel modeloCombo;
    MiModeloTabla modeloTablaExamenes;

    /**
     * Creates new form PnlConsulta
     */
    public PnlConsulta() {
        initComponents();
        initComponents();
        conexion = new Conexion();
        if (conexion.establecer("jdbc:mysql://localhost:3306/centromachor") == -1) {
            JOptionPane.showMessageDialog(null, "Errores en la base de datos");
            System.exit(-1);
        } else {
            operaciones = new OperacionesTabla(conexion);
        }
        modeloCombo = new DefaultComboBoxModel();
        cmbProfesor.setModel(modeloCombo);
        cargarInfoCombo();
        modeloTablaExamenes = new MiModeloTabla();
        String[] titulos = {"Código examen", "Fecha"};
        modeloTablaExamenes.setColumnIdentifiers(titulos);//inserta los titulos escritos 
        tblExamenes.setModel(modeloTablaExamenes);
    }

    private void cargarInfoCombo() {
        modeloCombo.addElement("Seleccione una opción");//sale como primera opcion la frase
        ArrayList<Profesor> profesores = operaciones.todosProfesores();
        modeloCombo.addAll(profesores);

    }

    private void limpiarTablaExamenes() {
        int nFilas = modeloTablaExamenes.getRowCount();
        for (int pos = 0; pos < nFilas; pos++) {
            modeloTablaExamenes.removeRow(0);
        }
    }

    private void cargarTablaExamenes(String dni) {
        limpiarTablaExamenes();
        ArrayList<Examen> examenes = operaciones.todosExamenes(dni);
        for (Examen e : examenes) {
            Vector v = new Vector();
            v.add(e);
            v.add(e.getFecha());
            modeloTablaExamenes.addRow(v);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbProfesor = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        lblAula = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtTexto = new javax.swing.JTextArea();
        Scroll = new javax.swing.JScrollPane();
        tblExamenes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmbProfesor.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        cmbProfesor.setForeground(new java.awt.Color(0, 51, 153));
        cmbProfesor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbProfesorActionPerformed(evt);
            }
        });
        add(cmbProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 240, 40));

        jLabel2.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 153));
        jLabel2.setText("Hora:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, -1, 30));

        jLabel3.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 153));
        jLabel3.setText("Aula:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 252, -1, 30));

        lblHora.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(0, 51, 153));
        add(lblHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 90, 30));

        lblAula.setFont(new java.awt.Font("SimSun", 0, 18)); // NOI18N
        lblAula.setForeground(new java.awt.Color(0, 51, 153));
        add(lblAula, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 130, 30));

        txtTexto.setEditable(false);
        txtTexto.setColumns(20);
        txtTexto.setForeground(new java.awt.Color(0, 51, 153));
        txtTexto.setRows(5);
        jScrollPane1.setViewportView(txtTexto);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 440, 120));

        tblExamenes.setForeground(new java.awt.Color(0, 51, 153));
        tblExamenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblExamenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExamenesMouseClicked(evt);
            }
        });
        Scroll.setViewportView(tblExamenes);

        add(Scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, 100));

        jLabel1.setFont(new java.awt.Font("SimSun", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 153));
        jLabel1.setText("Consulta Examenes");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void cmbProfesorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbProfesorActionPerformed
        int pos = cmbProfesor.getSelectedIndex();//dame el seleccionado
        if (pos != 0) {
            String dni;
            Profesor profesor = (Profesor) cmbProfesor.getSelectedItem();
            dni = profesor.getDni();
            cargarTablaExamenes(dni);

        } else {
            try {
                limpiarTablaExamenes();

            } catch (Exception ex) {

            }
        }
    }//GEN-LAST:event_cmbProfesorActionPerformed

    private void tblExamenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExamenesMouseClicked
        Examen seleccionado;
        int fila = tblExamenes.rowAtPoint(evt.getPoint());
        // int columna = tabla.columnAtPoint(e.getPoint()); no me interesa la columna ha pulsado
        if ((fila > -1) /*&& (columna > -1)*/) {

            seleccionado = (Examen) modeloTablaExamenes.getValueAt(fila, 0);//me devuelve el valor que exite en la fila que se ha hecho clic, columna 0
            lblHora.setText(String.valueOf(seleccionado.getHora()));
            lblAula.setText(seleccionado.getCod_aula());
            txtTexto.setText(seleccionado.getTexto());

        }
    }//GEN-LAST:event_tblExamenesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private javax.swing.JComboBox<String> cmbProfesor;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAula;
    private javax.swing.JLabel lblHora;
    private javax.swing.JTable tblExamenes;
    private javax.swing.JTextArea txtTexto;
    // End of variables declaration//GEN-END:variables
}