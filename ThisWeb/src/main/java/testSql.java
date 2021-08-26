import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class testSql {
	public static void main(String args[]) {
	      Connection c = null;
	      Statement stmt = null;
	      try {
	    	 //PostgreSQL Drivers 
	         Class.forName("org.postgresql.Driver");
	         
	         //Logging information
	         c = DriverManager
	            .getConnection("jdbc:postgresql://localhost:8005/test_library",
	            "postgres", "1234");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         //Insert data to PostgreSQL
	         stmt = c.createStatement();
	         String sql = "INSERT INTO calculate_record (CURRENCY,RATE,PRICE,DISCOUNT,RESULT) "
	               + "VALUES ('NTD', 100, 100, 100, 100 );";
	         stmt.executeUpdate(sql);

	         stmt.close();
	         c.commit();
	         c.close();
	      } catch (Exception e) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
	      System.out.println("Records created successfully");
	   }
}
