package appmovie;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.UUID;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import models.Cast;
import models.Movie;
import requests.Requests;

public class VentanaActoresDirect extends JFrame {

    final Requests requests = new Requests();

    //Etiquetas
    private JLabel labelTittleDatos;
    private JLabel labelDatoNombreParticipante;
    private JLabel labelNombrePart;
    private JLabel labelCantidadPeli;
    private JLabel labelCantidadPeliDiri;
    private JLabel labelIdPelicula;
    private JLabel labelRolPeli;
    

    //Botones
    private JButton btonGuardainfo;

    private JButton btonBorrarInfo;
    private JButton btonRegresar;

    public JTextField cjaNombrePart;
    private JTextField cjaNacionalidadPart;
    private JTextField cjaPeliAct;
    private JTextField cjaPeliDiri;
    private JTextField cjaPeliRol;

    private ActionListener oyente1;
    private ActionListener oyente2;
    private ActionListener oyente3;

    @SuppressWarnings("OverridableMethodCallInConstructor")
    public VentanaActoresDirect() {

        setTitle("ALMACENAJE DE DATOS DE PARTICIPANTES EN LA PELÍCULA");

        Componentes3();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void Componentes3() {

        //Panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setLayout(null);

        //Etiquetas
        labelTittleDatos = new JLabel("ALMACENA LOS DATOS DE LOS ACTORES");
        labelTittleDatos.setForeground(Color.BLACK);
        labelTittleDatos.setBounds(220, -18, 800, 100);

        labelIdPelicula = new JLabel("");
        labelIdPelicula.setForeground(Color.BLACK);
        labelIdPelicula.setVisible(false);
        labelIdPelicula.setBounds(500, 210, 200, 150);

        final DefaultListModel<Movie> movies = requests.getAllMovies();

        final ListBox listBox = new ListBox(movies, labelIdPelicula);

        listBox.viewComponents();

        labelDatoNombreParticipante = new JLabel("Nombre");
        labelDatoNombreParticipante.setForeground(Color.BLACK);
        labelDatoNombreParticipante.setBounds(20, 19, 800, 100);

        labelNombrePart = new JLabel("Nacionalidad");
        labelNombrePart.setForeground(Color.BLACK);
        labelNombrePart.setBounds(20, 90, 800, 100);

        labelCantidadPeli = new JLabel("Cantidad de películas en que actuó ");
        labelCantidadPeli.setForeground(Color.BLACK);
        labelCantidadPeli.setBounds(20, 150, 800, 100);

        labelCantidadPeliDiri = new JLabel("Cantidad de películas que dirigió");
        labelCantidadPeliDiri.setForeground(Color.BLACK);
        labelCantidadPeliDiri.setBounds(20, 210, 800, 100);

        labelRolPeli = new JLabel("Rol en la película");
        labelRolPeli.setForeground(Color.BLACK);
        labelRolPeli.setBounds(20, 280, 800, 100);        

        //Botones
        btonGuardainfo = new JButton("GUARDAR INFORMACIÓN");
        btonGuardainfo.setBounds(20, 480, 160, 60);

        btonBorrarInfo = new JButton("BORRAR INFORMACIÓN");
        btonBorrarInfo.setBounds(360, 480, 160, 60);

        btonRegresar = new JButton("REGRESAR");
        btonRegresar.setBounds(560, 480, 100, 60);

        cjaNombrePart = new JTextField();
        cjaNombrePart.setBounds(20, 80, 300, 40);

        cjaNacionalidadPart = new JTextField();
        cjaNacionalidadPart.setBounds(20, 150, 300, 40);

        cjaPeliRol = new JTextField();
        cjaPeliRol.setBounds(20, 340, 300, 40);

        cjaPeliAct = new JTextField();
        cjaPeliAct.setBounds(20, 210, 300, 40);

        cjaPeliDiri = new JTextField();
        cjaPeliDiri.setBounds(20, 276, 300, 40);

        panel.add(labelTittleDatos);
        panel.add(labelDatoNombreParticipante);
        panel.add(labelNombrePart);
        panel.add(labelCantidadPeli);
        panel.add(labelCantidadPeliDiri);
        panel.add(labelRolPeli);
        
//      panel.add(labelIdPelicula);

        panel.add(btonGuardainfo);

        panel.add(btonBorrarInfo);
        panel.add(btonRegresar);

        panel.add(cjaNombrePart);
        panel.add(cjaNacionalidadPart);
        panel.add(cjaPeliAct);
        panel.add(cjaPeliDiri);
        panel.add(cjaPeliRol);
        panel.add(listBox.scrollPane);

        //Datos de la ventana
        this.setSize(700, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(rootPaneCheckingEnabled);
        this.setResizable(false);

        oyente1 = (ActionEvent e) -> {

            if (labelIdPelicula.getText().length() == 0) {
                // TODO: COLOCAR ALERTA DE SELECCIONAR PELICULA ES OBLIGATORIO
                return;
            }

            final Cast cast = new Cast();
            final String uuid = UUID.randomUUID().toString().replace("-", "");

            cast.setId(uuid);
            cast.setName(cjaNombrePart.getText());
            cast.setMovie_id(labelIdPelicula.getText());
            cast.setNationality(cjaNacionalidadPart.getText());
            cast.setActed_movies(Integer.parseInt(cjaPeliAct.getText()));
            cast.setDiriged_movies(Integer.parseInt(cjaPeliDiri.getText()));
            cast.setRole(cjaPeliRol.getText());

            this.requests.saveCast(cast);
            
            // TODO: COLOCAR ALERTA DE ACTOR GUARDADO
        };

        btonGuardainfo.addActionListener(oyente1);

        oyente2 = (ActionEvent e) -> {
            
            // TODO: LIMPIAR CAMPOS
        };

        btonBorrarInfo.addActionListener(oyente2);

        oyente3 = (ActionEvent e) -> {
            VentanaInicial ventan = new VentanaInicial();

            ventan.setVisible(true);
            setVisible(false);
        };
        btonRegresar.addActionListener(oyente3);

    }

}
