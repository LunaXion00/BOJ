with log as (
    select c.daily_fee, c.car_type, h.history_id, datediff(h.end_date, h.start_date)+1 as period, 
    case 
        when datediff(h.end_date, h.start_date)+1 >= 90 then '90일 이상'
        when datediff(h.end_date, h.start_date)+1 >= 30 then '30일 이상'
        when datediff(h.end_date, h.start_date)+1 >= 7 then '7일 이상'
        else null
    end as duration_type
    from car_rental_company_car c join car_rental_company_rental_history h on c.car_id = h.car_id
    where c.car_type = '트럭')

select log.history_id, round(log.period * log.daily_fee * (100 - ifnull(discount_rate, 0))/100) as fee
from log left join car_rental_company_discount_plan p on log.duration_type = p.duration_type and log.car_type = p.car_type
order by fee desc, log.history_id desc