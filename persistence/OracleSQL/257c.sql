create or replace view profits_view as (
  select a.product_name, a.product_type, b.product_desc, c.product_price,
    d.unit_sale, a.quarter
  from profits a, product_types b, prices c, unit_sales d
  where a.product_type = b.product_type
  and a.product_name = c.product_name
  and a.product_name = d.product_name
  and a.quarter = d.quarter
  )
/
