-- package my_pkg specification

create or replace package my_pkg is
/************/
  function f_no_op
  (myvar in number)
  return number;
/***********/
  procedure no_op
  (myvar in number);
end;
/

-- package my_pkg body

create or replace package body my_pkg is
/*********/
  function f_no_op (myvar in number)
  return number is
  /* declare variables here */
  begin
    null;
    return myvar;
  exception
    when others then null;
  end;
/********/
  procedure no_op (myvar in number) is
    /* declare variables here */
  begin
    null;
  exception
    when others then null;
  end;
end;
/
