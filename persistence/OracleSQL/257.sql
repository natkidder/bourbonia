drop table profits;
drop table unit_sales;
drop table product_types;
drop table prices;

create table product_types (
  product_type varchar2(20),
  product_desc clob,
  constraint pk_ptypes_01 primary key (product_type)
  );

create table prices (
  product_name varchar2(40),
  product_price number(9,2),
  constraint pk_prices_01 primary key (product_name),
  constraint ck_prices_01 check (product_price >= 0)
  );

create table unit_sales (
  product_name varchar2(40) not null,
  unit_sale number(9),
  quarter number(2),
  constraint pk_usales_01 primary key (product_name, quarter),
  constraint ck_usales_01 check (unit_sale >= 0),
  constraint fk_usales_01 foreign key (product_name) references prices(product_name)
  );

create table profits (
  product_name varchar2(40),
  product_type varchar2(20) not null,
  quarter number(2),
  constraint pk_profits_01 primary key (product_name),
  constraint ck_profits_01 check (quarter between 1 and 4),
  constraint fk_profits_01 foreign key (product_type) references product_types(product_type) on delete set null,
  constraint fk_profits_02 foreign key (product_name) references prices(product_name),
  constraint fk_profits_03 foreign key (product_name,quarter) references unit_sales(product_name, quarter)
  );
