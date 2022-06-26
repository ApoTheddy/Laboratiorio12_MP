package arregloobjetos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class frmEmpleados extends javax.swing.JFrame {

    DefaultTableModel model;
    Empleado empleado;
    Empleado[] empleados;
    String data[][];
    String[] cabezera = new String[]{"N", "Codigo", "Nombre", "Area", "Tipo Seg", "Horas Extras", "Sueldo", "Monto H.E", "Monto Seguro", "Monto EsSalud", "Sueldo Neto"};
    int numEmp = 0;

    public frmEmpleados() {
        initComponents();
        model = new DefaultTableModel(data, cabezera);
        empleados = new Empleado[100];
        jtblTableView.setModel(model);
        extraerArchivo();
        tamanioColumnas();
    }

    public void extraerArchivo() {
        try ( BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line, "|");
                String codigo = st.nextToken();
                String nombre = st.nextToken();
                String area = st.nextToken();
                double sueldo = Double.parseDouble(st.nextToken());
                int h_extras = Integer.parseInt(st.nextToken());
                String tipo_seguro = st.nextToken();

                empleado = new Empleado(codigo, nombre, area, sueldo, h_extras, tipo_seguro);
                empleados[numEmp] = empleado;
                InsertarEnTabla(empleado);
                ++numEmp;
            }
            br.close();
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(null, "Error de lectura" + ioEx, "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void escribirArchivo(Empleado empleado) {
        try ( PrintWriter pw = new PrintWriter(new FileWriter("datos.txt", true))) {
            pw.println(empleado.codigo + "|" + empleado.nombres + "|" + empleado.areaLaboral + "|" + empleado.sueldo + "|" + empleado.horasExtra + "|" + empleado.tipoAfiliacion);
            pw.close();
        } catch (IOException ioEx) {
            JOptionPane.showMessageDialog(null, "Error de escritura" + ioEx + "ERROR_MESSAGE" + JOptionPane.ERROR_MESSAGE);
        }
    }

    public void tamanioColumnas() {
        TableColumn columnWidth = new TableColumn();
        columnWidth = jtblTableView.getColumnModel().getColumn(2);
        columnWidth.setPreferredWidth(150);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtxtSueldoBase = new javax.swing.JTextField();
        jtxtCodigo = new javax.swing.JTextField();
        jtxtHorasExtras = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jcbxAfiliacion = new javax.swing.JComboBox<>();
        jbtnMostrarResumen = new javax.swing.JButton();
        jbtnGrabar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblTableView = new javax.swing.JTable();
        jtxtB = new javax.swing.JTextField();
        jtxtA = new javax.swing.JTextField();
        jtxtF = new javax.swing.JTextField();
        jtxtE = new javax.swing.JTextField();
        jtxtD = new javax.swing.JTextField();
        jtxtC = new javax.swing.JTextField();
        jcbxArea = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jtxtSueldoBase.setBackground(new java.awt.Color(255, 255, 255));
        jtxtSueldoBase.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtSueldoBase.setForeground(new java.awt.Color(51, 51, 51));
        jtxtSueldoBase.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Sueldo Base", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtSueldoBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtSueldoBaseActionPerformed(evt);
            }
        });

        jtxtCodigo.setBackground(new java.awt.Color(255, 255, 255));
        jtxtCodigo.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtCodigo.setForeground(new java.awt.Color(51, 51, 51));
        jtxtCodigo.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Codigo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCodigoActionPerformed(evt);
            }
        });

        jtxtHorasExtras.setBackground(new java.awt.Color(255, 255, 255));
        jtxtHorasExtras.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtHorasExtras.setForeground(new java.awt.Color(51, 51, 51));
        jtxtHorasExtras.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Horas Extras", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtHorasExtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtHorasExtrasActionPerformed(evt);
            }
        });

        jtxtNombre.setBackground(new java.awt.Color(255, 255, 255));
        jtxtNombre.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtNombre.setForeground(new java.awt.Color(51, 51, 51));
        jtxtNombre.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Nombre", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtNombreActionPerformed(evt);
            }
        });

        jcbxAfiliacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AFP", "SNP" }));
        jcbxAfiliacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxAfiliacionActionPerformed(evt);
            }
        });

        jbtnMostrarResumen.setText("Mostrar Resumen");
        jbtnMostrarResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnMostrarResumenActionPerformed(evt);
            }
        });

        jbtnGrabar.setText("Grabar");
        jbtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGrabarActionPerformed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Limpiar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jtblTableView.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jtblTableView);

        jtxtB.setBackground(new java.awt.Color(255, 255, 255));
        jtxtB.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtB.setForeground(new java.awt.Color(51, 51, 51));
        jtxtB.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "N Emp. de Sistemas con Monto H.E entre 500 y 800 soles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtBActionPerformed(evt);
            }
        });

        jtxtA.setBackground(new java.awt.Color(255, 255, 255));
        jtxtA.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtA.setForeground(new java.awt.Color(51, 51, 51));
        jtxtA.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Nombre del empleado que tenga el mayor sueldo neto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtAActionPerformed(evt);
            }
        });

        jtxtF.setBackground(new java.awt.Color(255, 255, 255));
        jtxtF.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtF.setForeground(new java.awt.Color(51, 51, 51));
        jtxtF.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Ttoal que gasta la empresa en pagar a todos sus empleados", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtFActionPerformed(evt);
            }
        });

        jtxtE.setBackground(new java.awt.Color(255, 255, 255));
        jtxtE.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtE.setForeground(new java.awt.Color(51, 51, 51));
        jtxtE.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "N de Emp. cuyo Monto de Seguro > 100 soles", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtEActionPerformed(evt);
            }
        });

        jtxtD.setBackground(new java.awt.Color(255, 255, 255));
        jtxtD.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtD.setForeground(new java.awt.Color(51, 51, 51));
        jtxtD.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Emp. del SNP con el menor monto de descuento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtDActionPerformed(evt);
            }
        });

        jtxtC.setBackground(new java.awt.Color(255, 255, 255));
        jtxtC.setFont(new java.awt.Font("Victor Mono SemiBold", 0, 12)); // NOI18N
        jtxtC.setForeground(new java.awt.Color(51, 51, 51));
        jtxtC.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.LineBorder(new java.awt.Color(102, 204, 255), 1, true), "Promedio de sueldos netos en el area de Marketing", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Victor Mono SemiBold", 0, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jtxtC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCActionPerformed(evt);
            }
        });

        jcbxArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sistemas", "Administracion", "Marketing" }));
        jcbxArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbxAreaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jcbxAfiliacion, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jtxtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtxtHorasExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(jcbxArea, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnMostrarResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtA, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(jtxtB))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtC)
                            .addComponent(jtxtD, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtxtE)
                            .addComponent(jtxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnGrabar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jcbxAfiliacion)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtSueldoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jtxtHorasExtras, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtnMostrarResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbxArea))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtA, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtB, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtE, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtF, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jtxtC, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxtD, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtSueldoBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtSueldoBaseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtSueldoBaseActionPerformed

    private void jtxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCodigoActionPerformed

    private void jtxtHorasExtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtHorasExtrasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtHorasExtrasActionPerformed

    private void jtxtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtNombreActionPerformed

    private void jbtnMostrarResumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnMostrarResumenActionPerformed
        String a = "", e = "";
        double b = 0, c = 0, ss = 0, cont = 0, d = 0, f = 0, mayor = 1, menor = 999999;
        for (int i = 0; i < numEmp; ++i) {

            if (empleados[i].sueldoNeto() > mayor) {
                mayor = empleados[i].sueldoNeto();
                a = empleados[i].nombres;
            }
            if (empleados[i].areaLaboral.equals("Marketing")) {
                ss = ss + empleados[i].sueldoNeto();
                ++cont;
                b = ss / cont;
            }
            if (empleados[i].montoSeguro() > 100) {
                c++;
            }
            if (empleados[i].areaLaboral.equals("Sistemas") && empleados[i].montoHExtras() >= 500 && empleados[i].montoHExtras() <= 800) {
                d++;
            }
            if (empleados[i].tipoAfiliacion.equals("SNP") && empleados[i].montoDescuentos() < menor) {
                menor = empleados[i].montoDescuentos();
                e = empleados[i].nombres;
            }
            f = f + empleados[i].sueldoBruto();
        }

        jtxtA.setText(a);
        jtxtC.setText(String.valueOf(b));
        jtxtB.setText(String.valueOf(c));
        jtxtD.setText(e);
        jtxtE.setText(String.valueOf(d));
        jtxtF.setText(String.valueOf(f));
    }//GEN-LAST:event_jbtnMostrarResumenActionPerformed

    private void jbtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGrabarActionPerformed
        String codigo = jtxtCodigo.getText();
        String nombres = jtxtNombre.getText();
        String seguro = jcbxAfiliacion.getSelectedItem().toString();
        double sueldo = Double.parseDouble(jtxtSueldoBase.getText());
        int horasExtras = Integer.parseInt(jtxtHorasExtras.getText());
        String areaLaboral = jcbxArea.getSelectedItem().toString();

        empleado = new Empleado(codigo, nombres, areaLaboral, sueldo, horasExtras, seguro);
        escribirArchivo(empleado);

        empleados[numEmp] = empleado;
        InsertarEnTabla(empleado);

        ++numEmp;
        limpiarEntradas();
    }//GEN-LAST:event_jbtnGrabarActionPerformed

    void InsertarEnTabla(Empleado unEmp) {
        DecimalFormat df = new DecimalFormat("####.00");
        String me = df.format(unEmp.montoHExtras());
        String ms = df.format(unEmp.montoSeguro());
        String mes = df.format(unEmp.montoEsSalud());
        String sn = df.format(unEmp.sueldoNeto());
        Object[] fila = {numEmp + 1, unEmp.codigo, unEmp.nombres, unEmp.areaLaboral, unEmp.tipoAfiliacion, unEmp.horasExtra, unEmp.sueldo, me, ms, mes, sn};
        model.addRow(fila);
    }

    void limpiarEntradas() {
        jtxtCodigo.setText("");
        jtxtNombre.setText("");
        jcbxAfiliacion.setSelectedIndex(0);
        jtxtSueldoBase.setText("");
        jtxtHorasExtras.setText("");
        jcbxArea.setSelectedIndex(0);
        jtxtCodigo.requestFocus();
    }

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        limpiarEntradas();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jtxtBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtBActionPerformed

    private void jtxtAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtAActionPerformed

    private void jtxtFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtFActionPerformed

    private void jtxtEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtEActionPerformed

    private void jtxtDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtDActionPerformed

    private void jtxtCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtCActionPerformed

    private void jcbxAfiliacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxAfiliacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxAfiliacionActionPerformed

    private void jcbxAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbxAreaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbxAreaActionPerformed

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
            java.util.logging.Logger.getLogger(frmEmpleados.class
               .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class
               .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class
               .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmEmpleados.class
               .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnGrabar;
    private javax.swing.JButton jbtnMostrarResumen;
    private javax.swing.JComboBox<String> jcbxAfiliacion;
    private javax.swing.JComboBox<String> jcbxArea;
    private javax.swing.JTable jtblTableView;
    private javax.swing.JTextField jtxtA;
    private javax.swing.JTextField jtxtB;
    private javax.swing.JTextField jtxtC;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtD;
    private javax.swing.JTextField jtxtE;
    private javax.swing.JTextField jtxtF;
    private javax.swing.JTextField jtxtHorasExtras;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtSueldoBase;
    // End of variables declaration//GEN-END:variables
}
