package initial;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.File;
import java.lang.ref.Cleaner;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.sourceforge.tess4j.Tesseract;

public class ProcessandoImagens {

    Rectangle captureRect;

    //Método construtor
    ProcessandoImagens(final BufferedImage screen) { //Cria um buffer de Imagem e seleciona altura, largura, tipo
        final BufferedImage screenCopy = new BufferedImage(
                screen.getWidth(),
                screen.getHeight(),
                screen.getType());
 
		
        final JLabel screenLabel = new JLabel(new ImageIcon(screenCopy)); //Cria uma lebal e passa a imgem selecionada
        JScrollPane screenScroll = new JScrollPane(screenLabel); //Cria um scroll na tela

        //Dimenssões de tela
        screenScroll.setPreferredSize(new Dimension(
                (int)(screen.getWidth()/1.9),
                (int)(screen.getHeight()/1.9)));
		
        JPanel panel = new JPanel(new BorderLayout());//Cria um panel
        panel.add(screenScroll, BorderLayout.CENTER);//adiciona a imgem ao panel
                
		final JLabel selectionLabel = new JLabel("Arraste um retângulo para captura de tela!!");
        panel.add(selectionLabel, BorderLayout.SOUTH);

        repaint(screen, screenCopy);
        screenLabel.repaint();

        screenLabel.addMouseMotionListener(new MouseMotionAdapter() {//Ação do Mouse

            Point start = new Point();//Um ponto que representa um local no espaço de coordenadas (x, y)

            @Override
            public void mouseMoved(MouseEvent me) {//é chamado quando o mouse é mouse de localização.
                start = me.getPoint();//Capturando coordenadas X e Y
                repaint(screen, screenCopy);
                selectionLabel.setText("Ponto de inicio X e Y: " + start);//Print o texto e as coordenadas de X e Y no frame
                screenLabel.repaint();
            }

            @Override
            public void mouseDragged(MouseEvent me) {//é chamado quando o mouse é arrastado
                Point end = me.getPoint();//Capturando coordenadas X e Y
                captureRect = new Rectangle(start, //especifica uma área em um espaço de coordenadas (x,y) largura e sua altura.
                        new Dimension(end.x-start.x, end.y-start.y));//largura e altura como parametro
                repaint(screen, screenCopy);
                screenLabel.repaint();
                selectionLabel.setText("Retangulo Capturado: " + captureRect);
            }
        });

        JOptionPane.showMessageDialog(null, panel);//é uma classe que possibilita a criação de uma caixa de dialogo padrão

        //System.out.println("Retangulo capturada: " + captureRect);
        
        try {
        	Robot robot = new Robot();
        	BufferedImage bi = robot.createScreenCapture(captureRect); // Captura o screen shot da área da tela, tbm pode ser passado um valor fixo no lugar do captureSize
			ImageIO.write(bi, "jpg", new File("./src/main/resources/teste.jpg")); //Caminho onde as capturas são salvas
			

	        File imageFile = new File("./src/main/resources/teste.jpg"); //Instanciando um objeto File e passando o caminho da captura da tela
	        Tesseract tess4j = new Tesseract(); //Instanciando um objeto Tesseract
	        tess4j.setTessVariable("user_defined_dpi", "300"); //definindo uma resolução padrão para a imagem
	        tess4j.setDatapath("");//Caminho no disco C: onde o Tesseract está instalado
	        tess4j.setLanguage("por"); //Setando o idioma Portugues
	        String result = tess4j.doOCR(imageFile); //Usando o tesseract para ler a imagem capturada e atibuindo a variavel result
	        System.out.println(result); //Printando o resultado da leitura
	        
		} catch (Exception e) {
			e.printStackTrace();
		}
        
    }

    //Desenhar na tela
    public void repaint(BufferedImage orig, BufferedImage copy) {
        Graphics2D g = copy.createGraphics();
        g.drawImage(orig,0,0, null);
        if (captureRect!=null) {
            g.setColor(Color.RED);
            g.draw(captureRect);
            g.setColor(new Color(255,255,255,150));
            g.fill(captureRect);
        }
        g.dispose();
    }

    public static void main(String[] args) throws Exception {
        Robot robot = new Robot();
        final Dimension screenSize = Toolkit.getDefaultToolkit().
                getScreenSize();
        final BufferedImage screen = robot.createScreenCapture(
                new Rectangle(screenSize));

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ProcessandoImagens(screen);
            }
        });
    }
    
}