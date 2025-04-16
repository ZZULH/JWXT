package zzdx;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class jsdh {

	public static void main(String ss) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
		Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
		ResultSet r=s.executeQuery("select 姓名,电话 "
    		+ "from 选修,讲授,教师 "
    		+ "where  选修.课程编号=讲授.课程编号 "
    		+ "and 教师.教师编号=讲授.教师编号 "
    		+ "AND 学号= "
    		+ ss);
		String[][] a=new String[10][3];
		int i=0;
        while(r.next())
        {
        	a[i][0]=String.valueOf(i+1);
        	a[i][1]=String.valueOf(r.getString(1)).trim();
        	a[i][2]=String.valueOf(r.getString(2)).trim();
        	i++;
        }
        String[] b= {"行号","教师姓名","教师电话"};
        
        

        JFrame app = new JFrame( "教师电话" );
        app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        app.setVisible( true );
        app.setSize( 500,600);
        Container cc = app.getContentPane( );
        cc.setLayout( null );
        JTable t = new JTable(a,b);

        Font mf = new Font("楷体",Font.CENTER_BASELINE,18);
        t.setRowHeight(20);
        t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        t.getColumnModel().getColumn(0).setPreferredWidth(100);
        t.getColumnModel().getColumn(1).setPreferredWidth(100);
        t.getColumnModel().getColumn(2).setPreferredWidth(200);
        
        
        Color[] rf= {Color.PINK,Color.LIGHT_GRAY,Color.PINK,Color.LIGHT_GRAY,Color.PINK,Color.LIGHT_GRAY,
        		Color.PINK,Color.LIGHT_GRAY,Color.PINK,Color.LIGHT_GRAY};
        setColor(t, rf);
        t.setFont(mf);
        t.setEnabled(false); 
        JScrollPane scr=new JScrollPane(t);
        scr.setBounds(25, 50, 400, 400);
        scr.setFont(mf);
        cc.add(scr);
        
        JButton jb =new JButton("更多");
        jb.setBounds(180, 460, 100, 50);
        jb.setFont(mf);
        jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				more.main();
			}
		});
        cc.add(jb);
	}

	private static void setColor(JTable table,Color[] color) {
		// TODO Auto-generated method stub
		try 
		{
			@SuppressWarnings("serial")
			DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer() 
			{
				@Override
				public Component getTableCellRendererComponent(JTable table,Object value, boolean isSelected, boolean hasFocus,int row, int column) 
				{
					setBackground(color[row]);
					setForeground(Color.WHITE);
					return super.getTableCellRendererComponent(table, value,isSelected, hasFocus, row, column);
	            }
			};
			int columnCount = table.getColumnCount();
			for (int i = 0; i < columnCount; i++)
			{
				table.getColumn(table.getColumnName(i)).setCellRenderer(dtcr);
			}
		} 
		catch (Exception e) 
		{
	            e.printStackTrace();
		}
	}
}