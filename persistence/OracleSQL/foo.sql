declare
begin
  insert into companies (COMPANY_NAME) values ('Gannett');
  declare
  begin
    insert into companies (COMPANY_NAME) values ('IKON');
  end;
end;


