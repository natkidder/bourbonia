/* fun with aliases */
select profit * 1.12 as "next years goal" from profits2;

select abs(profit) * 0.9 "minimum expected" from profits2
order by "minimum expected";
