select distinct r.car_id
from car_rental_company_car c join car_rental_company_rental_history r on c.car_id = r.car_id
where c.car_type = '세단' and date_format(start_date, '%m') = '10'
order by r.car_id desc