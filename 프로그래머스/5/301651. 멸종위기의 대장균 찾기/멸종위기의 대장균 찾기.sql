with recursive gen as (
    select id, parent_id, 1 as GENERATION
    from ecoli_data
    where parent_id is null
    
    union all
    
    select e.id, e.parent_id, g.generation+1
    from ecoli_data e inner join gen g on e.parent_id = g.id
)

select count(*) as COUNT, GENERATION
from gen
where not exists ( select 1 from ecoli_data where ecoli_data.parent_id = gen.id)
group by generation
order by generation