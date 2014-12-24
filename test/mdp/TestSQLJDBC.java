/**  
 * @Title: TestSQLJDBC.java 
 * @Package mdp 
 * @Description: TODO 
 * @author Rock King 2014年12月17日 下午9:56:39
 * @version V1.0  
 */ 
package mdp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/** 
 * @Description: TODO
 * @author Rock King 2014年12月17日 下午9:56:39 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class TestSQLJDBC {

	private Connection conn;
	private Statement smt;
	private String uid = "sa";
	private String pwd = "password";
	
	public static void main(String[] args) throws Exception {
		String url = "jdbc:sqlserver://127.0.0.1:1433;databaseName=Stu_db2;user=sa;password=sur0ckKingOa";//sa身份连接    
        // Declare the JDBC objects.    
        Connection con = null;    
        Statement stmt = null;    
        ResultSet rs = null;    
    
        System.out.println("begin...");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		con = DriverManager.getConnection(url);
		System.out.println("end...");
		
		
	}
	
	
}
