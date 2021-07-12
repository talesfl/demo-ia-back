INSERT INTO USER (
    USER_ID, 
    ADMIN, 
    CREATE_DATE, 
    EMAIL, 
    LOGIN, 
    NAME, 
    PASSWORD, 
    UPDATE_DATE 
) VALUES (
    1,
    1,
    (SELECT LOCALTIMESTAMP),
    'admin@admin.com.br',
    'admin',
    'admin',
    '$2a$10$AefMS7zeYFtFktzgjJpCju9ixFIxBawyR207UtYIg4JqA/udKG10i', -- 123
    (SELECT LOCALTIMESTAMP)
)
