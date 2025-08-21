id
user_id
register_time

select DATE (register_time) as register_date,
    count (distinct user_id) as cnt
from register_user
group by DATE (register_time)
having cnt > 1000
order by cnt desc;