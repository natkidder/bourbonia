/*
Illustrating an internal exception, in this case error no. 6502
*/
set serveroutput on size 4000
declare
  e_compatible exception;
  pragma exception_init(e_compatible, -6502);
  v_num number;
  v_alpha constant varchar(20) := 'five';
begin
  v_num := v_alpha;
exception
  when e_compatible then
    dbms_output.put_line('incompatible data types');
end;
/
