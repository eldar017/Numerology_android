package oz.levi.numerolory;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;


public class ListViewAdapter extends BaseAdapter {
	
	int layoutResourceId1;
	Activity activity1;
	Contact user;
	ArrayList<Contact> data1 = new ArrayList<Contact>();
	
	// Declare Variables
	Context mContext;
	LayoutInflater inflater;
	private List<Contact> contact_data = null;
	private ArrayList<Contact> arraylist;

	public ListViewAdapter(Context context, List<Contact> contact_data) {
		mContext = context;
		this.contact_data = contact_data;
		inflater = LayoutInflater.from(mContext);
		this.arraylist = new ArrayList<Contact>();
		this.arraylist.addAll(contact_data);
	}

	public class ViewHolder {
		TextView name;
	    TextView birthday;
	    Button delete;
	}

	@Override
	public int getCount() {
		return contact_data.size();
	}

	@Override
	public Contact getItem(int position) {
		return contact_data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}
	
	public class Contact_Adapter extends ArrayAdapter<Contact> {

		public Contact_Adapter(Activity act, int layoutResourceId,
			ArrayList<Contact> data) {
		    super(act, layoutResourceId, data);
		    layoutResourceId1 = layoutResourceId;
		    activity1 = act;
		    data1 = data;
		    //notifyDataSetChanged();
		}
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
	    View row = convertView;
	    ViewHolder holder = null;

	    if (row == null) {
		LayoutInflater inflater = LayoutInflater.from(activity1);

		row = inflater.inflate(layoutResourceId1, parent, false);
		holder = new ViewHolder();
		holder.name = (TextView) row.findViewById(R.id.user_name_txt);
		holder.birthday = (TextView) row.findViewById(R.id.user_birthday_txt);
		holder.delete = (Button) row.findViewById(R.id.btn_delete);
		row.setTag(holder);
	    } else {
		holder = (ViewHolder) row.getTag();
	    }
	    user = data1.get(position);
	    holder.delete.setTag(user.getID());
	    holder.name.setText(user.getFirstName() + " " + user.getLastName());
	    holder.birthday.setText(user.getDay() + "/" + user.getMonth() + "/" + user.getYear());

	    return row;
	}
  

	// Filter Class
	public void filter(String charText) {
		charText = charText.toLowerCase(Locale.getDefault());
		contact_data.clear();
		if (charText.length() == 0) {
			contact_data.addAll(arraylist);
		} 
		else 
		{
			for (Contact wp : arraylist) 
			{
				if (wp.getFullName().toLowerCase(Locale.getDefault()).contains(charText))
				{
					contact_data.add(wp);
				}
			}
		}
		notifyDataSetChanged();
	}

}
