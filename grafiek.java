
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Polygon;
import java.io.IOException;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class grafiek {

    private final int frameHoogte;
    private final JFrame frame;
    private final int schermwijdte;

    public grafiek() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice[] schermen = ge.getScreenDevices();
        GraphicsDevice mijnScherm = schermen[0];
        frameHoogte = mijnScherm.getDisplayMode().getHeight();
        schermwijdte = mijnScherm.getDisplayMode().getWidth();
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("grafiek test");
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setSize(schermwijdte, frameHoogte);
        frame.add(new MyPanel());
        frame.setVisible(true);

    }

    public static void main(String[] args) throws IOException {
        grafiek xygrafiek = new grafiek();
    }
}

class MyPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

//        int[] x = new int[]{10, 11, 12, 13};
//        int[] y = new int[]{10, 50, 200, 100};
        g.setColor(Color.RED);
//        g.drawPolygon(x, y, x.length);
        Random randomNum = new Random();
        Polygon poly = new Polygon();
        int vorigeX = 0, vorigeY = 0;
        for (int i = 1; i < 200; i++) {
            int x = i;
            int y = 1 + randomNum.nextInt(400);
            g.drawLine(vorigeX, vorigeY, x, y);
            vorigeX = x;
            vorigeY = y;
            poly.addPoint(i, y);
        }

//        g.drawLine(poly.xpoints, WIDTH, WIDTH, WIDTH);drawPolygon(poly);
    }

    //so our panel is the corerct size when pack() is called on Jframe
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}
