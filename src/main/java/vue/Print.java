package vue;

public class Print {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 String s1 = "Test1";
	        String s2 = "Test1";
	        String s3 = new String("Test1");
	        String s4 = String.valueOf("Test1");

	        System.out.println(s1 == s2);
	        System.out.println(s2 == s3);
	        System.out.println(s3 == s4);
	        System.out.println(s1 == s4);
	}

}
