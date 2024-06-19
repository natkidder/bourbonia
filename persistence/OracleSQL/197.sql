alter table golf_profits add constraint fk_gp_02
foreign key (prod_type,period,yearstart,region) references
golf_profits2 (prod_type,period,yearstart,region) on delete cascade
/
