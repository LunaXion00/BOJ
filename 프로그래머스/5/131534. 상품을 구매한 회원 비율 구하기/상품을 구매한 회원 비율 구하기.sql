select year(o.sales_date) as year, month(o.sales_date) as month, COUNT(DISTINCT i.USER_ID) AS PUCHASED_USERS, ROUND(COUNT(DISTINCT i.USER_ID)/(SELECT COUNT(*) FROM USER_INFO WHERE joined LIKE '2021%'), 1) AS PUCHASED_RATIO
from user_info i join online_sale o on i.user_id = o.user_id
where year(i.joined) = '2021'
group by year, month
order by year, month