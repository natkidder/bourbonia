/*
1: not sure--maybe waiting on children 
10: Waiting on Dependencies (?)
11: Waiting on children 
51: Active 
103: completed abnormally 
105: orphaned
106: aborted 
108: timed out 
109: cancelled 
*/
/*set linesize 200;*/
/*set pagesize 0;*/
select jmc.JobMst_Name as ChildJob, jm.JobMst_Name as ParentJob, 
jr.JobRun_EstTime, jr.JobRun_Time, jr.JobRun_Status, 
jr.JobRun_Duration, um.UsrMst_FullName
from Tidal.JobMst jm, Tidal.JobRun jr, Tidal.UsrMst um, Tidal.JobMst 
jmc
where jmc.JobMst_ID = jr.JobMst_ID and jr.JobCLS_ID = um.UsrMst_ID (+)
and SYSDATE - jr.JobRun_EstTime < 1.5 AND SYSDATE - jr.JobRun_EstTime 
> 0 and jm.JobMst_ID = jmc.JobMst_PRNTID(+)  
and jm.JobMst_Name in (
  select jm.JobMst_Name  
  from Tidal.JobMst jm, Tidal.JobRun jr 
  where jm.JobMst_ID = jr.JobMst_ID
  and (jr.JobRun_Status <> 101 and jr.JobRun_Status <> 11 and 
jr.JobRun_Status <> 10) 
  and lower(jm.JobMst_Name) like '%edf%wn%p %' 
  and not lower(jm.JobMst_Name) like '% ins %' 
  and not lower(jm.JobMst_Name) like '%gs ulc%'
  and SYSDATE - jr.JobRun_EstTime < 1.5 AND SYSDATE - 
jr.JobRun_EstTime > 0 
  )
order by jm.JobMst_Name, jr.JobRun_EstTime, jmc.JobMst_Name;
