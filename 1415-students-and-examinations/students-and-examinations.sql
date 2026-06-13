# Write your MySQL query statement below
-- SELECT s.student_id, s.student_name, sb.subject_name, count(e.student_id) as attended_exams
-- FROM Students s CROSS JOIN Subjects sb LEFT JOIN Examinations e ON s.student_id = e.student_id AND sb.subject_name = e.subject_name
-- GROUP BY sb.subject_name, s.student_id
-- ORDER BY s.student_id, sb.subject_name;

select s.student_id, s.student_name, sb.subject_name, count(e.student_id) as attended_exams
from Students s cross join Subjects sb Left Join Examinations e on s.student_id = e.student_id AND sb.subject_name = e.subject_name
group by s.student_id, sb.subject_name 
order by s.student_id, sb.subject_name