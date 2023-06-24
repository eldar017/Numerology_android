package oz.levi.numerolory;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class cycles_life extends Activity{
	private static final int User_Information = Menu.FIRST;
	TextView TextViewAge1_2,TextViewAge2_1,TextViewAge2_2,TextViewAge3_1,TextViewAge3_2,TextViewAge4_1,TextViewAge4_2;
	TextView TextViewCycle1,TextViewCycle2,TextViewCycle3,TextViewCycle4;
	TextView TextViewpeak1,TextViewpeak2,TextViewpeak3,TextViewpeak4;
	TextView TextViewChallenge1,TextViewChallenge2,TextViewChallenge3,TextViewChallenge4,textViewBirthDay;
	TextView labelChallenge1,labelChallenge2;
	TextView TextView_Personal_year,TextView_Personal_month,TextView_Personal_day,TextView_Cycle_age;
	/*String Age1_2,Age2_1,Age2_2,Age3_1,Age3_2,Age4_1,Age4_2;
	String Cycle1,Cycle2,Cycle3,Cycle4;
	String peak1,peak2,peak3,peak4;
	String Challenge1,Challenge2,Challenge3,Challenge4;*/
	String day,day1,month,month1,year1,SpiralaFinal;
	int day1_int,day2_int,month1_int,month2_int,day_int,month_int;
	String Personal_year,Personal_month,Personal_day;
	String temp_Personal_year,temp_Personal_month,temp_Personal_day;
	int Personal_year1,Personal_month1,Personal_day1;
	String Age;
	 int temp_day = 0;
     int temp_month = 0;
     int temp_year = 0;
     int tempCalc = 0, tempCalcFinal = 0, tempCalcPeak1 = 0, tempCalcPeak2 = 0;
     int Current_year,Current_month,Current_day;
     int temp_Current_year = 0;
     int day2,month2,year2;
     EditText edTextDay1,edTextMonth1,edTextYear1;
     Calendar myCalendar_Now = Calendar.getInstance();
	final FuncCalc myFuncCalck = new FuncCalc();
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cycles_life2);
		setTitle("מחזורי חיים");
		
		
		final AlertDialog.Builder builder;
		builder = new AlertDialog.Builder(this);
		
		//גיל האדם
		TextViewAge1_2 = ( TextView) findViewById(R.id.TextViewAge1_2);
		TextViewAge2_1 = ( TextView) findViewById(R.id.TextViewAge2_1);
		TextViewAge2_2 = ( TextView) findViewById(R.id.TextViewAge2_2);
		TextViewAge3_1 = ( TextView) findViewById(R.id.TextViewAge3_1);
		TextViewAge3_2 = ( TextView) findViewById(R.id.TextViewAge3_2);
		TextViewAge4_1 = ( TextView) findViewById(R.id.TextViewAge4_1);
		TextViewAge4_2 = ( TextView) findViewById(R.id.TextViewAge4_2);
		
		//מחזור
		TextViewCycle1 = ( TextView) findViewById(R.id.TextViewCycle1);
		TextViewCycle2 = ( TextView) findViewById(R.id.TextViewCycle2);
		TextViewCycle3 = ( TextView) findViewById(R.id.TextViewCycle3);
		TextViewCycle4 = ( TextView) findViewById(R.id.TextViewCycle4);
		
		
		
		 //שיא
		TextViewpeak1 = ( TextView) findViewById(R.id.TextViewpeak1);
		TextViewpeak2 = ( TextView) findViewById(R.id.TextViewpeak2);
		TextViewpeak3 = ( TextView) findViewById(R.id.TextViewpeak3);
		TextViewpeak4 = ( TextView) findViewById(R.id.TextViewpeak4);
		
		//אתגר
		TextViewChallenge1 = ( TextView) findViewById(R.id.TextViewChallenge1);
		TextViewChallenge2 = ( TextView) findViewById(R.id.TextViewChallenge2);
		TextViewChallenge3 = ( TextView) findViewById(R.id.TextViewChallenge3);
		TextViewChallenge4 = ( TextView) findViewById(R.id.TextViewChallenge4);
		
		/*שנה,חודש ויום אישי*/
		TextView_Personal_year = ( TextView) findViewById(R.id.TextView_Personal_year);
		TextView_Personal_month = ( TextView) findViewById(R.id.TextView_Personal_month);
		TextView_Personal_day = ( TextView) findViewById(R.id.TextView_Personal_day);
		TextView_Cycle_age = ( TextView) findViewById(R.id.TextView_Cycle_age);
        
        
        Intent x = getIntent();
    	// Receiving the Data
        SpiralaFinal = x.getStringExtra("SpiralaFinal");
        day = x.getStringExtra("BirthDay_Day");
        day1 = x.getStringExtra("BirthDay_Day1");
        month = x.getStringExtra("BirthDay_Month");
        month1 = x.getStringExtra("BirthDay_Month1");
        year1 = x.getStringExtra("BirthDay_Year1");
        Personal_year = x.getStringExtra("Personal_year");
        Personal_month = x.getStringExtra("Personal_month");
        Personal_day = x.getStringExtra("Personal_day");
        Age = x.getStringExtra("Age");


        /************************************************   מחזורי החיים   **************************************************/
        /*מחזורי חיים - גיל*/
        TextViewAge1_2.setText(String.valueOf(36 - Integer.parseInt(SpiralaFinal)));
        TextViewAge2_1.setText(TextViewAge1_2.getText());
        TextViewAge2_2.setText(String.valueOf(9 + Integer.parseInt(TextViewAge2_1.getText().toString())));
        TextViewAge3_1.setText(TextViewAge2_2.getText());
        TextViewAge3_2.setText(String.valueOf(9 + Integer.parseInt(TextViewAge3_1.getText().toString())));
        TextViewAge4_1.setText(TextViewAge3_2.getText());
        
        
        /*מחזורי חיים - מחזור*/
        if(month.equals("11"))
        {
            temp_month = myFuncCalck.pirokFinal(Integer.parseInt(month));
            TextViewCycle1.setText(month + "/" + temp_month);
        }
        else
        	TextViewCycle1.setText(month1);
        
        if ((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19")))
        {
            temp_day = myFuncCalck.pirokFinal(Integer.parseInt(day));
            TextViewCycle2.setText(day + "/" + temp_day);
        }
        else
        	TextViewCycle2.setText(day1);

        TextViewCycle3.setText(TextViewCycle2.getText());

        if ((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19")))
        { 
            temp_year = myFuncCalck.pirokFinal(Integer.parseInt(year1));
            TextViewCycle4.setText(year1 + "/" + temp_year);
        }
        else
        {
        	temp_year = myFuncCalck.pirokFinal(Integer.parseInt(year1));
        	TextViewCycle4.setText(String.valueOf(temp_year));
        }
       
        
        /*מחזורי חיים - שיא*/
        /*שיא 1*/

        if ((month.equals("11")) && ((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            tempCalc = Integer.parseInt(month) + Integer.parseInt(day);
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal = myFuncCalck.pirokFinal(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc = myFuncCalck.pirokAll(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak1 = tempCalc;
        }
        if ((month.equals("11")) && !((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            temp_day = myFuncCalck.pirokAll(Integer.parseInt(day));
            tempCalc = Integer.parseInt(month) + temp_day;
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal = myFuncCalck.pirokFinal(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc = myFuncCalck.pirokAll(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak1 = tempCalc;
        }
        if ((month != ("11")) && ((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            temp_month = myFuncCalck.pirokAll(Integer.parseInt(month));
            tempCalc = temp_month + Integer.parseInt(day);
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal = myFuncCalck.pirokFinal(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc = myFuncCalck.pirokAll(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak1 = tempCalc;
        }
        if ((month != ("11")) && !((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            temp_month = myFuncCalck.pirokAll(Integer.parseInt(month));
            temp_day = myFuncCalck.pirokAll(Integer.parseInt(day));
            tempCalc = temp_month + temp_day;
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal = myFuncCalck.pirokFinal(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc = myFuncCalck.pirokAll(tempCalc);
                TextViewpeak1.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak1 = tempCalc;
        }
        
        /*שיא 2*/
        if (((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && ((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            tempCalc = Integer.parseInt(year1) + Integer.parseInt(day);
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak2 = tempCalc;
        }
        if (((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && !((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            temp_day =  myFuncCalck.pirokAll(Integer.parseInt(day));
            tempCalc = Integer.parseInt(year1) + temp_day;
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak2 = tempCalc;
        }
        if (!((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && ((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            temp_year =  myFuncCalck.pirokAll(Integer.parseInt(year1));
            tempCalc = temp_year + Integer.parseInt(day);
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak2 = tempCalc;
        }
        if (!((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && !((day.equals("11")) || (day.equals("22")) || (day.equals("33")) || (day.equals("13")) || (day.equals("14")) || (day.equals("16")) || (day.equals("19"))))
        {
            temp_year =  myFuncCalck.pirokAll(Integer.parseInt(year1));
            temp_day =  myFuncCalck.pirokAll(Integer.parseInt(day));
            tempCalc = temp_year + temp_day;
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
                tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
            }
            else
            {
                tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak2.setText(Integer.toString(tempCalc));
            }
            tempCalcPeak2 = tempCalc;
        }

        /*שיא 3*/
        tempCalc = tempCalcPeak1 + tempCalcPeak2;
        tempCalc =  myFuncCalck.pirokAll(tempCalc);
        if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
        {
            tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
			TextViewpeak3.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
        }
        else
        {
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
			TextViewpeak3.setText(Integer.toString(tempCalc));
        }

        /*שיא 4*/
        if (((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && ((month.equals("11")) || (month.equals("22")) || (month.equals("33")) || (month.equals("13")) || (month.equals("14")) || (month.equals("16")) || (month.equals("19"))))
        {
            tempCalc = Integer.parseInt(year1) + Integer.parseInt(month);
            tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
            tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
			TextViewpeak4.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
			}
			else
			{
				tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak4.setText(Integer.toString(tempCalc));
			}
		}
        if (((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && !((month.equals("11")) || (month.equals("22")) || (month.equals("33")) || (month.equals("13")) || (month.equals("14")) || (month.equals("16")) || (month.equals("19"))))
        {
            temp_month =  myFuncCalck.pirokAll(Integer.parseInt(month));
			tempCalc = Integer.parseInt(year1) + temp_month;
			tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
            tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
			TextViewpeak4.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
			}
			else
			{
				tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak4.setText(Integer.toString(tempCalc));
			}
        }
        if (!((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && ((month.equals("11")) || (month.equals("22")) || (month.equals("33")) || (month.equals("13")) || (month.equals("14")) || (month.equals("16")) || (month.equals("19"))))
        {
            temp_year =  myFuncCalck.pirokAll(Integer.parseInt(year1));
			tempCalc = temp_year + Integer.parseInt(month);
			tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
            {
            tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
			TextViewpeak4.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
			}
			else
			{
				tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak4.setText(Integer.toString(tempCalc));
			}
        }
        if (!((year1.equals("11")) || (year1.equals("22")) || (year1.equals("33")) || (year1.equals("13")) || (year1.equals("14")) || (year1.equals("16")) || (year1.equals("19"))) && !((month.equals("11")) || (month.equals("22")) || (month.equals("33")) || (month.equals("13")) || (month.equals("14")) || (month.equals("16")) || (month.equals("19"))))
        {
           temp_year =  myFuncCalck.pirokAll(Integer.parseInt(year1));
			temp_month =  myFuncCalck.pirokAll(Integer.parseInt(month));
			tempCalc = temp_year + temp_month;
			tempCalc =  myFuncCalck.pirokAll(tempCalc);
            if ((tempCalc == 11) || (tempCalc == 22) || (tempCalc == 33) || (tempCalc == 13) || (tempCalc == 14) || (tempCalc == 16) || (tempCalc == 19))
           {
            tempCalcFinal =  myFuncCalck.pirokFinal(tempCalc);
			TextViewpeak4.setText(Integer.toString(tempCalc) + "/" + Integer.toString(tempCalcFinal));
			}
			else
			{
				tempCalc =  myFuncCalck.pirokAll(tempCalc);
				TextViewpeak4.setText(Integer.toString(tempCalc));
			}
        }
        
        
        /*מחזורי חיים - אתגר*/
        /*אתגר 1*/
        int tempChallenge=0;
		temp_month = myFuncCalck.pirokFinal(Integer.parseInt(month));
        temp_day = myFuncCalck.pirokFinal(Integer.parseInt(day));
        tempChallenge = temp_month - temp_day;
        tempChallenge =  myFuncCalck.pirokFinal(tempChallenge);
        if(tempChallenge > 0)
            tempChallenge*= -1;
		TextViewChallenge1.setText(Integer.toString(tempChallenge));

        /*אתגר 2*/
        tempChallenge = 0;
		temp_year = myFuncCalck.pirokFinal(Integer.parseInt(year1));
        tempChallenge = temp_year - temp_day;
        tempChallenge =  myFuncCalck.pirokFinal(tempChallenge);
        if (tempChallenge > 0)
            tempChallenge *= -1;
		TextViewChallenge2.setText(Integer.toString(tempChallenge));

		/*אתגר 3*/
        tempChallenge = 0;
		tempChallenge = (Integer.parseInt(TextViewChallenge1.getText().toString())) - (Integer.parseInt(TextViewChallenge2.getText().toString()));
		tempChallenge =  myFuncCalck.pirokFinal(tempChallenge);
        if (tempChallenge > 0)
            tempChallenge *= -1;
		TextViewChallenge3.setText(Integer.toString(tempChallenge));

        /*אתגר 4*/
        tempChallenge = 0;
        tempChallenge = temp_year - temp_month;
        tempChallenge =  myFuncCalck.pirokFinal(tempChallenge);
        if (tempChallenge > 0)
            tempChallenge *= -1;
		TextViewChallenge4.setText(Integer.toString(tempChallenge));
		
		
		/*הצבה של הטקסט כאשר עוברים למסך מחזורי חיים*/
		Personal_year = Current(Personal_year);
		TextView_Personal_year.setText(Personal_year);
		temp_Personal_year = Personal_year;
        Personal_month = Current(Personal_month);
        TextView_Personal_month.setText(Personal_month);
        temp_Personal_month = Personal_month;
        Personal_day = Current(Personal_day);
        TextView_Personal_day.setText(Personal_day);
        temp_Personal_day = Personal_day;
        TextView_Cycle_age.setText(Age);
        
        
        /*********************************************************************/
		
  		Button invokingButton = (Button)findViewById(R.id.save_and_calc);
        invokingButton.setOnClickListener(new OnClickListener() {
        	/********חישוב תאריך עתידי********/
        	public void onClick(View v) {	
        		
        		/*שנה נוכחית*/
        		Current_year = myCalendar_Now.get(Calendar.YEAR);
        		/*חודש נוכחי*/
        		Current_month = 0;
        		Current_month = myCalendar_Now.get(Calendar.MONTH);
        		Current_month += 1;
        		/*יוום נוכחי*/
        		Current_day = myCalendar_Now.get(Calendar.DAY_OF_MONTH);
                
                
                /*day*/
        		edTextDay1 = ( EditText) findViewById(R.id.editTextDay1);
        		String check_day = edTextDay1.getText().toString();
        		if(check_day.equals("")) /*אעני עושה בדיקה, אם השדה הזה ריק, אז אני שם בו את התאריך הנוכחי, כדי שהאפליקציה לא תקרוס במידה ולא הכניסו ערך*/
        			day2 = Current_day;
        		else
        			day2 = Integer.parseInt(edTextDay1.getText().toString());
        		/*month*/
        		edTextMonth1 = ( EditText) findViewById(R.id.EditTextMonth1);
        		String check_month = edTextMonth1.getText().toString();
        		if(check_month.equals("")) /*אעני עושה בדיקה, אם השדה הזה ריק, אז אני שם בו את התאריך הנוכחי, כדי שהאפליקציה לא תקרוס במידה ולא הכניסו ערך*/
        			month2 = Current_month;
        		else
        			month2 = Integer.parseInt(edTextMonth1.getText().toString());
        		/*year*/
        		edTextYear1 = ( EditText) findViewById(R.id.EditTextYear1);
        		String check_year = edTextYear1.getText().toString();
        		if(check_year.equals("")) /*אעני עושה בדיקה, אם השדה הזה ריק, אז אני שם בו את התאריך הנוכחי, כדי שהאפליקציה לא תקרוס במידה ולא הכניסו ערך*/
        			year2 = Current_year;
        		else
        			year2 = Integer.parseInt(edTextYear1.getText().toString());
                
              //***********יום,חודש ושנה אישית**************//
          		temp_Current_year = year2;
          		if (month2 < Integer.parseInt(month.toString()) || (month2 == Integer.parseInt(month.toString()) && day2 < Integer.parseInt(day.toString()))) /*אם עדיין לא חל היום הולדת אז צריך לעשות שנה נוכחית פחות 1*/
                {
        			temp_Current_year--;
                }
          		/*if (Current_month < month2 || (Current_month == month2 && Current_day < day2)) 
                  {
          			temp_Current_year--;
                  }*/
          		temp_Current_year = myFuncCalck.pirokAll(temp_Current_year);
// אבא אמר שבחישוב של שנה אישית, לא מצמצים את היום ואת החודש         		day1_int = Integer.parseInt(day1.toString());
          		day_int = Integer.parseInt(day.toString());
//          		month1_int = Integer.parseInt(month1.toString());
          		month_int = Integer.parseInt(month.toString());
          		Personal_year1 = day_int + month_int + temp_Current_year;
          		/*Personal_year = day1 + month1 + temp_Current_year;
          		Personal_year1 = Integer.parseInt(Personal_year.toString());*/
          		Personal_year1 = myFuncCalck.pirokAll(Personal_year1);
          		
          		/*חודש אישי*/
          		/*Personal_month = Personal_year + Current_month;*/
          		Personal_month1 = Personal_year1 + month2;
          		/*Personal_month = String.valueOf(Personal_year1) + month2;
          		Personal_month1 = Integer.parseInt(Personal_month.toString());*/
          		Personal_month1 = myFuncCalck.pirokAll(Personal_month1);
          		
          		/*יום אישי*/
          		Personal_day1 = Personal_month1 + day2;
          		Personal_day1 = myFuncCalck.pirokAll(Personal_day1);       		
        		
          		
          		Personal_year = String.valueOf(Personal_year1);
          		Personal_month = String.valueOf(Personal_month1);
          		Personal_day = String.valueOf(Personal_day1);
          		
          		
          		Personal_year = Current(Personal_year);
                Personal_month = Current(Personal_month);
                Personal_day = Current(Personal_day);

          		
          		/*הצבה של הטקסט כאשר לוחצים על כפתור "שמור וחשב" כדי לחשב תאריך עתידי או תאריך מהעבר*/
          		TextView_Personal_year.setText(Personal_year);
          		TextView_Personal_month.setText(Personal_month);
          		TextView_Personal_day.setText(Personal_day);
          		
        		/*TextView_Personal_year.setText(String.valueOf(Personal_year1));
                TextView_Personal_month.setText(String.valueOf(Personal_month));
                TextView_Personal_day.setText(String.valueOf(Personal_day1));*/
        			
        	}
        });
        
        
        Button invokingButton1 = (Button)findViewById(R.id.reset);
        invokingButton1.setOnClickListener(new OnClickListener() {
        	
        	public void onClick(View v) {	
        		
        		/*הצבה של הטקסט כאשר לוחצים על כפתור "היום הנוכחי" כדי שזה יחזיר את הנתונים למה שהם היו*/
          		TextView_Personal_year.setText(temp_Personal_year);
          		TextView_Personal_month.setText(temp_Personal_month);
          		TextView_Personal_day.setText(temp_Personal_day);
         	}
        });
		
		
        
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

}
