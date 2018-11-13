### Set up MySQL
mysql -u root -p

# create user
CREATE USER 'orderinguser'@'localhost' IDENTIFIED BY 'orderorder';

# create databse
;
CREATE DATABASE ordering;
;

# permissions
;
GRANT ALL PRIVILEGES ON ordering.* TO 'orderinguser'@'localhost';
;
FLUSH PRIVILEGES;
