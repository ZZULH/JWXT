package zzdx;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ckcj 
{
	public static void setColor(JTable table,Color[] color) 
	{
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
	
	public static void main(String ss)
	{
		String[][] a=new String[10][4];
		try
		{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
            Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select 课程.课程编号,课程名,成绩 "
            		+ "from 课程,选修 "
            		+ "where  课程.课程编号=选修.课程编号 "
            		+ "AND 学号= '"+ ss+"';");
            int i=0;
            int g=0;
            while(r.next())
            {
            	a[i][0]=String.valueOf(i+1);
            	a[i][1]=String.valueOf(r.getString(1)).trim();
            	a[i][2]=String.valueOf(r.getString(2)).trim();
            	if(r.getInt(3)==0)
            	{
            		a[i][3]=String.valueOf("null");
            	}
            	else
            	{
            		if(r.getInt(3)<60)
            		{
            			g++;
            		}
            		a[i][3]=String.valueOf(r.getInt(3)).trim();
            	}
            	
            	i++;
            }
            
            String[] b= {"行号","课程编号","课程名","分数"};

         
            JFrame app = new JFrame( "查看成绩" );
            app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            app.setVisible( true );
            app.setSize( 500,600);
            Container cc = app.getContentPane( );
            cc.setLayout( null );
            Font mf = new Font("楷体",Font.CENTER_BASELINE,18);
            
            
            JTable t = new JTable(a,b);
            t.setRowHeight(20);
            t.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
            t.getColumnModel().getColumn(0).setPreferredWidth(40);
            t.getColumnModel().getColumn(1).setPreferredWidth(70);
            t.getColumnModel().getColumn(2).setPreferredWidth(280);
            t.getColumnModel().getColumn(3).setPreferredWidth(60);
            
//            
//            DefaultTableCellRenderer bgc = new DefaultTableCellRenderer();   
//            
//     
//            bgc.setBackground(Color.yellow);   
//     
//            t.getColumnModel().getColumn(2).setCellRenderer(bgc);   
            
            
            Color[] rf= {Color.PINK,Color.LIGHT_GRAY,Color.PINK,Color.LIGHT_GRAY,Color.PINK,Color.LIGHT_GRAY,
            		Color.PINK,Color.LIGHT_GRAY,Color.PINK,Color.LIGHT_GRAY};
            setColor(t, rf);
            t.setFont(mf);
            t.setEnabled(false); 
            JScrollPane scr=new JScrollPane(t);
            scr.setBounds(25, 50, 450, 400);
            scr.setFont(mf);
            cc.add(scr);
            if(g>0)
            {
            	String gh="很遗憾，你有"+g+"门课程未及格。";
            	JLabel gg=new JLabel( gh);
            	gg.setFont(mf);
            	gg.setBounds(20, 500, 300, 20);
            	cc.add(gg);
            }
            else
            {
            	String gh="恭喜你通过全部考试。";
            	JLabel gg=new JLabel( gh );
            	gg.setFont(mf);
            	gg.setBounds(20, 500, 300, 20);
            	cc.add(gg);
            }  
		}
        catch (Exception e)
        {
            System.err.println("异常: " + e.getMessage( ));
        } // try-catch结构结束
	}
}