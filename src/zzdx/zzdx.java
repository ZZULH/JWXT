package zzdx;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class zzdx
{
	public static void main(String s1,String s2)
	{
		try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection c=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=zzdx","sa","2292633789ly");
            Statement s=c.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet r=s.executeQuery("select ѧ��,����,���� "
            		+ "from ѧ�� "
            		+ "where ѧ��="
            		+ s1
            		+ ";");
            if(r.next())
            {
//            	System.out.println(s2);
//            	System.out.println(r.getString("����"));
            	if(s2.trim().equals(r.getString("����").trim()))
            	{
            		success.main(r.getString("ѧ��").trim(),r.getString("����").trim());
            	}
            	else
            	{
            		error.main(1);
            	}
            }
            else
            {
            	error.main(1);
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