create table if not exists `accounts` (
  `id` bigint primary key,
  `username` varchar (250) not null unique,
  `password` varchar (30) not null,
  `accountNumber` bigint not null,
  `identityCard` bigint not null,
  `balance` double default 100000,
  `phone` varchar (20) not null,
  `email` varchar (250) not null,
  `fullName` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci,
  `gender` integer not null,
  `createdAt` bigint not null,
  `updatedAt` bigint not null,
  `status` integer default 0
);


create table if not exists `transactions` (
  `id` bigint primary key,
  `type` integer not null,
  `amount` double,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci,
  `senderAccountNumber` bigint not null,
  `receiverAccountNumber` bigint not null,
  `createdAt` bigint not null,
  `updatedAt` bigint not null,
  `status` integer default 0
);

