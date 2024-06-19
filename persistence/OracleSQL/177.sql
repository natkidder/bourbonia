-- mass update

update golf_regions set profit_goal = 1000 where region = 'northeast';
update golf_regions set profit_goal = 2000 where region = 'southeast';
update golf_regions set profit_goal = 3000 where region = 'midwest';
update golf_regions set profit_goal = 4000 where region = 'northwest';
update golf_regions set profit_goal = 5000 where region = 'south central';
