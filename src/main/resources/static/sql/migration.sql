CREATE DATABASE IF NOT EXISTS springblog_db;

CREATE USER springblog_user@localhost IDENTIFIED BY 'p4ssword';
GRANT ALL ON springblog_db.* TO springblog_user@localhost;


# USE springblog_db;
#
# INSERT INTO ads (id, title, description)
# VALUES (1, 'Greg likes potato chips', 'He sure does, look at him go!'),
#        (2, 'Yapapi Indian Strap Match Jack', '- Insert rambling Hulkh Hogan promo here -');
