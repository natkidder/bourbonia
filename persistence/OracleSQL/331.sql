-- illustrating subtypes, including comparing subtypes

column population_mo_co format 999,999;
declare
  subtype wholenum1 is number(9);
  subtype wholenum2 is number(10);
  population_mo_co wholenum1;
  population_fx_co wholenum2;
begin
  population_mo_co := 912744;
  dbms_output.put_line('The population of Montgomery County is '
       || population_mo_co);
  population_fx_co := 997378;
  dbms_output.put_line('The population of Fairfax County is '
       || population_fx_co);
  if population_mo_co > population_fx_co then
    dbms_output.put_line('The population of Montgomery County is greater ' ||
         'than that of Fairfax County');
  else
    dbms_output.put_line('The population of Faifax County is greater than ' ||
         'that of Montgomery County');
  end if;
end;
/  
