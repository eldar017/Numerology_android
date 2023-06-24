package oz.levi.numerolory;


public class FuncCalc {
		
	//פונקציה לפירוק השמות וכל המוקדים
	public int pirokAll(int num)
	{
		//אם המוקד הוא מספר קראמטי אז לא לבצע פירוק של המספר, ולהחזיר את המספר שהתקבל
        if ((num == 13) || (num == 14) || (num == 16) || (num == 19) || (num == 11) || (num == 22) || (num == 33))
        	return num;
        
		int temp;
		int sum = 0;

		temp = num;
		while (temp != 0)
		{
			sum += temp % 10;
			temp /= 10;
		}
		if (sum > 9)
		{
			if ((sum == 13) || (sum == 14) || (sum == 16) || (sum == 19) || (sum == 11) || (sum == 22) || (sum == 33))
	        	return sum;
			temp = sum;
			sum = 0;
			while (temp != 0)
			{
				sum += temp % 10;
				temp /= 10;
			}
		}
		return sum;
	}
	
	//פונקציה לחישוב הסופי של כל אחד מהמוקדים
	public int pirokFinal(int num)
	{
		int temp;
		int sum = 0;

		temp = num;
		while (temp != 0)
		{
			sum += temp % 10;
			temp /= 10;
		}
		if (sum > 9)
		{
			if ((sum == 13) || (sum == 14) || (sum == 16) || (sum == 19) || (sum == 11) || (sum == 22) || (sum == 33))
	        	return sum;
			temp = sum;
			sum = 0;
			while (temp != 0)
			{
				sum += temp % 10;
				temp /= 10;
			}
		}
		return sum;
	}
}