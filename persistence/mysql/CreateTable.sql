CREATE TABLE IF NOT EXISTS Movies  (
  title VARCHAR(50),
  year INTEGER,
  price FLOAT(24, 2),
  PRIMARY KEY( title, year )
);

CREATE TABLE IF NOT EXISTS Acquantances  (
	f_name VARCHAR(20), 
	l_name VARCHAR(20), 
	mi VARCHAR(1), 
	street VARCHAR(50), 
	street2 VARCHAR(50), 
	city VARCHAR(30), 
	state VARCHAR(2), 
	zip VARCHAR(10), 
	h_phone VARCHAR(20), 
	d_phone VARCHAR(20), 
	email VARCHAR(50), 
	spouse VARCHAR(45), 
	comments VARCHAR(250),
	PRIMARY KEY (f_name, mi, l_name)
);
