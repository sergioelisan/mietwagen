use `mietwagen`;

create table `client` (
	`id` int unsigned not null auto_increment,
	`name` varchar(64) not null,
	`cpf` varchar(11) not null,

	primary key (`id`)
);

create table `rent` (
	`id` int unsigned not null auto_increment,
	`client_id` int unsigned not null,
	`car_id` int unsigned not null,
	`start` date not null,
	`delivery` date not null,
	`paid` tinyint not null default 0,
	`delivered` tinyint not null default 0,
	`observations` varchar(256),

	primary key(`id`)
);

create table `car` (
	`id` int unsigned not null auto_increment,
	`plate` varchar(64) not null,
	`model` varchar(64) not null,
	`observations` varchar(256),

	primary key (`id`)
);

alter table `rent` add constraint `fk_client` foreign key (`client_id`) references `client` (`id`);
alter table `rent` add constraint `fk_car` foreign key (`car_id`) references `car` (`id`);