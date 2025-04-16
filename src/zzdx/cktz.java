package zzdx;

import java.awt.Container;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class cktz 
{
	public static int rf(Container cc, String sss,String ss,int i) 
	{
        String pathname = "D:\\app\\eclipse\\workspace\\lin\\src\\zzdx\\"+sss+".txt"; 
        try (FileReader reader = new FileReader(pathname);BufferedReader br = new BufferedReader(reader) ) 
        {
            Font mf = new Font("楷体",Font.CENTER_BASELINE,18);
            String line;
            int ef=0;

            
            while ((line = br.readLine()) != null) 
            {
            	if(ef==0)
	            {
            		JLabel l1=new JLabel("--------------------");
		        	l1.setFont(mf);
		        	l1.setBounds(0, i, 500, 20);
		        	cc.add(l1);
		        	i=i+20;
            		JLabel l=new JLabel(ss+"老师:");
		        	l.setFont(mf);
		        	l.setBounds(0, i, 500, 20);
		        	cc.add(l);
		        	i=i+20;
            	}
            	ef=1;
            	JLabel l2=new JLabel(line);
            	l2.setFont(mf);
            	l2.setBounds(0, i, 500, 20);
            	cc.add(l2);
            	i=i+20;
            }
            if(ef==1)
            {
            	JLabel l3=new JLabel("--------------------");
	        	l3.setFont(mf);
	        	l3.setBounds(0, i, 500, 20);
	        	cc.add(l3);
	        	i=i+20;
            }
	            
        } 
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return i;
    }
	public static void main(String ss) 
	{
		// TODO Auto-generated method stub
		try 
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
			Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet r=s.executeQuery("select 教师.教师编号,姓名 "
        		+ "from 选修,讲授,教师 "
        		+ "where  选修.课程编号=讲授.课程编号 "
        		+ "and 教师.教师编号=讲授.教师编号 "
        		+ "AND 学号= "
        		+ ss);
			String[] ab=new String [10];
			String[] cd=new String [10];
			int i=0;
			while(r.next())
			{
				if(r.getString(1)!=null)
				{
					ab[i]=String.valueOf(r.getString(1)).trim();
					cd[i]=String.valueOf(r.getString(2)).trim();
					i++;
				}
			}
			
			
			
			JFrame app = new JFrame( "查看通知" );
            app.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            app.setVisible( true );
            app.setSize( 500,600);
            Container cc = app.getContentPane( );
            cc.setLayout( null );
            
            
            
            
            int gh=0;
            for(int ii=0;ii<i;ii++)
            {
            	gh=rf(cc,ab[ii],cd[ii],gh);
            }
            
            
            
            
		} 
		catch (ClassNotFoundException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

}
