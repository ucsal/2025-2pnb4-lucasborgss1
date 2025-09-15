package br.com.mariojp.figureeditor;

import br.com.mariojp.figureeditor.factory.CircleFactory;
import br.com.mariojp.figureeditor.factory.SquareFactory;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception ignored) {}

            JFrame frame = new JFrame("Figure Editor — Clique para inserir figuras");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            DrawingPanel panel = new DrawingPanel();

            JToolBar toolbar = getJToolBar(panel, frame);

            frame.setLayout(new BorderLayout());
            frame.add(toolbar, BorderLayout.NORTH);
            frame.add(panel, BorderLayout.CENTER);

            frame.setSize(900, 600);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    private static JToolBar getJToolBar(DrawingPanel panel, JFrame frame) {
        JToolBar toolbar = new JToolBar();

        JButton circleBtn = new JButton("Círculo");
        circleBtn.addActionListener(e -> panel.setFactory(new CircleFactory()));
        JButton squareBtn = new JButton("Quadrado");
        squareBtn.addActionListener(e -> panel.setFactory(new SquareFactory()));
        JButton clearBtn = new JButton("Limpar");
        clearBtn.addActionListener(e -> panel.clear());

        JButton blueBtn = new JButton("Azul");
        blueBtn.addActionListener(e -> panel.setCurrentColor(new Color(30, 144, 255)));

        JButton redBtn = new JButton("Vermelho");
        redBtn.addActionListener(e -> panel.setCurrentColor(Color.RED));

        JButton greenBtn = new JButton("Verde");
        greenBtn.addActionListener(e -> panel.setCurrentColor(Color.GREEN));

        JButton blackBtn = new JButton("Preto");
        blackBtn.addActionListener(e -> panel.setCurrentColor(Color.BLACK));

        JButton customBtn = new JButton("Cor personalizada");
        customBtn.addActionListener(e -> {
            Color chosen = JColorChooser.showDialog(frame, "Escolha uma cor", Color.BLACK);
            if (chosen != null) {
                panel.setCurrentColor(chosen);
            }
        });

        toolbar.add(circleBtn);
        toolbar.add(squareBtn);
        toolbar.add(clearBtn);
        toolbar.addSeparator();
        toolbar.add(blueBtn);
        toolbar.add(redBtn);
        toolbar.add(greenBtn);
        toolbar.add(blackBtn);
        toolbar.add(customBtn);

        return toolbar;
    }
}
