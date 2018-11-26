### Set up MySQL
mysql -u root -p

# create user
CREATE USER 'orderinguser'@'%' IDENTIFIED BY 'orderorder';

# create databse
;
CREATE DATABASE ordering;
;

# permissions
;
GRANT ALL PRIVILEGES ON ordering.* TO 'orderinguser'@'%';
;
FLUSH PRIVILEGES
;
