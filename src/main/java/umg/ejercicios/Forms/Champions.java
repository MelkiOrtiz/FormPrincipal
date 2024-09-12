package umg.ejercicios.Forms;

import umg.ejercicios.DataBase.Model.EquipoChampions;
import umg.ejercicios.DataBase.Service.EquipoChampionsService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Champions {
    private JPanel jPanelContainer;

    public Champions() {
        buttonAgregarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipo.setNombre(textFieldNombreEquipo.getText());
                equipo.setPais(textFieldPais.getText());
                equipo.setCiudad(textFieldCiudad.getText());
                equipo.setEstadio(textFieldEstadio.getText());
                equipo.setFundacion(Integer.parseInt(textFieldFundacion.getText()));
                equipo.setEntrenador(textFieldEntrenador.getText());
                equipo.setWebOficial(textFieldWeb.getText());
                equipo.setFacebook(textFieldFacebook.getText());
                equipo.setTwitter(textFieldTwitter.getText());
                equipo.setInstagram(textFieldInstagram.getText());
                equipo.setPatrocinadorPrincipal(textFieldPatrocinador.getText());
                try {
                    service.insertarEquipo(equipo);
                    JOptionPane.showMessageDialog(null, "Equipo agregado exitosamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar el equipo: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        buttonActualizarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                equipo.setIdEquipo(Integer.parseInt(textFieldIdEquipo.getText()));
                equipo.setNombre(textFieldNombreEquipo.getText());
                equipo.setPais(textFieldPais.getText());
                equipo.setCiudad(textFieldCiudad.getText());
                equipo.setEstadio(textFieldEstadio.getText());
                equipo.setFundacion(Integer.parseInt(textFieldFundacion.getText()));
                equipo.setEntrenador(textFieldEntrenador.getText());
                equipo.setWebOficial(textFieldWeb.getText());
                equipo.setFacebook(textFieldFacebook.getText());
                equipo.setTwitter(textFieldTwitter.getText());
                equipo.setInstagram(textFieldInstagram.getText());
                equipo.setPatrocinadorPrincipal(textFieldPatrocinador.getText());

                try {
                    service.actualizarEquipo(equipo);
                    JOptionPane.showMessageDialog(null, "Equipo actualizado exitosamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al actualizar el equipo: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        buttonEliminarEquipo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idEquipo = Integer.parseInt(textFieldIdEquipo.getText());

                try {
                    service.eliminarEquipo(idEquipo);
                    JOptionPane.showMessageDialog(null, "Equipo eliminado exitosamente");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al eliminar el equipo: " + ex.getMessage());
                    ex.printStackTrace();
                }
            }
        });
        buttonBuscarEquipo.addActionListener(new ActionListener() {
            public void mostrarEquipoEnFormulario(EquipoChampions equipo) {
                textFieldIdEquipo.setText(String.valueOf(equipo.getIdEquipo()));
                textFieldNombreEquipo.setText(equipo.getNombre());
                textFieldPais.setText(equipo.getPais());
                textFieldCiudad.setText(equipo.getCiudad());
                textFieldEstadio.setText(equipo.getEstadio());
                textFieldFundacion.setText(String.valueOf(equipo.getFundacion()));
                textFieldEntrenador.setText(equipo.getEntrenador());
                textFieldWeb.setText(equipo.getWebOficial());
                textFieldFacebook.setText(equipo.getFacebook());
                textFieldTwitter.setText(equipo.getTwitter());
                textFieldInstagram.setText(equipo.getInstagram());
                textFieldPatrocinador.setText(equipo.getPatrocinadorPrincipal());
            }
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreBusqueda = JOptionPane.showInputDialog("Ingrese el nombre del equipo a buscar:");
                if (nombreBusqueda != null && !nombreBusqueda.isEmpty()) {
                    try {
                        List<EquipoChampions> equipos = service.obtenerTodosLosEquipos();

                        EquipoChampions equipoEncontrado = equipos.stream()
                                .filter(eq -> eq.getNombre().toLowerCase().contains(nombreBusqueda.toLowerCase()))
                                .findFirst()
                                .orElse(null);

                        if (equipoEncontrado != null) {
                            mostrarEquipoEnFormulario(equipoEncontrado);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró ningún equipo con ese nombre", "Equipo no encontrado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error al buscar el equipo: " + ex.getMessage());
                        ex.printStackTrace();
                    }
                }
            }

        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("frmChampions");
        frame.setContentPane(new Champions().jPanelContainer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JLabel lblNombreEquipo;
    private JLabel lblPais;
    private JLabel lblCiudad;
    private JLabel lblEstadio;
    private JLabel lblFundacion;
    private JLabel lblEntrenador;
    private JLabel lblWeb;
    private JLabel lblFacebook;
    private JLabel lblTwitter;
    private JLabel lblInstagram;
    private JLabel lblPatrocinador;
    private JTextField textFieldNombreEquipo;
    private JTextField textFieldPais;
    private JTextField textFieldCiudad;
    private JTextField textFieldEstadio;
    private JTextField textFieldFundacion;
    private JTextField textFieldEntrenador;
    private JTextField textFieldWeb;
    private JTextField textFieldFacebook;
    private JTextField textFieldTwitter;
    private JTextField textFieldInstagram;
    private JTextField textFieldPatrocinador;
    private JLabel lblIdEquipo;
    private JTextField textFieldIdEquipo;
    private JButton buttonBuscarEquipo;
    private JButton buttonAgregarEquipo;
    private JButton buttonActualizarEquipo;
    private JButton buttonEliminarEquipo;

    private EquipoChampionsService service = new EquipoChampionsService();
    EquipoChampions equipo = new EquipoChampions();
}


