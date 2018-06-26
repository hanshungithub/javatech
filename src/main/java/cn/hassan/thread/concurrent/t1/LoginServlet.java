package cn.hassan.thread.concurrent.t1;

public class LoginServlet {
	private static String usernameRef;
	private static String passwordRef;

	public static void doPost(String username,String password){
		try {
			usernameRef = username;
			if (username.equalsIgnoreCase("a")) {
				Thread.sleep(5000);
			}
			passwordRef = password;
			System.out.println("username --->" + usernameRef +",password ---> " +passwordRef);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
