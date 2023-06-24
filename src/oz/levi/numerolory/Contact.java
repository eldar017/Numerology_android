package oz.levi.numerolory;

public class Contact {

    // private variables
    public int _id;
    public String _first_name;
    public String _last_name;
    public String _day_birthday;
    public String _month_birthday;
    public String _year_birthday;

    public Contact() {
    }

    // constructor
    public Contact(int id, String _first_name, String _last_name, String _day_birthday, String _month_birthday, String _year_birthday) {
	this._id = id;
	this._first_name = _first_name;
	this._last_name = _last_name;
	this._day_birthday = _day_birthday;
	this._month_birthday = _month_birthday;
	this._year_birthday = _year_birthday;
    }

    // constructor
    public Contact(String _first_name, String _last_name, String _day_birthday, String _month_birthday, String _year_birthday) {
	this._first_name = _first_name;
	this._last_name = _last_name;
	this._day_birthday = _day_birthday;
	this._month_birthday = _month_birthday;
	this._year_birthday = _year_birthday;
    }

    // getting ID
    public int getID() {
	return this._id;
    }

    // setting id
    public void setID(int id) {
	this._id = id;
    }

    
    // getting first_name
    public String getFirstName() {
	return this._first_name;
    }

    // setting first_name
    public void setFirstName(String first_name) {
	this._first_name = first_name;
    }
    
    
    // getting _last_name
    public String getLastName() {
	return this._last_name;
    }

    // setting _last_name
    public void setLastName(String last_name) {
	this._last_name = last_name;
    }
    
    // getting full name
    public String getFullName() {
	return this._first_name + " " +  this._last_name;
    }
    
    // getting _day_birthday
    public String getDay() {
	return this._day_birthday;
    }

    // setting _day_birthday
    public void setDay(String day_birthday) {
	this._day_birthday = day_birthday;
    }
    
    
    // getting _month_birthday
    public String getMonth() {
	return this._month_birthday;
    }

    // setting _month_birthday
    public void setMonth(String month_birthday) {
	this._month_birthday = month_birthday;
    }
    
    
    // getting _year_birthday
    public String getYear() {
	return this._year_birthday;
    }

    // setting _year_birthday
    public void setYear(String year_birthday) {
	this._year_birthday = year_birthday;
    }

   

}