-- creating an utilizing a PL/SQL object

accept c1 prompt 'Enter 3 dashes to skip creating the object type: '

--- create type address as object(
---   street varchar2(30),
---   city   varchar2(20),
---   state  char(2),
---   zip    char(5)
---   );

drop table golf_addr;

create table golf_addr (addr address);

insert into golf_addr values(address('4935 Melinda Ct.','Rockville','MD','20853'));
--
-- you need the table alias here
--
select a.addr.street, a.addr.city, a.addr.state, a.addr.zip from golf_addr a;
/
