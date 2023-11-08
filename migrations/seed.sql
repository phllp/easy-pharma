insert into Usuarios (ID, username, password)
values
    (gen_random_uuid()::uuid, 'usuario1', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario2', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario3', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario4', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario5', md5(random()::text));