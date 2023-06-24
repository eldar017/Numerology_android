
package oz.levi.numerolory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class map_numrology extends Activity {
	TextView textViewSpirala,textViewSpiralaFinal,textViewYaldot,textViewYaldotFinal,textViewHands,textViewHands2,textViewHandsFinal,textViewHandsFinal2,textViewBagrot,textViewBagrotFinal,textViewHeart;
	TextView textViewHead,textViewHeadFinal,textViewFeet,textViewFeetFinal;
	String num1,num2,num3,num4,num5,num6,num7,num8,num9,num11,num22,num33,num13,num14,num16,num19;
	String Age1 ,Name_Mazal1 ,NumMazal1, information_UserInformation,information_Current;
	String Spirala,SpiralaFinal,Yaldot,YaldotFinal,Hands,HandsFinal,Hands2,HandsFinal2,Bagrot,BagrotFinal,Heart,Head,HeadFinal,Feet,FeetFinal,Age,Name_Mazal,NumMazal,FirstName,LastName,temp_test1,temp_test2;
	String textViewFirstName,textViewFirstNameFinal,textViewLastName,textViewLastNameFinal,BirthDay_Day,BirthDay_Month,BirthDay_Year;
	String Personal_year,Personal_month,Personal_day;
	String moked,moked_num = null;
	String address;
	Context ctx=null;
	Button b=null;
	final AlertDialog_Values myAlertDialog_Values = new AlertDialog_Values();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.map_numrology);
		setTitle("מפה נומרולוגית");
		ctx=this;
		final AlertDialog.Builder builder;
		builder = new AlertDialog.Builder(this);
		
		
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
        Personal_year = i.getStringExtra("Personal_year");
        Personal_month = i.getStringExtra("Personal_month");
        Personal_day = i.getStringExtra("Personal_day");
        
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
        
        
        Personal_year = Current(Personal_year);
        Personal_month = Current(Personal_month);
        Personal_day = Current(Personal_day);
        
        
        /*לחיצה על מוקד הידיים בצד ימין*/
        Button invokingButton = (Button)findViewById(R.id.buttonHands);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		HandFunc();
        	}
        });
        
        /*לחיצה על מוקד הידיים בצד שמאל*/
        invokingButton = (Button)findViewById(R.id.buttonHands2);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		HandFunc();
        	}
        });
         
        /*לחיצה על מוקד הראש*/
        invokingButton = (Button)findViewById(R.id.buttonHead);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		HeadFunc();
        	}
        });
        
        /*לחיצה על מוקד ספירלה*/
        invokingButton = (Button)findViewById(R.id.buttonSpirala);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		SpiralaFunc();
        	}
        });
        
        /*לחיצה על מוקד הלב*/
        invokingButton = (Button)findViewById(R.id.buttonHeart);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		HeartFunc();
        	}
        });
        
        /*לחיצה על מוקד הרגליים*/
        invokingButton = (Button)findViewById(R.id.buttonFeet);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		FeetFunc();
        	}
        });
        
        /*לחיצה על מוקד הילדות*/
        invokingButton = (Button)findViewById(R.id.buttonYaldot);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		YaldotFunc();
        	}
        });
        
        /*לחיצה על מוקד הבגרות*/
        invokingButton = (Button)findViewById(R.id.buttonBagrot);
        invokingButton.setOnClickListener(new View.OnClickListener() {     	
        	public void onClick(View v) {
        		BagrotFunc();
        	}
        });
         
 
	}
            

	
	
	public boolean onCreateOptionsMenu(Menu menu) {
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.activity_main_numrology, menu);
    	return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	/*פרטי משתמש*/
    	case R.id.menu_user_Info:
    		AlertDialog.Builder builder1;
   		 information_UserInformation = "שם פרטי:" + " " + FirstName + "\n" +"ערך שם פרטי:" + " " + textViewFirstName + "/" + textViewFirstNameFinal + "\n" +  "שם משפחה:" + " " + LastName + "\n" +"ערך שם משפחה:" + " " + textViewLastName + "/" + textViewLastNameFinal + "\n" +  "תאריך לידה:" + " " + BirthDay_Day + "/" + BirthDay_Month + "/" + BirthDay_Year + " \n" + "ערך תאריך לידה:"+ " " + Spirala + "/" + SpiralaFinal + "\n" + "מזל:" + " " + Name_Mazal + "\n" + "ערך מזל:" + " " + NumMazal + "\n" + "גיל:" + " " + Age;
   		 builder1 = new AlertDialog.Builder(this);
        	 builder1.setTitle(R.string.UserInformation);
        	 builder1.setMessage(information_UserInformation);
        	 builder1.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                     dialog.cancel();
                }
            });builder1.show();
    		return true;
    	
    	/*שנה חודש ויום אישי*/
    	case R.id.menu_Current:
    		AlertDialog.Builder builder2;
    		information_Current = "שנה אישית:" + " " + Personal_year + "\n" +"חודש אישי:" + " " + Personal_month + "\n" +  "יום אישי:" + " " + Personal_day + "\n";
   		builder2 = new AlertDialog.Builder(this);
   		builder2.setTitle(R.string.menu_Current);
   		builder2.setMessage(information_Current);
   		builder2.setNegativeButton(R.string.close, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                     dialog.cancel();
                }
            });builder2.show();
    		return true;
    	
    	/*מוקד הראש ערך*/
    	case R.id.menu_haed:
    		HeadFunc();
    		return true;
    	
    	/*מוקד הלב ערך*/
    	case R.id.menu_hart:
    		HeartFunc();
    		return true;
    		
    	/*מוקד הספירלה ערך*/
    	case R.id.menu_spirala:
    		SpiralaFunc();
    		return true;
    			
    	/*מוקד הידיים ערך*/
    	case R.id.menu_hands:
    		HandFunc();
    		return true;
    		
    	/*מוקד הרגליים ערך*/
    	case R.id.menu_feet:
    		FeetFunc();
    		return true;
    		
    	/*מוקד הילדות ערך*/
    	case R.id.menu_yaldot:
    		YaldotFunc();
    		return true;
    		
    	/*מוקד הבגרות ערך*/
    	case R.id.menu_bagrot:
    		BagrotFunc();
    		return true;
    		
    	default:
    		return super.onOptionsItemSelected(item);
    	}
    }
    
    
	//בדיקה אם השנה,חודש והיום אישי הם קרמתיים או מסטר
	public String Current(String name)
	{

        if (name.equals("13"))
        	name = "13/4";
        
        if (name.equals("14"))
        	name = "14/5";
        
        if (name.equals("16"))
        	name = "16/7";
        
        if (name.equals("19"))
        	name = "19/1";
        
        if (name.equals("11"))
        	name = "11/2";
        
        if (name.equals("22"))
        	name = "22/4";
        
        if (name.equals("33"))
        	name = "33/6";
        
        return name;
	}
	
	
	/*פונקציה של מוקד הראש*/
    public void HeadFunc()
    {	
        if(HeadFinal.equals("0"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head0.png";
    		StartView();
    	}
        if(HeadFinal.equals("1") && !Head.equals("19"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head1.png";
    		StartView();
    	}
    	if(HeadFinal.equals("2") && !Head.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head2.png";
    		StartView();
    	}
    	if(HeadFinal.equals("3"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head3.png";
    		StartView();
    	}
    	if(HeadFinal.equals("4") && (!Head.equals("22") && !Head.equals("13")))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head4.png";
    		StartView();
    	}
    	if(HeadFinal.equals("5") && !Head.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head5.png";
    		StartView();
    	}
    	if(HeadFinal.equals("6")  && !Head.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head6.png";
    		StartView();
    	}
    	if(HeadFinal.equals("7") && !Head.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head7.png";
    		StartView();
    	}
    	if(HeadFinal.equals("8"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head8.png";
    		StartView();
    	}
    	if(HeadFinal.equals("9"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head9.png";
    		StartView();
    	}
    	if(Head.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head11.png";
    		StartView();
    	}  
    	if(Head.equals("22"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head22.png";
    		StartView();
    	}  
    	if(Head.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head33.png";
    		StartView();
    	}  
    	if(Head.equals("13"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head13.png";
    		StartView();
    	}  
    	if(Head.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head14.png";
    		StartView();
    	}  
    	if(Head.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head16.png";
    		StartView();
    	}  
    	if(Head.equals("19"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/head/head19.png";
    		StartView();
    	}  
    	
    }

    
    /*פונקציה של מוקד הלב*/
    public void HeartFunc()
    {	 
        if(Heart.equals("0"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart0.png";
        	StartView();
    	}
        if(Heart.equals("1"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart1.png";
        	StartView();
    	}
        if(Heart.equals("2"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart2.png";
        	StartView();
    	}
        if(Heart.equals("3"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart3.png";
        	StartView();
    	}
        if(Heart.equals("4"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart4.png";
        	StartView();
    	}
        if(Heart.equals("5"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart5.png";
        	StartView();
    	}
        if(Heart.equals("6"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart6.png";
        	StartView();
    	}
        if(Heart.equals("7"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart7.png";
        	StartView();
    	}
        if(Heart.equals("8"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/heart/heart8.png";
        	StartView();
    	}
        
    }
    
    
    /*פונקציה של מוקד הספירלה*/
    public void SpiralaFunc()
    {	
        if(SpiralaFinal.equals("1") && !Spirala.equals("19"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala1.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("2") && !Spirala.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala2.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("3"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala3.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("4") && (!Spirala.equals("22") && !Spirala.equals("13")))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala4.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("5") && !Spirala.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala5.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("6")  && !Spirala.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala6.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("7") && !Spirala.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala7.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("8"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala8.png";
        	StartView();
    	}
    	if(SpiralaFinal.equals("9"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala9.png";
        	StartView();
    	}
    	if(Spirala.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala11.png";
        	StartView();
    	}  
    	if(Spirala.equals("22"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala22.png";
        	StartView();
    	}  
    	if(Spirala.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala33.png";
        	StartView();
    	}  
    	if(Spirala.equals("13"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala13.png";
        	StartView();
    	}  
    	if(Spirala.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala14.png";
        	StartView();
    	}  
    	if(Spirala.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala16.png";
        	StartView();
    	}  
    	if(Spirala.equals("19"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/spirala/spirala19.png";
        	StartView();
    	} 
    	
    }
    
    
    /*פונקציה של מוקד הידיים*/
    public void HandFunc()
    {	
        if(HandsFinal.equals("1") && !Hands.equals("19"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands1.png";
        	StartView();
    	}
    	if(HandsFinal.equals("2") && !Hands.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands2.png";
        	StartView();
    	}
    	if(HandsFinal.equals("3"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands3.png";
        	StartView();
    	}
    	if(HandsFinal.equals("4") && (!Hands.equals("22") && !Hands.equals("13")))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands4.png";
        	StartView();
    	}
    	if(HandsFinal.equals("5") && !Hands.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands5.png";
        	StartView();
    	}
    	if(HandsFinal.equals("6")  && !Hands.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands6.png";
        	StartView();
    	}
    	if(HandsFinal.equals("7") && !Hands.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands7.png";
        	StartView();
    	}
    	if(HandsFinal.equals("8"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands8.png";
        	StartView();
    	}
    	if(HandsFinal.equals("9"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands9.png";
        	StartView();
    	}  
    	if(Hands.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands11.png";
        	StartView();
    	}  
    	if(Hands.equals("22"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands22.png";
        	StartView();
    	}  
    	if(Hands.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands33.png";
        	StartView();
    	}  
    	if(Hands.equals("13"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands13.png";
        	StartView();
    	}  
    	if(Hands.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands14.png";
        	StartView();
    	}  
    	if(Hands.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands16.png";
        	StartView();
    	}  
    	if(Hands.equals("19"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/hands/hands19.png";
        	StartView();
    	}  
    	
    }
    
    
    /*פונקציה של מוקד הרגליים*/
    public void FeetFunc()
    {	
        if(FeetFinal.equals("1") && !Feet.equals("19"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet1.png";
        	StartView();
    	}
    	if(FeetFinal.equals("2") && !Feet.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet2.png";
        	StartView();
    	}
    	if(FeetFinal.equals("3"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet3.png";
        	StartView();
    	}
    	if(FeetFinal.equals("4") && (!Feet.equals("22") && !Feet.equals("13")))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet4.png";
        	StartView();
    	}
    	if(FeetFinal.equals("5") && !Feet.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet5.png";
        	StartView();
    	}
    	if(FeetFinal.equals("6")  && !Feet.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet6.png";
        	StartView();
    	}
    	if(FeetFinal.equals("7") && !Feet.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet7.png";
        	StartView();
    	}
    	if(FeetFinal.equals("8"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet8.png";
        	StartView();
    	}
    	if(FeetFinal.equals("9"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet9.png";
        	StartView();
    	}
    	if(Feet.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet11.png";
        	StartView();
    	}  
    	if(Feet.equals("22"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet22.png";
        	StartView();
    	}  
    	if(Feet.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet33.png";
        	StartView();
    	}  
    	if(Feet.equals("13"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet13.png";
        	StartView();
    	}  
    	if(Feet.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet14.png";
        	StartView();
    	}  
    	if(Feet.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet16.png";
        	StartView();
    	}  
    	if(Feet.equals("19"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/feet/feet19.png";
        	StartView();
    	}  
    	
    }
    
    
    /*פונקציה של מוקד הילדות*/
    public void YaldotFunc()
    {	

        if(YaldotFinal.equals("1") && !Yaldot.equals("19"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot1.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("2") && !Yaldot.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot2.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("3"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot3.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("4") && (!Yaldot.equals("22") && !Yaldot.equals("13")))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot4.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("5") && !Yaldot.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot5.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("6"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot6.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("7") && !Yaldot.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot7.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("8"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot8.png";
        	StartView();
    	}
    	if(YaldotFinal.equals("9"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot9.png";
        	StartView();
    	} 
    	if(Yaldot.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot11.png";
        	StartView();
    	}  
    	if(Yaldot.equals("22"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot22.png";
        	StartView();
    	}    
    	if(Yaldot.equals("13"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot13.png";
        	StartView();
    	}  
    	if(Yaldot.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot14.png";
        	StartView();
    	}  
    	if(Yaldot.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot16.png";
        	StartView();
    	}  
    	if(Yaldot.equals("19"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/yaldot/yaldot19.png";
        	StartView();
    	}  
    	
    }
    
    
    /*פונקציה של מוקד הבגרות*/
    public void BagrotFunc()
    {	
        if(BagrotFinal.equals("1") && !Bagrot.equals("19"))
    	{
        	address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot1.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("2") && !Bagrot.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot2.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("3"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot3.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("4") && (!Bagrot.equals("22") && !Bagrot.equals("13")))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot4.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("5") && !Bagrot.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot5.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("6")  && !Bagrot.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot6.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("7") && !Bagrot.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot7.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("8"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot8.png";
        	StartView();
    	}
    	if(BagrotFinal.equals("9"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot9.png";
        	StartView();
    	} 
    	if(Bagrot.equals("11"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot11.png";
        	StartView();
    	}  
    	if(Bagrot.equals("22"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot22.png";
        	StartView();
    	}  
    	if(Bagrot.equals("33"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot33.png";
        	StartView();
    	}  
    	if(Bagrot.equals("13"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot13.png";
        	StartView();
    	}  
    	if(Bagrot.equals("14"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot14.png";
        	StartView();
    	}  
    	if(Bagrot.equals("16"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot16.png";
        	StartView();
    	}  
    	if(Bagrot.equals("19"))
    	{
    		address = "file://" +Environment.getExternalStorageDirectory().getPath()+"/numerology/bagrot/bagrot19.png";
        	StartView();
    	}  

    }
    

    
    public void StartView()
    {	
    	Log.d("file",address);
        
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse(address), "image/*");//"
        startActivity(intent);
    }
    
}
