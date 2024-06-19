-- the nefarious new_time function

alter session
  set nls_date_format = 'dd-mon-rr hh:miam:ss';
select new_time(sysdate,'EDT','GMT') from dual
/
