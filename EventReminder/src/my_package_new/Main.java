package my_package_new;

public class Main {

	public static void main(String[] args) {

		View v=new View();
		v.createGui();
		
		MyDatabase db=new MyDatabase();
		db.createDatabase();
		
		v.poredjenje();
	}

}