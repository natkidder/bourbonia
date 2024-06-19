-- pull column names and order from a given table

accept var_table prompt 'Enter table name => "
SELECT COLUMN_NAME, COLUMN_ID
FROM USER_TAB_COLUMNS
WHERE lower(TABLE_NAME) = lower('&var_table')
ORDER BY COLUMN_ID
/
