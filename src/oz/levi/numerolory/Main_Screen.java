package oz.levi.numerolory;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Main_Screen extends Activity {
	ListViewAdapter adapter,adapter1;	EditText editsearch;
	Button add_btn;
    ListView Contact_listview;
    ArrayList<Contact> contact_data = new ArrayList<Contact>();
    Contact_Adapter cAdapter;
    DatabaseHandler db;
    String Toast_msg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.main);
	setTitle("רשימת מפות");
	try {
	    Contact_listview = (ListView) findViewById(R.id.list);
	    Contact_listview.setItemsCanFocus(false);
	    add_btn = (Button) findViewById(R.id.add_btn);

	    Set_Referash_Data();

	} catch (Exception e) {
	    // TODO: handle exception
	    Log.e("some error", "" + e);
	}
	add_btn.setOnClickListener(new View.OnClickListener() {

	    @Override
	    public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent add_user = new Intent(Main_Screen.this,
				Main_numrology.class);
		add_user.putExtra("called", "add");
		add_user.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
			| Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(add_user);
		finish();
	    }
	});
	
	
	// Pass results to ListViewAdapter Class
	adapter = new ListViewAdapter(this, contact_data);
	
	// Binds the Adapter to the ListView
	Contact_listview.setAdapter(adapter);
	
	// Locate the EditText in listview_main.xml
	editsearch = (EditText) findViewById(R.id.search);

	// Capture Text in EditText
	editsearch.addTextChangedListener(new TextWatcher() {

		@Override
		public void afterTextChanged(Editable arg0) {
			// TODO Auto-generated method stub
			String text = editsearch.getText().toString().toLowerCase(Locale.getDefault());
			adapter.filter(text.toString().trim());//.trim גורם לזה שיהיה אפשר להקיש רווח וזה לא ייחשב בחיפוש
			Contact_listview.invalidateViews();//זה כדי שהרשימה תתעדכן גם כאשר המקלדת פתוחה
		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1,
				int arg2, int arg3) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub
		}
	});
	
    }

    public void Set_Referash_Data() {
	contact_data.clear();
	db = new DatabaseHandler(this);
	ArrayList<Contact> contact_array_from_db = db.Get_Contacts();

	for (int i = 0; i < contact_array_from_db.size(); i++) {

	    int tidno = contact_array_from_db.get(i).getID();
	    String first_name = contact_array_from_db.get(i).getFirstName();
	    String last_name = contact_array_from_db.get(i).getLastName();
	    String day_birthday = contact_array_from_db.get(i).getDay();
	    String month_birthday = contact_array_from_db.get(i).getMonth();
	    String year_birthday = contact_array_from_db.get(i).getYear();
	    Contact cnt = new Contact();
	    cnt.setID(tidno);
	    cnt.setFirstName(first_name);
	    cnt.setLastName(last_name);
	    cnt.setDay(day_birthday);
	    cnt.setMonth(month_birthday);
	    cnt.setYear(year_birthday);


	    contact_data.add(cnt);
	}
	db.close();
	cAdapter = new Contact_Adapter(Main_Screen.this, R.layout.listview_row,
		contact_data);
	Contact_listview.setAdapter(cAdapter);
	cAdapter.notifyDataSetChanged();
    }
    
    public void Set_Referash_Data_for_update_list_aftet_delete_row() {
    	// Pass results to ListViewAdapter Class
    	adapter1 = new ListViewAdapter(this, contact_data);
    	
    	// Binds the Adapter to the ListView
    	Contact_listview.setAdapter(adapter1);
    	
    	Set_Referash_Data();
    	}

    public void Show_Toast(String msg) {
	Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResume() {
	// TODO Auto-generated method stub
	super.onResume();
	Set_Referash_Data();

    }

    public class Contact_Adapter extends ArrayAdapter<Contact> {
	Activity activity;
	int layoutResourceId;
	Contact user;
	ArrayList<Contact> data = new ArrayList<Contact>();

	public Contact_Adapter(Activity act, int layoutResourceId,
		ArrayList<Contact> data) {
	    super(act, layoutResourceId, data);
	    this.layoutResourceId = layoutResourceId;
	    this.activity = act;
	    this.data = data;
	    notifyDataSetChanged();
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
	    View row = convertView;
	    UserHolder holder = null;

	    if (row == null) {
		LayoutInflater inflater = LayoutInflater.from(activity);

		row = inflater.inflate(layoutResourceId, parent, false);
		holder = new UserHolder();
		holder.name = (TextView) row.findViewById(R.id.user_name_txt);
		holder.birthday = (TextView) row.findViewById(R.id.user_birthday_txt);
		holder.delete = (Button) row.findViewById(R.id.btn_delete);
		row.setTag(holder);
	    } else {
		holder = (UserHolder) row.getTag();
	    }
	    user = data.get(position);
	    holder.delete.setTag(user.getID());
	    holder.name.setText(user.getFirstName() + " " + user.getLastName());
	    holder.birthday.setText(user.getDay() + "/" + user.getMonth() + "/" + user.getYear());

	    
	    holder.delete.setOnClickListener(new OnClickListener() {

		@Override
		public void onClick(final View v) {
		    // TODO Auto-generated method stub

		    // show a message while loader is loading

		    AlertDialog.Builder adb = new AlertDialog.Builder(activity);
		    adb.setTitle("מחיקת לקוח");
		    adb.setMessage("אתה בטוח שאתה רוצה למחוק את הלקוח מהרשימה? ");
		    final int user_id = Integer.parseInt(v.getTag().toString());
		    adb.setNegativeButton("לא", null);
		    adb.setPositiveButton("כן",
			    new AlertDialog.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog,
					int which) {
				    // MyDataObject.remove(positionToRemove);
				    DatabaseHandler dBHandler = new DatabaseHandler(
					    activity.getApplicationContext());
				    dBHandler.Delete_Contact(user_id);
				    Main_Screen.this.onResume();
				    
				    // עם הקוד הזה, זה עובד, אבל זה מפעיל את המסך מההתחלה ויש אנמיצה של זה, אז אני לא רוצה שזה יהיה ככה
				    Intent view_user = new Intent(Main_Screen.this,
							Main_Screen.class);
					startActivity(view_user);

					//הקוד הזה לא עובד טוב, כי גם אחרי שמוחקים את הלקוח, עדיין הוא מופיע ברשימה שעושים חיפוש
				    //Set_Referash_Data_for_update_list_aftet_delete_row();
				}
			    });
		    adb.show();
		}

	    });
	    
	 // Listen for ListView Item Click
 		row.setOnClickListener(new OnClickListener() {

 			@Override
 			public void onClick(View v) {
 			    // TODO Auto-generated method stub
 			    Log.i("Row ListView Clicked", "**********");

 			    Intent update_user = new Intent(activity,
 			    		Main_numrology.class);
 			    update_user.putExtra("called", "update");
 			    int get_id = (contact_data.get(position).getID()); 
 			    update_user.putExtra("USER_ID", (String.valueOf(get_id)));
 			    activity.startActivity(update_user);

 			}
 		    });
	    
	    return row;

	}

	class UserHolder {
	    TextView name;
	    TextView birthday;
	    Button delete;
	}

    }

}
