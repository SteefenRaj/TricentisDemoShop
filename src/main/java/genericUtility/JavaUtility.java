package genericUtility;

import java.util.Random;

public class JavaUtility {

	public static int generateRandomNumber()
	{
		Random random = new Random();
		int number = random.nextInt(2000);
		return number;
	}
}
