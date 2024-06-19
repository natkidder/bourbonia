create table employee (
  empid varchar2(5) primary key,
  lastname varchar2(25) not null,
  firstname varchar2(25),
  salary number(10,4) check (salary <= 250000),
  department_num number(5)
    references department(department_num) on delete set null,
  govt_id number(10) unique
  )
/
