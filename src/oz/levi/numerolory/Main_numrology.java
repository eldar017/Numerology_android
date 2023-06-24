package oz.levi.numerolory;

import java.text.DateFormat;
import java.util.Calendar;

import oz.levi.numerolory.R;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main_numrology extends Activity implements OnClickListener{  
	int temp = 0, sum = 0, day1, temp_day1 = 0, month1, year1, m_yaldot, m_spirala = 0, m_hands,temp_m_hands,
	Current_year, Current_month, Current_day, day,month,year, Personal_day,Personal_month,Personal_year, USER_ID;
	DateFormat fmtDateAndTime = DateFormat.getDateInstance();
	TextView lblDateAndTime, textViewFirstName,textViewFirstNameFinal,textViewLastName,textViewLastNameFinal,
	textViewBirthDay,textViewBirthDayFinal,textViewSpirala,textViewSpiralaFinal, textViewYaldot,textViewYaldotFinal,
	textViewHands,textViewHands2,textViewHandsFinal,textViewHandsFinal2,textViewBagrot,textViewBagrotFinal,textViewHeart;
	String S_textViewBirthDay,S_textViewBirthDayFinal,S_textViewSpirala,S_textViewSpiralaFinal, S_textViewYaldot,
	S_textViewYaldotFinal,S_textViewHands,S_textViewHands2,S_textViewHandsFinal,S_textViewHandsFinal2,
	S_textViewBagrot,S_textViewBagrotFinal,S_textViewHeart, S_textViewHead , S_textViewHeadFinal,S_textViewFeet,
	S_textViewFeetFinal,temp_test1,temp_test2, Name_Mazal,NumMazal,Age,resultCharFirstName,resultCharLastName,
	load_FirstName,load_LastName,load_Day,load_Month,load_Year, check_day, check_month, check_year, called_from,
	valid_first_name = null, valid_last_name = null, valid_Day_Birthday = null, valid_Month_Birthday = null, valid_Year_Birthday = null, Toast_msg = null, valid_user_id = "";
	EditText edtFirstName,edtLastName,editTextDay,EditTextMonth,EditTextYear;
	DatabaseHandler dbHandler = new DatabaseHandler(this);
	Calendar myCalendar = Calendar.getInstance();
	Calendar myCalendar_Now = Calendar.getInstance();
	DatePickerDialog.OnDateSetListener d = new DatePickerDialog.OnDateSetListener() {
		public void onDateSet(DatePicker view, int year, int monthOfYear,
				int dayOfMonth) {
		myCalendar.set(Calendar.YEAR, year);
		myCalendar.set(Calendar.MONTH, monthOfYear);
		myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		updateLabel();
		}
		};
		
		private void updateLabel() {
			lblDateAndTime.setText(fmtDateAndTime.format(myCalendar.getTime()));	
		}
		
	final FuncCalc myFuncCalck = new FuncCalc();
	
	final String[] _alphabetSetup = new String[9];
	final String[] _aaviSetup = new String[6];
	final String[] _NotalphabetSetup = new String[9];
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_numrology);
        setTitle("הוספת לקוח וביצוע פעולות");
        //getActionBar().setHomeButtonEnabled(false);
        //getActionBar().setCustomView(R.layout.activity_main_numrology);
        
     // set screen
    Set_Add_Update_Screen();
        
     // set visibility of view as per calling activity
        called_from = getIntent().getStringExtra("called");

    	if (called_from.equalsIgnoreCase("update")) {
    	    USER_ID = Integer.parseInt(getIntent().getStringExtra("USER_ID"));

    	    Contact c = dbHandler.Get_Contact(USER_ID);
    	    
    	    edtFirstName.setText(c.getFirstName());
    	    edtLastName.setText(c.getLastName());
    	    editTextDay.setText(c.getDay());
    	    EditTextMonth.setText(c.getMonth());
    	    EditTextYear.setText(c.getYear());
    	    
    	    final View buttonCalc1 = findViewById(R.id.buttonCalc);  
    	    buttonCalc1.post(new Runnable(){
                @Override
                public void run() {
                	buttonCalc1.performClick();
                }
            });
            
    	    // dbHandler.close();
    	}
    	
    	edtFirstName.addTextChangedListener(new TextWatcher() {

    	    @Override
    	    public void onTextChanged(CharSequence s, int start, int before,
    		    int count) {
    		// TODO Auto-generated method stub

    	    }

    	    @Override
    	    public void beforeTextChanged(CharSequence s, int start, int count,
    		    int after) {
    		// TODO Auto-generated method stub

    	    }

    	    @Override
    	    public void afterTextChanged(Editable s) {
    		// TODO Auto-generated method stub
    		Is_Valid_FirstName(edtFirstName);
    	    }
    	});
    	
    	
    	edtLastName.addTextChangedListener(new TextWatcher() {

    	    @Override
    	    public void onTextChanged(CharSequence s, int start, int before,
    		    int count) {
    		// TODO Auto-generated method stub

    	    }

    	    @Override
    	    public void beforeTextChanged(CharSequence s, int start, int count,
    		    int after) {
    		// TODO Auto-generated method stub

    	    }

    	    @Override
    	    public void afterTextChanged(Editable s) {
    		// TODO Auto-generated method stub
    		Is_Valid_LastName(edtLastName);
    	    }
    	});
    	
    	editTextDay.addTextChangedListener(new TextWatcher() {
    		
    		@Override
    	    public void onTextChanged(CharSequence s, int start, int before,
    		    int count) {
    		// TODO Auto-generated method stub

    	    }

    	    @Override
    	    public void beforeTextChanged(CharSequence s, int start, int count,
    		    int after) {
    		// TODO Auto-generated method stub

    	    }
    	    @Override
    	    public void afterTextChanged(Editable s) {
    		// TODO Auto-generated method stub
    		Is_Valid_DayBirthday(editTextDay);
    	    }
    	});
    	
    	EditTextMonth.addTextChangedListener(new TextWatcher() {
    		
    		@Override
    	    public void onTextChanged(CharSequence s, int start, int before,
    		    int count) {
    		// TODO Auto-generated method stub

    	    }

    	    @Override
    	    public void beforeTextChanged(CharSequence s, int start, int count,
    		    int after) {
    		// TODO Auto-generated method stub

    	    }
    	    
    	    @Override
    	    public void afterTextChanged(Editable s) {
    		// TODO Auto-generated method stub
    		Is_Valid_MonthBirthday(EditTextMonth);
    	    }
    	});
    	
    	EditTextYear.addTextChangedListener(new TextWatcher() {
    		
    		@Override
    	    public void onTextChanged(CharSequence s, int start, int before,
    		    int count) {
    		// TODO Auto-generated method stub

    	    }

    	    @Override
    	    public void beforeTextChanged(CharSequence s, int start, int count,
    		    int after) {
    		// TODO Auto-generated method stub

    	    }
    	    @Override
    	    public void afterTextChanged(Editable s) {
    		// TODO Auto-generated method stub
    		Is_Valid_YearBirthday(EditTextYear);
    	    }
    	});
    	
    	View buttonCalcAndSave = findViewById(R.id.buttonCalcAndSave);
    	buttonCalcAndSave.setOnClickListener(this);
    
     
        View buttonCalc = findViewById(R.id.buttonCalc);
        buttonCalc.setOnClickListener(this);  
        
        View button2Click = findViewById(R.id.button_list_map);
		button2Click.setOnClickListener(this);  
        
        Button invokingButton = (Button)findViewById(R.id.button1);
        invokingButton.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        		
        		Intent explicitIntent = new Intent(Main_numrology.this,map_numrology.class);
        		
        		explicitIntent.putExtra("Head", S_textViewHead);
        		explicitIntent.putExtra("HeadFinal", S_textViewHeadFinal);
        		explicitIntent.putExtra("Hands", S_textViewHands);
        		explicitIntent.putExtra("HandsFinal", S_textViewHandsFinal);
        		explicitIntent.putExtra("Hands2", S_textViewHands2);
        		explicitIntent.putExtra("HandsFinal2",S_textViewHandsFinal2);
        		explicitIntent.putExtra("Heart", S_textViewHeart);
        		explicitIntent.putExtra("Spirala", S_textViewSpirala);
        		explicitIntent.putExtra("SpiralaFinal", S_textViewSpiralaFinal);
        		explicitIntent.putExtra("Bagrot", S_textViewBagrot);
        		explicitIntent.putExtra("BagrotFinal", S_textViewBagrotFinal);
        		explicitIntent.putExtra("Feet", S_textViewFeet);
        		explicitIntent.putExtra("FeetFinal", S_textViewFeetFinal);
        		explicitIntent.putExtra("Yaldot",S_textViewYaldot);
        		explicitIntent.putExtra("YaldotFinal", S_textViewYaldotFinal);
        		explicitIntent.putExtra("temp_test1", temp_test1);
        		explicitIntent.putExtra("temp_test2", temp_test2);
        		explicitIntent.putExtra("Age", Age);
        		explicitIntent.putExtra("Name_Mazal", Name_Mazal);
        		explicitIntent.putExtra("NumMazal", NumMazal);
        		explicitIntent.putExtra("FirstName", resultCharFirstName);
        		explicitIntent.putExtra("LastName", resultCharLastName);
        		explicitIntent.putExtra("textViewFirstName", textViewFirstName.getText().toString());
        		explicitIntent.putExtra("textViewFirstNameFinal", textViewFirstNameFinal.getText().toString());
        		explicitIntent.putExtra("textViewLastName", textViewLastName.getText().toString());
        		explicitIntent.putExtra("textViewLastNameFinal", textViewLastNameFinal.getText().toString());
        		explicitIntent.putExtra("BirthDay_Day", String.valueOf(day));
        		explicitIntent.putExtra("BirthDay_Month", String.valueOf(month));
        		explicitIntent.putExtra("BirthDay_Year", String.valueOf(year));
        		explicitIntent.putExtra("Personal_year", String.valueOf(Personal_year));
        		explicitIntent.putExtra("Personal_month", String.valueOf(Personal_month));
        		explicitIntent.putExtra("Personal_day", String.valueOf(Personal_day));
        		
        		startActivity(explicitIntent);
        			
        	}
        });
        
        Button invokingButton1 = (Button)findViewById(R.id.button2);
        invokingButton1.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {
        		
        				
        		Intent explicitIntentCycleLife  = new Intent(Main_numrology.this,cycles_life.class);
        		
        		
        		explicitIntentCycleLife.putExtra("SpiralaFinal", S_textViewSpiralaFinal);
        		explicitIntentCycleLife.putExtra("BirthDay_Day", String.valueOf(day));
        		explicitIntentCycleLife.putExtra("BirthDay_Day1", String.valueOf(day1));
        		explicitIntentCycleLife.putExtra("BirthDay_Month", String.valueOf(month));
        		explicitIntentCycleLife.putExtra("BirthDay_Month1", String.valueOf(month1));
        		explicitIntentCycleLife.putExtra("BirthDay_Year1", String.valueOf(year1));
        		explicitIntentCycleLife.putExtra("Personal_year", String.valueOf(Personal_year));
        		explicitIntentCycleLife.putExtra("Personal_month", String.valueOf(Personal_month));
        		explicitIntentCycleLife.putExtra("Personal_day", String.valueOf(Personal_day));
        		explicitIntentCycleLife.putExtra("Age", Age);
        		
        		
        		startActivity(explicitIntentCycleLife);
        		
        	}
        });
        
 
      //אותיות א-ת
      		_alphabetSetup[0] = ("איקAJSajs");
      		_alphabetSetup[1] = ("בכךרBKTbkt");
      		_alphabetSetup[2] = ("גלשCLUclu");
      		_alphabetSetup[3] = ("דמםתDMVdmv");
      		_alphabetSetup[4] = ("הנןENWenw");
      		_alphabetSetup[5] = ("וסFOXfox");
      		_alphabetSetup[6] = ("זעGPYgpy");
      		_alphabetSetup[7] = ("חפףHQZhqz");
      		_alphabetSetup[8] = ("טצץIRir");
      		
      //אותיות אהו"י
            _aaviSetup[0] = ("אי");
            _aaviSetup[1] = ("");
            _aaviSetup[2] = ("");
            _aaviSetup[3] = ("");
            _aaviSetup[4] = ("ה");
            _aaviSetup[5] = ("ו");

      //אותיות בלי אהו"י
            _NotalphabetSetup[0] = ("ק");
            _NotalphabetSetup[1] = ("בכךר");
            _NotalphabetSetup[2] = ("גלש");
            _NotalphabetSetup[3] = ("דמםת");
            _NotalphabetSetup[4] = ("נן");
            _NotalphabetSetup[5] = ("ס");
            _NotalphabetSetup[6] = ("זע");
            _NotalphabetSetup[7] = ("חפף");
            _NotalphabetSetup[8] = ("טצץ");
      		

      		
      		lblDateAndTime = (TextView) findViewById(R.id.lblDateAndTime);
      		
      		
    }
    
    public void Set_Add_Update_Screen() {
	edtFirstName = ( EditText) findViewById(R.id.editTextFirstName);
    edtLastName = ( EditText) findViewById(R.id.editTextLastName);
    editTextDay = ( EditText) findViewById(R.id.editTextDay);
    EditTextMonth = ( EditText) findViewById(R.id.EditTextMonth);
    EditTextYear = ( EditText) findViewById(R.id.EditTextYear);
    }

	public void onClick(View v) {
		
		
		/*שמירת נתונים*/
		switch(v.getId()){
			
		case R.id.button_list_map:
			Intent view_user = new Intent(Main_numrology.this,
					Main_Screen.class);
				view_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
					| Intent.FLAG_ACTIVITY_NEW_TASK);
				startActivity(view_user);
				finish();
			break;

		case R.id.buttonCalcAndSave:
			if (valid_first_name != null && valid_last_name != null  && valid_Day_Birthday != null  && valid_Month_Birthday != null  && valid_Year_Birthday != null  
   	    			&& valid_first_name.length() != 0 && valid_last_name.length() != 0 && valid_Day_Birthday.length() != 0 && valid_Month_Birthday.length() != 0 && valid_Year_Birthday.length() != 0) 
   	    		{
   	    		    dbHandler.Add_Contact(new Contact(valid_first_name,
   	    		    		valid_last_name, valid_Day_Birthday, valid_Month_Birthday, valid_Year_Birthday));
   	    		    Toast_msg = "הנתונים נשמרו";
   	    		    Show_Toast(Toast_msg);
   	    		    //Reset_Text();
   	    		}
   	    	//}
   	    	
   	    	if (called_from.equalsIgnoreCase("update")) {
   	    		valid_first_name = edtFirstName.getText().toString();
   	    		valid_last_name = edtLastName.getText().toString();
   	    		valid_Day_Birthday = editTextDay.getText().toString();
   	    		valid_Month_Birthday = EditTextMonth.getText().toString();
   	    		valid_Year_Birthday = EditTextYear.getText().toString();

	   	 		// check the value state is null or not
   	    		if (valid_first_name != null && valid_last_name != null  && valid_Day_Birthday != null  && valid_Month_Birthday != null  && valid_Year_Birthday != null  
   	    			&& valid_first_name.length() != 0 && valid_last_name.length() != 0 && valid_Day_Birthday.length() != 0 && valid_Month_Birthday.length() != 0 && valid_Year_Birthday.length() != 0) 
   	    		{
   	    		    dbHandler.Update_Contact(new Contact(USER_ID, valid_first_name,
   	    		    		valid_last_name, valid_Day_Birthday, valid_Month_Birthday, valid_Year_Birthday));
	   	 		    dbHandler.close();
	   	 		    Toast_msg = "הנתונים עודכנו";
	   	 		    Show_Toast(Toast_msg);
	   	 		    //Reset_Text();
	   	 		} else {
	   	 		    Toast_msg = "חלק מהשדות חסרים, בבקשה מלא את כל השדות";
	   	 		    Show_Toast(Toast_msg);
	   	 		}
   	    	}

            break;    

		}
		/*עד לכאן שמירת נתונים*/
		
		int i,x,y;
		int numerology = 0;
		int temp_FirstName;
		int temp_FirstNameFinal;
		int temp_LastName;
		int temp_LastNameFinal;
		int temp_SpiralaFinal;
		int temp_HandsFinal2;
		char ch;
		int temp_numerology = 0;
		int temp_Current_year = 0;
		
		/**********************************************************************/
		/*שנה נוכחית*/
		Current_year = myCalendar_Now.get(Calendar.YEAR);
		/*חודש נוכחי*/
		Current_month = 0;
		Current_month = myCalendar_Now.get(Calendar.MONTH);
		Current_month += 1;
		/*יוום נוכחי*/
		Current_day = myCalendar_Now.get(Calendar.DAY_OF_MONTH);
		
		//***********Birth Day**************//
		textViewBirthDay = ( TextView) findViewById(R.id.textViewBirthDay);
		textViewBirthDayFinal = ( TextView) findViewById(R.id.textViewBirthDayFinal);
		month=0;
		/*day*/
		check_day = editTextDay.getText().toString();
		if(check_day.equals("")) /*אעני עושה בדיקה, אם השדה הזה ריק, אז אני שם בו את התאריך הנוכחי, כדי שהאפליקציה לא תקרוס במידה ולא הכניסו ערך*/
			day = Current_day;
		else
			day = Integer.parseInt(editTextDay.getText().toString());
		/*month*/
		check_month = EditTextMonth.getText().toString();
		if(check_month.equals("")) /*אעני עושה בדיקה, אם השדה הזה ריק, אז אני שם בו את התאריך הנוכחי, כדי שהאפליקציה לא תקרוס במידה ולא הכניסו ערך*/
			month = Current_month;
		else
			month = Integer.parseInt(EditTextMonth.getText().toString());
		/*year*/
		check_year = EditTextYear.getText().toString();
		if(check_year.equals("")) /*אעני עושה בדיקה, אם השדה הזה ריק, אז אני שם בו את התאריך הנוכחי, כדי שהאפליקציה לא תקרוס במידה ולא הכניסו ערך*/
			year = Current_year;
		else
			year = Integer.parseInt(EditTextYear.getText().toString());
		
		
		//שמירת מוקד הילדות המלא
        m_yaldot =day;
		//חישוב היום לידה
        day1 = myFuncCalck.pirokAll(day);
		
		 //חישוב חודש לידה
		month1 = myFuncCalck.pirokAll(month);
        //חישוב שנת לידה
		year1 = myFuncCalck.pirokAll(year);
		
		
		//***********יום,חודש ושנה אישית**************//
		
		/*שנה אישית*/
		temp_Current_year = Current_year;
		if (Current_month < month || (Current_month == month && Current_day < day)) /*אם עדיין לא חל היום הולדת אז צריך לעשות שנה נוכחית פחות 1*/
        {
			temp_Current_year--;
        }
		temp_Current_year = myFuncCalck.pirokAll(temp_Current_year);
		//אם רוצים לקבל שנה אישית קרמטית, אז לשים day1,month1
		Personal_year = day + month + temp_Current_year;
		Personal_year = myFuncCalck.pirokAll(Personal_year);
		
		/*חודש אישי*/
		Personal_month = Personal_year + Current_month;
		Personal_month = myFuncCalck.pirokAll(Personal_month);
		
		/*יום אישי*/
		Personal_day = Personal_month + Current_day;
		Personal_day = myFuncCalck.pirokAll(Personal_day);
		
		
		/**********************************************************************/
		/*First Name*/
		textViewFirstName = ( TextView) findViewById(R.id.textViewFirstName);
		textViewFirstNameFinal = ( TextView) findViewById(R.id.textViewFirstNameFinal);
		resultCharFirstName = edtFirstName.getText().toString();
		
		for(i=0 ; i<resultCharFirstName.length() ; i++)
		{	
			for(x=0; x<_alphabetSetup.length;x++)
			{
				for( y=0; y<_alphabetSetup[x].length(); y++)
				{
					ch = _alphabetSetup[x].charAt(y);
					
					if(ch == resultCharFirstName.charAt(i))
						numerology += x+1;
				}
				
			}

		}
		temp_FirstName = numerology;
		textViewFirstName.setText(String.valueOf(numerology));
		
		temp_numerology = myFuncCalck.pirokFinal(numerology);
		temp_FirstNameFinal = temp_numerology;
		textViewFirstNameFinal.setText(String.valueOf(temp_numerology));
		
		/*Last Name*/
		numerology = 0;
		textViewLastName = ( TextView) findViewById(R.id.textViewLastName);
		textViewLastNameFinal = ( TextView) findViewById(R.id.textViewLastNameFinal);
		resultCharLastName = edtLastName.getText().toString();
		
		for(i=0 ; i<resultCharLastName.length() ; i++)
		{	
			for( x=0; x<_alphabetSetup.length;x++)
			{
				for( y=0; y<_alphabetSetup[x].length(); y++)
				{
					ch = _alphabetSetup[x].charAt(y);
					
					if(ch == resultCharLastName.charAt(i))
						numerology += x+1;
				}
				
			}

		}
		
		temp_LastName = numerology;
		textViewLastName.setText(String.valueOf(numerology));
		
		temp_numerology = myFuncCalck.pirokFinal(numerology);
		temp_LastNameFinal = temp_numerology;
		textViewLastNameFinal.setText(String.valueOf(temp_numerology));
		
		
		
		/**********************************************************************/
		
		 /*מוקד הילדות*/
		textViewYaldot = ( TextView) findViewById(R.id.textViewYaldot);
		textViewYaldotFinal = ( TextView) findViewById(R.id.textViewYaldotFinal);
		S_textViewYaldot = String.valueOf(m_yaldot);
        int temp_m_yaldot = 0;
        sum = 0;
        
        //מוקד הילדות סופי
        temp_day1 = day1;
        if ((temp_day1 == 13) || (temp_day1 == 14) || (temp_day1 == 16) || (temp_day1 == 19) || (temp_day1 == 11) || (temp_day1 == 22) || (temp_day1 == 33))
        {
            while (temp_day1 != 0)
            {
                sum += temp_day1 % 10;
                temp_day1 /= 10;
            }

            temp_day1 = sum;
        }
        temp_m_yaldot = myFuncCalck.pirokFinal(temp_day1);
        S_textViewYaldotFinal = String.valueOf(temp_m_yaldot);
		
        /**********************************************************************/
        
		//מוקד נפש האדם
        textViewSpirala = ( TextView) findViewById(R.id.textViewSpirala);
		textViewSpiralaFinal = ( TextView) findViewById(R.id.textViewSpiralaFinal);
		
        m_spirala = day1 + month1 + year1;
        S_textViewSpirala = String.valueOf(m_spirala);
        
        textViewBirthDay.setText(String.valueOf(m_spirala));
        
        //איפוס המונה לספירלה
        sum = 0;
        temp = m_spirala;
        m_spirala = myFuncCalck.pirokAll(m_spirala);
        if ((temp == 13) || (temp == 14) || (temp == 16) || (temp == 19) || (temp == 11) || (temp == 22) || (temp == 33))
        {
            while (temp != 0)
            {
                sum += temp % 10;
                temp /= 10;
            }
            if (sum > 9)
            {
                temp = sum;
                sum = 0;
                while (temp != 0)
                {
                    sum += temp % 10;
                    temp /= 10;
                }
            }
            m_spirala = sum;
        }
        temp_SpiralaFinal = m_spirala;
        S_textViewSpiralaFinal = String.valueOf(m_spirala);
        
        textViewBirthDayFinal.setText(String.valueOf(m_spirala));
        
       

        /**********************************************************************/

        //מוקד הידיים
        textViewHands = ( TextView) findViewById(R.id.textViewHands);
		textViewHandsFinal = ( TextView) findViewById(R.id.textViewHandsFinal);
		textViewHands2 = ( TextView) findViewById(R.id.textViewHands2);
		textViewHandsFinal2 = ( TextView) findViewById(R.id.textViewHandsFinal2);
		
        temp = temp_FirstName;
        if (!((temp == 13) || (temp == 14) || (temp == 16) || (temp == 19) || (temp == 11) || (temp == 22) || (temp == 33)))
        {
        	temp = temp_FirstNameFinal;
        }

        m_hands = temp;

        temp = temp_LastName;
        if (!((temp == 13) || (temp == 14) || (temp == 16) || (temp == 19) || (temp == 11) || (temp == 22) || (temp == 33)))
        {
        	temp = temp_LastNameFinal;
        }

        m_hands += temp;
        temp_m_hands = m_hands;
        
        S_textViewHands = String.valueOf(m_hands);
        S_textViewHands2 = String.valueOf(m_hands);

        //החישוב הסופי של מוקד הידיים 
        m_hands = myFuncCalck.pirokFinal(m_hands);
        temp_HandsFinal2 = m_hands;
        S_textViewHandsFinal = String.valueOf(m_hands);
        S_textViewHandsFinal2 = String.valueOf(m_hands);

        /**********************************************************************/
        //מוקד הראש
        int m_head = 0;
        int temp_head = 0;
		
		for(i=0 ; i<resultCharFirstName.length() ; i++)
		{	
			for( x=0; x<_aaviSetup.length;x++)
			{
				for( y=0; y<_aaviSetup[x].length(); y++)
				{
					ch = _aaviSetup[x].charAt(y);
					
					if(ch == resultCharFirstName.charAt(i))
						m_head += x+1;
				}
				
			}

		}
        
        
		temp_head = m_head;
		temp_head = myFuncCalck.pirokAll(temp_head);
		
        m_head = 0;   
        for(i=0 ; i<resultCharLastName.length() ; i++)
		{	
			for( x=0; x<_aaviSetup.length;x++)
			{
				for( y=0; y<_aaviSetup[x].length(); y++)
				{
					ch = _aaviSetup[x].charAt(y);
					
					if(ch == resultCharLastName.charAt(i))
						m_head += x+1;
				}
				
			}

		}
        
        m_head = myFuncCalck.pirokAll(m_head);
        m_head += temp_head;
        S_textViewHead = String.valueOf(m_head);
        //החישוב הסופי של מוקד הראש 
        m_head = myFuncCalck.pirokFinal(m_head);
        S_textViewHeadFinal = String.valueOf(m_head);

       
        //מוקד הרגליים
        int m_feet = 0;
        int temp_feet;
        
        for(i=0 ; i<resultCharFirstName.length() ; i++)
		{	
			for( x=0; x<_NotalphabetSetup.length;x++)
			{
				for( y=0; y<_NotalphabetSetup[x].length(); y++)
				{
					ch = _NotalphabetSetup[x].charAt(y);
					
					if(ch == resultCharFirstName.charAt(i))
						m_feet += x+1;
				}
				
			}

		}
        
        
        temp_feet = m_feet;
        temp_feet = myFuncCalck.pirokAll(temp_feet);
        
        m_feet = 0;
        for(i=0 ; i<resultCharLastName.length() ; i++)
		{	
			for( x=0; x<_NotalphabetSetup.length;x++)
			{
				for( y=0; y<_NotalphabetSetup[x].length(); y++)
				{
					ch = _NotalphabetSetup[x].charAt(y);
					
					if(ch == resultCharLastName.charAt(i))
						m_feet += x+1;
				}
				
			}

		}
        
        m_feet = myFuncCalck.pirokAll(m_feet);
        m_feet += temp_feet;
        S_textViewFeet = String.valueOf(m_feet);
        //החישוב הסופי של מוקד הרגליים 
        m_feet = myFuncCalck.pirokFinal(m_feet);
        S_textViewFeetFinal = String.valueOf(m_feet);

        /**********************************************************************/
        //מוקד הבגרות
        textViewBagrot = ( TextView) findViewById(R.id.textViewBagrot);
        textViewBagrotFinal = ( TextView) findViewById(R.id.textViewBagrotFinal);
        int m_Bagrot = 0;
        m_spirala = day1 + month1 + year1;
        m_spirala = myFuncCalck.pirokAll(m_spirala);
        temp_m_hands = myFuncCalck.pirokAll(temp_m_hands);
        
        
        m_Bagrot = m_spirala + temp_m_hands;
        S_textViewBagrot = String.valueOf(m_Bagrot);
        
        //החישוב הסופי של מוקד הבגרות 
        m_Bagrot = myFuncCalck.pirokFinal(m_Bagrot);
        
        S_textViewBagrotFinal = String.valueOf(m_Bagrot);

        /**********************************************************************/
        //מוקד הלב
        int m_heart = 0;
        m_heart = temp_SpiralaFinal - temp_HandsFinal2;
        if (m_heart < 0)
            m_heart *= -1;
        
        S_textViewHeart = String.valueOf(m_heart);
        
        /**********************************************************************/
      //פרטים אישיים

        //גיל האדם
        int YearsPassed = 0;
        YearsPassed = Current_year - year;
        if (Current_month < month || (Current_month == month && Current_day < day))
        {
            YearsPassed--;
        }
        
        Age = String.valueOf(YearsPassed);
        //מזל אסטרולוגי
        if (month == 1)
        {
            if (day < 21)
            {
                Name_Mazal = "גדי";
                NumMazal = "8";
            }
            else
            {
                Name_Mazal = "דלי";
                NumMazal = "11/2";
            }

        }
        if (month == 2)
        {
            if (day < 19)
            {
                Name_Mazal = "דלי";
                NumMazal = "11/2";
            }
            else
            {
                Name_Mazal = "דגים";
                NumMazal = "7";
            }
        }
        if (month == 3)
        {
            if (day < 21)
            {
                Name_Mazal = "דגים";
                NumMazal = "7";
            }
            else
            {
                Name_Mazal = "טלה";
                NumMazal = "9";
            }
        }
        if (month == 4)
        {
            if (day < 21)
            {
                Name_Mazal = "טלה";
                NumMazal = "9";
            }
            else
            {
                Name_Mazal = "שור";
                NumMazal = "33/6";
            }
        }
        if (month == 5)
        {
            if (day < 21)
            {
                Name_Mazal = "שור";
                NumMazal = "33/6";
            }
            else
            {
                Name_Mazal = "תאומים";
                NumMazal = "5";
            }
        }
        if (month == 6)
        {
            if (day < 22)
            {
                Name_Mazal = "תאומים";
                NumMazal = "5";
            }
            else
            {
                Name_Mazal = "סרטן";
                NumMazal = "2";
            }
        }
        if (month == 7)
        {
            if (day < 23)
            {
                Name_Mazal = "סרטן";
                NumMazal = "2";
            }
            else
            {
                Name_Mazal = "אריה";
                NumMazal = "1";
            }
        }
        if (month == 8)
        {
            if (day < 23)
            {
                Name_Mazal = "אריה";
                NumMazal = "1";
            }
            else
            {
                Name_Mazal = "בתולה";
                NumMazal = "4";
            }
        }
        if (month == 9)
        {
            if (day < 23)
            {
                Name_Mazal = "בתולה";
                NumMazal = "4";
            }
            else
            {
                Name_Mazal = "מאזניים";
                NumMazal = "6";
            }
        }
        if (month == 10)
        {
            if (day < 24)
            {
                Name_Mazal = "מאזניים";
                NumMazal = "6";
            }
            else
            {
                Name_Mazal = "עקרב";
                NumMazal = "22/4";
            }
        }
        if (month == 11)
        {
            if (day < 22)
            {
                Name_Mazal = "עקרב";
                NumMazal = "22/4";
            }
            else
            {
                Name_Mazal = "קשת";
                NumMazal = "3";
            }
        }
        if (month == 12)
        {
            if (day < 22)
            {
                Name_Mazal = "קשת";
                NumMazal = "3";
            }
            else
            {
                Name_Mazal = "גדי";
                NumMazal = "8";
            }
        }	
	}
	
	
	public void Is_Valid_FirstName(EditText edt) throws NumberFormatException {
	if (edt.getText().toString().length() <= 0) {
	    edt.setError("נא הכנס אותיות בלבד");
	    valid_first_name = null;
	} else if ((!edt.getText().toString().matches("[ א,ב,ג,ד,ה,ו,ז,ח,ט,י,כ,ך,ל,מ,ם,נ,ן,ס,ע,פ,ף,צ,ץ,ק,ר,ש,ת]+"))) {
	    edt.setError("נא הכנס אותיות בלבד");
	    valid_first_name = null;
	} else {
		valid_first_name = edt.getText().toString();
	}

    }
	
	public void Is_Valid_LastName(EditText edt) throws NumberFormatException {
	if (edt.getText().toString().length() <= 0) {
	    edt.setError("נא הכנס אותיות בלבד");
	    valid_last_name = null;
	} else if ((!edt.getText().toString().matches("[ א,ב,ג,ד,ה,ו,ז,ח,ט,י,כ,ך,ל,מ,ם,נ,ן,ס,ע,פ,ף,צ,ץ,ק,ר,ש,ת]+"))) {
	    edt.setError("נא הכנס אותיות בלבד");
	    valid_last_name = null;
	} else {
		valid_last_name = edt.getText().toString();
	}

    }
	
	public void Is_Valid_DayBirthday(EditText edt) throws NumberFormatException {
	if (edt.getText().toString().length() <= 0) {
	    edt.setError("חייב להכניס מספר");
	    valid_Day_Birthday = null;
	} else {
		valid_Day_Birthday = edt.getText().toString();
	}

    }
	
	public void Is_Valid_MonthBirthday(EditText edt) throws NumberFormatException {
	if (edt.getText().toString().length() <= 0) {
	    edt.setError("חייב להכניס מספר");
	    valid_Month_Birthday = null;
	} else {
		valid_Month_Birthday = edt.getText().toString();
	}

    }
	
	public void Is_Valid_YearBirthday(EditText edt) throws NumberFormatException {
	if (edt.getText().toString().length() <= 0) {
	    edt.setError("חייב להכניס מספר");
	    valid_Year_Birthday = null;
	} else {
		valid_Year_Birthday = edt.getText().toString();
	}

    }
	
	public void Show_Toast(String msg) {
	Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    public void Reset_Text() {
	edtFirstName.getText().clear();
	edtLastName.getText().clear();
	editTextDay.getText().clear();
	EditTextMonth.getText().clear();
	EditTextYear.getText().clear();
    }
    
    public void MoveToMap() {
    	Intent explicitIntent = new Intent(Main_numrology.this,map_numrology.class);
		
		explicitIntent.putExtra("Head", S_textViewHead);
		explicitIntent.putExtra("HeadFinal", S_textViewHeadFinal);
		explicitIntent.putExtra("Hands", S_textViewHands);
		explicitIntent.putExtra("HandsFinal", S_textViewHandsFinal);
		explicitIntent.putExtra("Hands2", S_textViewHands2);
		explicitIntent.putExtra("HandsFinal2",S_textViewHandsFinal2);
		explicitIntent.putExtra("Heart", S_textViewHeart);
		explicitIntent.putExtra("Spirala", S_textViewSpirala);
		explicitIntent.putExtra("SpiralaFinal", S_textViewSpiralaFinal);
		explicitIntent.putExtra("Bagrot", S_textViewBagrot);
		explicitIntent.putExtra("BagrotFinal", S_textViewBagrotFinal);
		explicitIntent.putExtra("Feet", S_textViewFeet);
		explicitIntent.putExtra("FeetFinal", S_textViewFeetFinal);
		explicitIntent.putExtra("Yaldot",S_textViewYaldot);
		explicitIntent.putExtra("YaldotFinal", S_textViewYaldotFinal);
		explicitIntent.putExtra("temp_test1", temp_test1);
		explicitIntent.putExtra("temp_test2", temp_test2);
		explicitIntent.putExtra("Age", Age);
		explicitIntent.putExtra("Name_Mazal", Name_Mazal);
		explicitIntent.putExtra("NumMazal", NumMazal);
		explicitIntent.putExtra("FirstName", resultCharFirstName);
		explicitIntent.putExtra("LastName", resultCharLastName);
		explicitIntent.putExtra("textViewFirstName", textViewFirstName.getText().toString());
		explicitIntent.putExtra("textViewFirstNameFinal", textViewFirstNameFinal.getText().toString());
		explicitIntent.putExtra("textViewLastName", textViewLastName.getText().toString());
		explicitIntent.putExtra("textViewLastNameFinal", textViewLastNameFinal.getText().toString());
		explicitIntent.putExtra("BirthDay_Day", String.valueOf(day));
		explicitIntent.putExtra("BirthDay_Month", String.valueOf(month));
		explicitIntent.putExtra("BirthDay_Year", String.valueOf(year));
		explicitIntent.putExtra("Personal_year", String.valueOf(Personal_year));
		explicitIntent.putExtra("Personal_month", String.valueOf(Personal_month));
		explicitIntent.putExtra("Personal_day", String.valueOf(Personal_day));
		
		startActivity(explicitIntent);
    }
		     
			
 } 