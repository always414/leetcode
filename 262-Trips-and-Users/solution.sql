# Write your MySQL query statement below

select t.Request_at as Day, round(sum(case when t.Status like 'cancelled_%' then 1 else 0)/count(*)), 2) as Rate
from Trips t
inner join users u
on t.client_id = u.users_id and u.Banned = 'No'
where t.Request_at between '2013-10-01' and '2013-10-03'
group by t.request_at

