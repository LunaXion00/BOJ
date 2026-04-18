select t.id
from ecoli_data f join ecoli_data s ON f.id = s.parent_id
join ecoli_data t ON t.parent_id = s.id
where f.parent_id is NULL
order by t.id