package databse;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
public class DatabasaConnectivity {

    	public static void main(String[] args) throws Exception {
		String url="jdbc:mysql://localhost:3306/testcode";
		String uname="root";
		String pass="";
		String query="select *from stdcode";
		String name="";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con=DriverManager.getConnection(url,uname,pass);
	   Statement st=con.createStatement();
	   ResultSet rs=st.executeQuery(query);
	   
	   if(rs.isBeforeFirst()) {
	   while(rs.next()) // ResultSet next() function is used to move the pointer to the next row.
	   {
	   name=rs.getInt("id")+" "+rs.getString("name")+" "+rs.getString("email");
	   System.out.println(name);
	   }
	   }else {
		   System.out.println("Not available ");
	   }
	   
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	   System.out.println("Enter your chose ");
	   System.out.print("1. Insert data into the database  \n");
	   System.out.print("2. Update the data in the database \n");
	   System.out.print("3. Exit  \n");
	   System.out.print("5. Delete the data from the database \n");
	  while(true) {
		  int inpt=Integer.parseInt(br.readLine());
		  switch(inpt) {
		  case 1:
			  System.out.print("Enter the data(name,email) to be inserted ");
			  String nam=br.readLine();
			  String email=br.readLine();
			  String qry = "INSERT INTO stdcode(name, email) VALUES ('" + nam + "', '" + email + "')";
			  int count=st.executeUpdate(qry);
			  
			  System.out.print(count+" rows are updated\n");
			 
			  break;
		  case 2:
			  
			  break;
			  //String query_up="";
		  case 3:
			  System.exit(1);
			
		  case 4:
			  st.close();
			  con.close(); 
			  break;
		  }
	  }
	   
	   
	   //st.close();
	   //con.close();
	}

}
