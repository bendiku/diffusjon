package bennjo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Grensesnitt extends JPanel {

    private final int størrelse;
    private final int margin;

    private static final Color VANN_RUTE_FARGE = new Color(17, 75, 252);
    private static final Color RUTER_BAKGRUNNSFARGE = new Color(210, 210, 210);
    private static final Color BAKGRUNNSFARGE = Color.WHITE;

    private final int ruteStørrelse;
    private final int gridSize;

    private Rute[] ruter;
    private int valgtRute;

    public Grensesnitt(int størrelse, int dimension, int margin){
        this.størrelse = størrelse;
        this.margin = margin;

        gridSize = (dimension - 2 * margin);
        ruteStørrelse = gridSize / størrelse;

        setPreferredSize(new Dimension(dimension, dimension + margin));
        setBackground(BAKGRUNNSFARGE);
        setForeground(RUTER_BAKGRUNNSFARGE);

        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e){
                valgtRute = mouseInteraction(e);
                if(valgtRute != -1){


                }
                System.out.println("updated");
                // updateBoard();
            }
        });
    }

    /**
     *
     * @param size
     * @return
     */
    public static Grensesnitt lagNyttGrensesnitt(int size, Rute[] ruter) {
        Grensesnitt gui = new Grensesnitt(size, 550, 30);
        gui.ruter = ruter;
        settKoordinaterTilRuter(ruter, gui.størrelse, gui.margin, gui.ruteStørrelse);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setTitle("Game of Diffusjon");
            frame.setResizable(false);
            frame.add(gui, BorderLayout.CENTER);
            frame.pack();
            // center on the screen
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
        return gui;
    }

    private void drawGrid(Graphics2D g) {
        boolean altnate = true;
        int tileSquare = 16;
        g.setFont(getFont().deriveFont(Font.BOLD,56));
        for (int i = 0; i < ruter.length; i++) {

            if(valgtRute == ruter[i].getRuteID()){
                // fremhevetRute = i;
                System.out.println("valgt rute: " + i);
            }

            g.fillRect(ruter[i].getKoordinat().getX(), ruter[i].getKoordinat().getY(), ruteStørrelse, ruteStørrelse);
            g.setColor(Color.BLACK);
            g.drawRect(ruter[i].getKoordinat().getX(), ruter[i].getKoordinat().getY(), ruteStørrelse, ruteStørrelse);
            g.setColor(Color.WHITE);

            // DRAW THE NUMBERS INSTEAD OF PIECES

            // Numbers
            // drawCenteredString(g, String.valueOf(tiles[i].getId()), tiles[i].getX() ,tiles[i].getY());

            // Coords
            // drawCenteredString(g, coords[i], tiles[i].getX() ,tiles[i].getY());

        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawGrid(g2D);
    }

    private static void settKoordinaterTilRuter(Rute[] ruter, int størrelse, int margin, int ruteStørrelse){
        for (Rute rute : ruter){
            int ruteIndeks = rute.getRuteID();
            // we convert 1D coords to 2D coords given the size of the 2D Array
            int r = ruteIndeks / størrelse;
            int c = ruteIndeks % størrelse;

            // Convert coords on the UI
            ruter[ruteIndeks].setKoordinat(new Koordinat(margin + c * ruteStørrelse, margin + r * ruteStørrelse));
        }
    }

    private int mouseInteraction(MouseEvent event){
        int ex = event.getX() - margin;
        int ey = event.getY() - margin;

        // click in the grid ?
        if (ex < 0 || ex > gridSize  || ey < 0  || ey > gridSize)
            return -1;


        // get position in the grid
        int c1 = ex / ruteStørrelse;
        int r1 = ey / ruteStørrelse;

        return  (r1 * størrelse + c1);
    }
}
