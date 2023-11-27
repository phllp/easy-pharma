INSERT INTO Usuarios (ID, username, password)
VALUES
    (gen_random_uuid()::uuid, 'usuario1', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario2', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario3', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario4', md5(random()::text)),
    (gen_random_uuid()::uuid, 'usuario5', md5(random()::text));

INSERT INTO cargo (id, titulo, descricao)
VALUES
    (
        'fbe4c65b-4e2a-4979-bd61-cfcab936b886',
        'Farmacêutico',
        'Responsável por fazer coisas de farmacêutico'
    );