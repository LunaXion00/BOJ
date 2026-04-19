select d.dept_id, d.dept_name_en, round(avg(e.sal)) as avg_sal
from hr_department d join hr_employees e on d.dept_id = e.dept_id
group by d.dept_id, d.dept_name_en
order by avg_sal desc