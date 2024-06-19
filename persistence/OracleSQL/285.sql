-- list of granting common system privileges

-- 1.  tables & related objects

-- index privileges are implied by table privileges

grant create view to user1;
grant drop any view to user1;

grant create any table to user1;
grant alter any table to user1;
grant backup any table to user1;   --
grant lock any table to user1;     --
grant comment any table to user1;  --
grant select any table to user1;
grant insert any table to user1;
grant update any table to user1;
grant delete any table to user1;

grant create any synonym to user1;
grant create public synonym to user1;  -- 

grant create any sequence to user1;
grant alter any sequence to user1;

-- 2. package related objects

grant force transaction to user1;      --
grant force any transaction to user1;  --

grant create any procedure to user1;
grant alter any procedure to user1;
grant execute any procedure to user1;  --

grant create any trigger to user1;
grant alter any trigger to user1;

-- 3.  access objects

grant create session to user1;
grant alter session to user1;
grant restrict session to user1;       --

grant create user to user1;
grant become user to user1;
grant alter user to user1;
grant drop user to user1;

grant create any role to user1;
grant alter any role to user1;
grant drop role to user1;

