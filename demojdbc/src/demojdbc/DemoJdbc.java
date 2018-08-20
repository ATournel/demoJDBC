package demojdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DemoJdbc {

	public void recupererMesDonnees() {
		String url = "jdbc:mysql://localhost/formation";
		String user = "root";
		String pwd = "Ioplop88";
		
		Connection cn = null;
		Statement st = null;
		
		//connexion avec le driver
		try {
			//chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver ok! :p ");
			
			//recuperation de la connexion			
			cn = DriverManager.getConnection(url, user, pwd);
			
			//creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM formation.personne";
			
			//execution de la requete
			ResultSet result = st.executeQuery(sql);
			
			int id;
			String nom;
			String prenom;
			String noVol;
			while (result.next()) {
				//recuperer l' "id"
				id = result.getInt("id");
				//recuperer le "Prenom"
				prenom = result.getString("prenom");
				//recuperer le "Nom"
				nom = result.getString("nom");
				//recuperer le n°Vol
				noVol = result.getString("flightno");
				
				System.out.println(id +" > "+ nom +" "+ prenom +" has taken flight n° : "+ noVol);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
				st.close();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		//Connexion avec le server mySQL
		
		DemoJdbc c = new DemoJdbc();
		c.recupererMesDonnees();

	}

}
