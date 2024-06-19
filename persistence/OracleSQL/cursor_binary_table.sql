declare
  cursor c_reg is select * from golf_r2;
  type itbl_type is table of c_reg%rowtype index by binary_integer;
  t_reg itbl_type;
begin
  open c_reg;
  loop
    fetch c_reg into t_reg(1);
    exit when c_reg%notfound;
  end loop;
  close c_reg;
end;
/
