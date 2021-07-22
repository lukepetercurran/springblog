CREATE DATABASE IF NOT EXISTS springblog_db;

CREATE USER springblog_user@localhost IDENTIFIED BY 'p4ssword';
GRANT ALL ON springblog_db.* TO springblog_user@localhost;