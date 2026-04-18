select id, 
    case
        when t.per <= 0.25 then 'CRITICAL'
        when t.per <= 0.50 then 'HIGH'
        when t.per <= 0.75 then 'MEDIUM'
        else 'LOW'
    end as COLONY_NAME
from (select id, percent_rank() over(order by size_of_colony desc) as per from ecoli_data) as t
order by id
    