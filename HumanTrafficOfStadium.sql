Table: Stadium

+---------------+---------+
| Column Name   | Type    |
+---------------+---------+
| id            | int     |
| visit_date    | date    |
| people        | int     |
+---------------+---------+
visit_date is the column with unique values for this table.
Each row of this table contains the visit date and visit id to the stadium with the number of people during the visit.
As the id increases, the date increases as well.
 

Write a solution to display the records with three or more rows with consecutive id's, and the number of people is greater than or equal to 100 for each.

Return the result table ordered by visit_date in ascending order.



SELECT id, visit_date, people
FROM Stadium
WHERE id IN (
    SELECT s1.id
    FROM Stadium s1
    JOIN Stadium s2 ON s1.id = s2.id - 1
    JOIN Stadium s3 ON s1.id = s3.id - 2
    WHERE s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100

    UNION

    SELECT s2.id
    FROM Stadium s1
    JOIN Stadium s2 ON s1.id = s2.id - 1
    JOIN Stadium s3 ON s1.id = s3.id - 2
    WHERE s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100

    UNION

    SELECT s3.id
    FROM Stadium s1
    JOIN Stadium s2 ON s1.id = s2.id - 1
    JOIN Stadium s3 ON s1.id = s3.id - 2
    WHERE s1.people >= 100 AND s2.people >= 100 AND s3.people >= 100
)
ORDER BY visit_date;
