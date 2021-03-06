package appmovie;

//Aqui importamos todas las librerias que encesitamos
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import models.Movie;

//Creamos la clase princiapal
public final class VentanaPelicula extends JFrame {
    
    private JButton atras;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JLabel fondo2;
    
    //Aqui esta el acttion listener del objeto, en etse caso seria "bak"
    ActionListener back;
    
    //Aqui encontramos las instancias tipo Movie, Para que luego lo reciban 
    //los objetos en el constructor pincipal
    Movie peli1;
    Movie peli2;
    Movie peli3;
    Movie peli4;
    Movie peli5;
    
    //Constructor donde estan los parametros de las instancias Movie, 
    //y donde esta toda la estructura de la ventana, y por suepuesto hacemos creacion de objetos tipo,
    //JLAbel,JButton,JTextArea, JTextField, Ademas tenemos la accion de los botones estos botones representan la cartelera de la pelicula,
    //y al presionarlo lo llevara  ala ventana descripcion de la pelicula
    public VentanaPelicula(Movie peli1, Movie peli2, Movie peli3, Movie peli4, Movie peli5){
    
        this.peli1 = peli1;
        this.peli2 = peli2;
        this.peli3 = peli3;
        this.peli4 = peli4;
        this.peli5 = peli5;
        
        setLayout(null);
        
        atras = new JButton("←");
        atras.setBounds(20,20,48,35);
        add(atras);
                
        if(this.peli1 != null) {
            btn1 = new JButton(getImageIcon(peli1.getPicture()));
            btn1.setBounds(130,70,90,135); 
            btn1.addActionListener((ActionEvent e) -> {
                this.navigate(this.peli1);
            });
            add(btn1);
        }
        if(this.peli2 != null) {
            btn2 = new JButton(getImageIcon(peli2.getPicture()));
            btn2.setBounds(130,345,90,135); 
            btn2.addActionListener((ActionEvent e) -> {
                this.navigate(this.peli2);
            });
            add(btn2);
        }
        if(this.peli3 != null) {
            btn3 = new JButton(getImageIcon(peli3.getPicture()));
            btn3.setBounds(465,70,90,135); 
            btn3.addActionListener((ActionEvent e) -> {
                this.navigate(this.peli3);
            });
            add(btn3);
        }
        if(this.peli4 != null) {
            btn4 = new JButton(getImageIcon(peli4.getPicture()));
            btn4.setBounds(465,345,90,135); 
            btn4.addActionListener((ActionEvent e) -> {
                this.navigate(this.peli4);
            });
            add(btn4);
        }
        if(this.peli5 != null) {
            btn5 = new JButton(getImageIcon(peli5.getPicture()));
            btn5.setBounds(300,211,90,135); 
            btn5.addActionListener((ActionEvent e) -> {
                this.navigate(this.peli5);
            });
            add(btn5);
        }
        
        back = (ActionEvent e) -> {
            setVisible(false);  
        };

        atras.addActionListener(back);
        
        //Con el metodo ImageIcon le ponemos fondo a nuestra aplicacion mediante un JLabel,
        //la imagen se encuentra deltro de la carpeta del proyecto para que sea mas facil llamarla
        fondo2 = new JLabel(new ImageIcon("Fondo.jpg"));
        fondo2.setBounds(0,0,800,600);
        add(fondo2);
        
        
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        
    }
    
    public VentanaPelicula() {}
    
    //Metodo para qu elos botones reciban la imagen por url, devuelve tood como imageIcon 
    public ImageIcon getImageIcon(String picture) {
        URL url = null;
        try {
            url = new URL(picture);
        } catch (MalformedURLException ex) {
            return null;
        }

        BufferedImage c = null;
        try {
            c = ImageIO.read(url);
        } catch (IOException ex) {
            return null;
        }

        ImageIcon imageIcon = new ImageIcon(c);
        
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(90, 135,  java.awt.Image.SCALE_SMOOTH);
        
        imageIcon = new ImageIcon(newimg);
        return imageIcon;
    }

    // Accion del boton que llevara a la descripcion de la pelicula 
    public void navigate(Movie movie) {
        
        VentanaDescripcion vd = new VentanaDescripcion(movie);
        vd.setBounds(0,0, 730, 600);
        vd.setVisible(true);
        vd.setResizable(false);
        vd.setBackground(Color.LIGHT_GRAY);
        vd.setLocationRelativeTo(null);
//        this.setVisible(false);
        
    }
    
}