-- setting a multi-field foreign key

alter table golf_profits add constraint fk_gp_01
foreign key (prod_type, period, region, yearstart) references
profits2(prod_type, period, region, yearstart)
/
