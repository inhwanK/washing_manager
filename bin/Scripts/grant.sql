create user 'user_washing_manager'@'localhost' identified by 'rootroot';
drop user 'user_washing_manager'@'localhost';
grant all on washing_manager.* to 'user_washing_manager'@'localhost';
show databases;
show grants for 'user_washing_manager'@'localhost';