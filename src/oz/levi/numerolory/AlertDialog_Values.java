package oz.levi.numerolory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AlertDialog_Values extends Activity{
	TextView textViewSpirala,textViewSpiralaFinal,textViewYaldot,textViewYaldotFinal,textViewHands,textViewHands2,textViewHandsFinal,textViewHandsFinal2,textViewBagrot,textViewBagrotFinal,textViewHeart;
	TextView textViewHead,textViewHeadFinal,textViewFeet,textViewFeetFinal;
	String num1,num2,num3,num4,num5,num6,num7,num8,num9,num11,num22,num33,num13,num14,num16,num19;
	String Age1 ,Name_Mazal1 ,NumMazal1, information_UserInformation;
	String Spirala,SpiralaFinal,Yaldot,YaldotFinal,Hands,HandsFinal,Hands2,HandsFinal2,Bagrot,BagrotFinal,Heart,Head,HeadFinal,Feet,FeetFinal,Age,Name_Mazal,NumMazal,FirstName,LastName,temp_test1,temp_test2;
	String textViewFirstName,textViewFirstNameFinal,textViewLastName,textViewLastNameFinal,BirthDay_Day,BirthDay_Month,BirthDay_Year;
	String moked,moked_num = null;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_numrology);
		
		
		
		

		//מוקד נפש האדם
        textViewSpirala = ( TextView) findViewById(R.id.textViewSpirala);
		textViewSpiralaFinal = ( TextView) findViewById(R.id.textViewSpiralaFinal);
		
		/*מוקד הילדות*/
		textViewYaldot = ( TextView) findViewById(R.id.textViewYaldot);
		textViewYaldotFinal = ( TextView) findViewById(R.id.textViewYaldotFinal);
		
		
		 //מוקד הידיים
        textViewHands = ( TextView) findViewById(R.id.textViewHands);
		textViewHandsFinal = ( TextView) findViewById(R.id.textViewHandsFinal);
		textViewHands2 = ( TextView) findViewById(R.id.textViewHands2);
		textViewHandsFinal2 = ( TextView) findViewById(R.id.textViewHandsFinal2);
		
		//מוקד הבגרות
        textViewBagrot = ( TextView) findViewById(R.id.textViewBagrot);
        textViewBagrotFinal = ( TextView) findViewById(R.id.textViewBagrotFinal);
        
        
        //מוקד הלב
        textViewHeart = ( TextView) findViewById(R.id.textViewHeart);
        
        //מוקד הראש
        textViewHead = ( TextView) findViewById(R.id.textViewHead);
        textViewHeadFinal = ( TextView) findViewById(R.id.textViewHeadFinal);
        
        //מוקד הרגליים
        textViewFeet = ( TextView) findViewById(R.id.textViewFeet);
        textViewFeetFinal = ( TextView) findViewById(R.id.textViewFeetFinal);
        
        
        
        Intent i = getIntent();
    	// Receiving the Data
        Spirala = i.getStringExtra("Spirala");
        SpiralaFinal = i.getStringExtra("SpiralaFinal");
        Yaldot = i.getStringExtra("Yaldot");
        YaldotFinal = i.getStringExtra("YaldotFinal");
        Hands = i.getStringExtra("Hands");
        HandsFinal = i.getStringExtra("HandsFinal");
        Hands2 = i.getStringExtra("Hands2");
        HandsFinal2 = i.getStringExtra("HandsFinal2");
        Bagrot = i.getStringExtra("Bagrot");
        BagrotFinal = i.getStringExtra("BagrotFinal");
        Heart = i.getStringExtra("Heart");
        Head = i.getStringExtra("Head");
        HeadFinal = i.getStringExtra("HeadFinal");
        Feet = i.getStringExtra("Feet");
        FeetFinal = i.getStringExtra("FeetFinal");
        temp_test1 = i.getStringExtra("temp_test1");
        temp_test2 = i.getStringExtra("temp_test2");
        Age = i.getStringExtra("Age");
        Name_Mazal = i.getStringExtra("Name_Mazal");
        NumMazal = i.getStringExtra("NumMazal");
        FirstName = i.getStringExtra("FirstName");
        LastName = i.getStringExtra("LastName");
        textViewFirstName = i.getStringExtra("textViewFirstName");
        textViewFirstNameFinal = i.getStringExtra("textViewFirstNameFinal");
        textViewLastName = i.getStringExtra("textViewLastName");
        textViewLastNameFinal = i.getStringExtra("textViewLastNameFinal");
        BirthDay_Day = i.getStringExtra("BirthDay_Day");
        BirthDay_Month = i.getStringExtra("BirthDay_Month");
        BirthDay_Year = i.getStringExtra("BirthDay_Year");
        
        // Displaying Received data
        if(Spirala!= null)
        	textViewSpirala.setText(Spirala);
        if(SpiralaFinal!= null)
        	textViewSpiralaFinal.setText(SpiralaFinal);
        if(Yaldot!= null)
        	textViewYaldot.setText(Yaldot);
        if(YaldotFinal!= null)
        	textViewYaldotFinal.setText(YaldotFinal);
        if(Hands!= null)
        	textViewHands.setText(Hands);
        if(HandsFinal!= null)
        	textViewHandsFinal.setText(HandsFinal);
        if(Hands2!= null)
        	textViewHands2.setText(Hands2);
        if(HandsFinal2!= null)
        	textViewHandsFinal2.setText(HandsFinal2);
        if(Bagrot!= null)
        	textViewBagrot.setText(Bagrot);
        if(BagrotFinal!= null)
        	textViewBagrotFinal.setText(BagrotFinal);
        if(Heart!= null)
        	textViewHeart.setText(Heart);
        if(Head!= null)
            textViewHead.setText(Head);
        if(HeadFinal!= null)
            textViewHeadFinal.setText(HeadFinal);
        if(Feet!= null)
            textViewFeet.setText(Feet);
        if(FeetFinal!= null)
            textViewFeetFinal.setText(FeetFinal);
		
		
		
	}
	
	 public void HandsFinal()
	    {
	    	AlertDialog.Builder builder1;
			/*מוקד הידיים ערך*/
			moked = "מוקד הידיים";
	  		 builder1 = new AlertDialog.Builder(this);
	  		if(HandsFinal.equals("1") && !Hands.equals("19"))
	    	{
		   		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num1));
	    	}
	    	if(HandsFinal.equals("2") && !Hands.equals("11"))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num2));
	    	}
	    	if(HandsFinal.equals("3"))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num3));
	    	}
	    	if(HandsFinal.equals("4") && (!Hands.equals("22") && !Hands.equals("13")))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num4));
	    	}
	    	if(HandsFinal.equals("5") && !Hands.equals("14"))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num5));
	    	}
	    	if(HandsFinal.equals("6")  && !Hands.equals("33"))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num6));
	    	}
	    	if(HandsFinal.equals("7") && !Hands.equals("16"))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num7));
	    	}
	    	if(HandsFinal.equals("8"))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num8));
	    	}
	    	if(HandsFinal.equals("9"))
	    	{
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num9));
	    	}
	    	if(Hands.equals("11") || Hands.equals("22") || Hands.equals("33") || Hands.equals("13") || Hands.equals("14") || Hands.equals("16") || Hands.equals("19"))
	    	{
	    		/*להכניס כאן את הפונקציה הנכונה, שלא עובדת*/
	    		builder1.setTitle(R.string.m_hands);
		   		builder1.setMessage((R.string.m_hands_num9));
	    	}
	    	builder1.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
	            public void onClick(DialogInterface dialog, int id) {
	                 dialog.cancel();
	            }
	        });
	    	/*כדי שלא נציג את החלון הסבר, כי אם זה מסטר או קראמתי אז יש 3 אפשרויות*/
	    	if(!Hands.equals("11") && !Hands.equals("22") && !Hands.equals("33") && !Hands.equals("13") && !Hands.equals("14") && !Hands.equals("16") && !Hands.equals("19"))
	    		builder1.show();
	    }
	 


}
