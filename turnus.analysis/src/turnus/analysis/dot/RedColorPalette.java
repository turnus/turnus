package turnus.analysis.dot;

import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RedColorPalette {

	public static void main(String[] args) {
        int numColors = 100;
        int width = 20;
        int height = numColors * 20;

        BufferedImage palette = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < numColors; i++) {
            float hue = i / (float) (numColors - 1) * 120; // Adjust hue for the transition from red to green
            Color color = createRedToOrangeToGreenColor(hue);
            int rgb = color.getRGB();

            for (int y = i * 20; y < (i + 1) * 20; y++) {
                for (int x = 0; x < width; x++) {
                    palette.setRGB(x, y, rgb);
                }
            }
        }

        JFrame frame = new JFrame("Red to Orange to Green Palette");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(java.awt.Graphics g) {
                super.paintComponent(g);
                g.drawImage(palette, 0, 0, null);
            };
        };
        frame.add(panel);
        frame.setVisible(true);
    }

    public static Color createRedToOrangeToGreenColor(float hue) {
        return Color.getHSBColor(hue / 360.0f, 1.0f, 1.0f);
    }
}