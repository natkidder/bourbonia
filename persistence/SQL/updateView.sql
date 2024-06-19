/* avoid updating any table whose primary key is being used as a foreign key in the view */

UPDATE (
SELECT A.ACTIVE AS ACTIVE FROM NEEDS_SURVEY_SHARING A INNER JOIN NEEDS_SURVEY B ON A.ID_SURVEY = B.ID
WHERE B.STATUS = 'P' AND A.ACTIVE = 'N')
SET ACTIVE = 'Y'