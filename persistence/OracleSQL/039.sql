select distinct substr(mgr,1,2) as mgrGrp from emp
where not mgr is null 
order by mgrGrp desc

/
