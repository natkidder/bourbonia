drop table golf_r2 cascade constraints
/
drop table golf_pt2 cascade constraints
/
drop table golf_p2
/

create table golf_r2 (
  region varchar2(15) constraint pk_gr2_01 primary key,
  reg_head varchar2(20) constraint uq_gr2_01 unique,
  headquarters varchar2(20) constraint nn_gr2_02 not null,
  comments varchar2(30),
  headcount number(5) constraint ck_gr2_01 check (headcount >= 0),
  profit_goal number(9,2) constraint ck_gr2_02 check (profit_goal >= 1000)
  )
/

create table golf_pt2 (
  prod_type varchar2(20) constraint pk_gpt2_01 primary key,
  prod_desc varchar2(200) constraint nn_gpt2_01 not null,
  depot_loc varchar2(20) constraint un_gpt2_01 unique,
  total_profit number(15,2) constraint ck_gpt2_01 check (total_profit <= 1000000)
  )
/

create table golf_p2 (
  prod_type varchar2(20) constraint fk_p2_01 references golf_pt2(prod_type) on delete set null,
  period number(1) constraint ck_p2_01 check (period > 0),
  profit number (7,2) constraint ck_p2_02 check (profit < 1000000),
  region varchar2(15) constraint fk_p2_02 references golf_r2(region) on delete cascade,
  yearstart date constraint nn_p2_01 not null
  )
/
