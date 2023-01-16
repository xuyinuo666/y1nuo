local key = KEYS[1];

if redis.call('GET',key) == nil then
    return false;
else
    return redis.call('DEL',key) > 0;
end