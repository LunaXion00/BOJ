select ROUND(avg(IFNULL(length, 10)), 2) as average_length
from fish_info