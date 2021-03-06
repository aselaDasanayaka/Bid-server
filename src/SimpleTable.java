import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;

/*
*  This class use to draw histroy tables
*
*
*/
public class SimpleTable extends JPanel {
	
        public static String SM = null;
        private JTable table;
        
        public SimpleTable() {
                super(new GridLayout(1,0));
                int i=0;
                String[] columnNames = {"Name","Symbol","Bid"};
                
                if(SM.equals("FB")){
                	int size = Data.fb.size();
                	String [][] data = new String [size][3];
                	
                	for (His h : Data.fb){
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                else if (SM.equals("GOOGL")){
                	int size = Data.googl.size();
                	String [][] data = new String [size][3];
                	
                	for (His h : Data.googl){
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                else if (SM.equals("MSFT")){
                	int size = Data.msft.size();
                	String [][] data = new String [size][3];
                	
                	for (His h : Data.msft){
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                else if (SM.equals("TSLA")){
                	int size = Data.tsla.size();
                	String [][] data = new String [size][3];
                	
                	for (His h : Data.tsla){
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                else if (SM.equals("TXN")){
                	int size = Data.txn.size();
                	String [][] data = new String [size][3];
                	System.out.println(" "+ size );
                	for (His h : Data.txn){
                	
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                else if (SM.equals("VRTU")){
                	int size = Data.vrtu.size();
                	String [][] data = new String [size][3];
                	
                	for (His h : Data.vrtu){
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                else if (SM.equals("XLNX")){
                	int size = Data.xlnx.size();
                	String [][] data = new String [size][3];
                	
                	for (His h : Data.xlnx){
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                else if (SM.equals("YHOO")){
                	int size = Data.yhoo.size();
                	String [][] data = new String [size][3];
                	
                	for (His h : Data.yhoo){
                		data[i][0] = h.getName();
                		data[i][1] = h.getSymbol();
                		data[i][2] = Double.toString(h.getBid());
                		i++;
                	}
                    this.table = new JTable(data, columnNames);
                    this.table.setPreferredScrollableViewportSize(new Dimension(300, 100));
                    this.table.setFillsViewportHeight(true);
                }
                
                //Create the scroll pane and add the table to it.
                JScrollPane scrollPane = new JScrollPane(table);

                //Add the scroll pane to this panel.
                add(scrollPane);
                
                JFrame frame = new JFrame("Histroy Details");
                this.setOpaque(true);
                frame.setContentPane(this);
                frame.pack();
                frame.setVisible(true);       
        }

}
