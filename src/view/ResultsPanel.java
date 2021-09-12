package view;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ResultsPanel extends JPanel{
    private JTable tblResults;
    private JScrollPane jspPane;
    private URL url = getClass().getResource("/images/viajes.jpg");
    Image image = new ImageIcon(url).getImage();

    public ResultsPanel(){
        initComponents();
        this.setOpaque(false);
    }

    @Override
    public void paint(Graphics g){
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
        //g.s(false);
        super.paint(g);
    }


    private void initComponents(){
        this.tblResults = new JTable();
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        this.jspPane = new JScrollPane(this.tblResults);
        jspPane.setPreferredSize(new Dimension(500, 200));
        add(jspPane, BorderLayout.CENTER);

        setPreferredSize(new Dimension(1020, 800));
    }

    public JTable getTblResults() {
        return tblResults;
    }


    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
}
