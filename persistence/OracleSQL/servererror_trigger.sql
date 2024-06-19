/* trigger that fires from a servererror */

create or replace trigger servererror_trigger
after servererror on database
declare
  v_msg varchar2(30) := 'server error from trigger';
begin
  dbms_output.put_line(to_char(sysdate) || '  ' || v_msg);
exception
  when others then null;
end;
