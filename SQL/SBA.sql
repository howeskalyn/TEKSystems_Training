-- list each department and number of courses offered by that department
select d.name 'Department Name', count(c.id) 'Course Count'
from department d
join course c on d.id = c.deptid
group by d.name
order by count(c.id) asc, d.name asc;

-- list name of each course and the number of students in that course
-- sort by number of students, descending & then course name ascending
select c.name 'Course Name', count(sc.studentId) 'Number of Students'
from course c
join studentcourse sc on c.id = sc.courseId
group by c.name
order by count(sc.studentId) desc, c.name asc;

-- list names of all courses where number of faculty assigned to them is 0
-- sort by course name in alphabetical order
-- where courseId will not have a matching facultyId in facultycourse table
select name 'Course Name'
from course
where id not in (select courseId from facultycourse)
group by name
order by name asc;

-- list the course names and the number of students in those courses 
-- for all courses where there are no assigned faculty
-- sort by number of students descending & then by course name ascending
select c.name 'Course Name', count(sc.studentId) 'Number of Students'
from course c
join studentcourse sc on c.id = sc.courseId
where c.id not in (select courseId from facultycourse)
group by c.name
order by count(sc.studentId) desc, c.name asc;

-- list the total number of students enrolled in classes during each school year
-- column names: "Students" "Year"
-- sort by school year ascending, then number of students descending
-- use year() function on startDate in studentcourse
select count(distinct studentId) 'Students', year(startDate) 'Year'
from studentcourse
group by year(startDate)
order by year(startDate) asc, count(distinct studentId) desc;

-- list the start date and total number of students who enrolled
-- in classes in august of each year: where month(startDate) is August
-- sort by start date ascending, then by number of students ascending
select startDate 'Start Date', count(distinct studentId) 'Total Students'
from studentcourse
where month(startDate) = 08
group by startDate
order by startDate asc, count(distinct studentId) asc;

-- list students' first name, last name, and number of courses they are taking
-- that are within their major department
-- sort by number of courses descending, first name ascending, then by last name ascending
-- need count of courses where student.majorId = course.deptId
select s.firstname 'First Name', s.lastname 'Last Name', count(sc.courseId) 'Courses in Major'
from student s
join studentcourse sc on sc.studentId = s.id
join course c on c.id = sc.courseId
where s.majorId = c.deptId
group by s.firstname, s.lastname
order by count(sc.courseId) desc, s.firstname asc, s.lastname asc;

-- list first name, last name, and average progress (rounded to 1 decimal place)
-- of students having an average progress less than 50%
-- sort by average progress descending, first name ascending, then last name ascending
-- avg(progress) from studentcourse table
select s.firstname 'First Name', s.lastname 'Last Name', round(avg(sc.progress), 1) 'Average Progress'
from student s
join studentcourse sc on sc.studentId = s.id
group by sc.studentId
having round(avg(sc.progress),1) < 50
order by round(avg(sc.progress),1) desc, s.firstname asc, s.lastname asc;

-- list course name and average progress (rounded to 1 decimal place)
-- of students in that course
-- sort by average progress descending, then course name ascending
select c.name 'Course Name', round(avg(sc.progress), 1) 'Average Progress'
from course c
join studentcourse sc on sc.courseId = c.id
group by c.name
order by round(avg(sc.progress), 1) desc, c.name asc;

-- list course name and average progress (rounded to 1 decimal place) of the course 
-- with the highest average progress in the system
-- get all average progresses per course, sort descending & limit to 1 -> will return max
select c.name 'Course Name', round(avg(sc.progress), 1) 'Average Progress'
from course c
join studentcourse sc on sc.courseId = c.id
group by c.name
order by round(avg(sc.progress), 1) desc
limit 1;

-- list the faculty first name, last name, and average progress (rounded to 1 decimal place)
-- made over all of their courses
-- sort by average progress descending, first name ascending, then last name ascending
-- need to join tables: faculty, facultycourse, course & studentcourse
select f.firstname 'First Name', f.lastname 'Last Name', round((avg(sc.progress)), 1) 'Average Progress'
from faculty f
join facultycourse fc on fc.facultyId = f.id
join course c on c.id = fc.courseId
join studentcourse sc on sc.courseId = c.id
group by f.firstname, f.lastname
order by round((avg(sc.progress)), 1) desc, f.firstname asc, f.lastname asc;

-- list student's first name, last name, minimum grade (based on minimum progress)
-- and maximum grade (based on maximum progress) -> need case statement!
-- sort by minimum grade descending, maximum grade descending, first name ascending
-- and finally last name ascending
select s.firstname 'First Name', s.lastname 'Last Name', 
case
	when min(progress) < 40 then 'F'
    when min(progress) < 50 then 'D'
    when min(progress) < 60 then 'C'
    when min(progress) < 70 then 'B'
    when min(progress) >= 70 then 'A'
end as minimumGrade,
case
	when max(progress) < 40 then 'F'
    when max(progress) < 50 then 'D'
    when max(progress) < 60 then 'C'
    when max(progress) < 70 then 'B'
    when max(progress) >= 70 then 'A'
end as maximumGrade
from student s
join studentcourse sc on sc.studentId = s.id
group by sc.studentId
order by minimumGrade desc, maximumGrade desc, s.firstname asc, s.lastname asc;



