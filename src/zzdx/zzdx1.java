package zzdx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class zzdx1 {

	public static void main(String s1, String s2) {
		// TODO Auto-generated method stub
		try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
            Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select ��ʦ���,����,���� "
            		+ "from ��ʦ "
            		+ "where ��ʦ���="
            		+ s1
            		+ ";");
            if(r.next())
            {
            	if(s2.trim().equals(r.getString("����").trim()))
            	{
            		success1.main(r.getString("��ʦ���").trim(),r.getString("����").trim());
            	}
            	else
            	{
            		error.main(2);
            	}
            }
            else
            {
            	error.main(2);
            }
            s.close( );
            c.close( );
        }
        catch (Exception e)
        {
            System.err.println("�쳣: " + e.getMessage( ));
        } // try-catch�ṹ����
	}

}
