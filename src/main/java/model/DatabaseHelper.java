package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper {
    private static Connection connection;
    private static final String DATABASE_USER = "root";
    private static final String DATABASE_PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/bank?useUnicode=true&characterEncoding=utf-8";

    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void initDb() {
        List<String> list = new ArrayList<String>();
        String sqlTableAccount = "create table if not exists `accounts` (" +
                "  `id` bigint primary key," +
                "  `username` varchar (191) not null unique," +
                "  `password` varchar (60) not null," +
                "  `accountNumber` bigint not null," +
                "  `identityCard` varchar(191) not null," +
                "  `balance` double default 50000," +
                "  `phone` varchar (20) not null," +
                "  `email` varchar (191) not null," +
                "  `fullName` varchar(191) CHARACTER SET utf8 COLLATE utf8_general_ci," +
                "  `gender` integer not null," +
                "  `createdAt` bigint not null," +
                "  `updatedAt` bigint not null," +
                "  `status` integer default 0" +
                ");";

        String sqlTableTransaction = "create table if not exists `transactions` (" +
                "  `id` bigint primary key," +
                "  `type` integer not null," +
                "  `amount` double," +
                "  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci," +
                "  `senderAccountNumber` bigint not null," +
                "  `receiverAccountNumber` bigint not null," +
                "  `createdAt` bigint not null," +
                "  `updatedAt` bigint not null," +
                "  `status` integer default 0" +
                ");";

        list.add(sqlTableAccount);
        list.add(sqlTableTransaction);
        for (String str : list) {
            try {
                PreparedStatement stt = DatabaseHelper.getConnection().prepareStatement(str);
                stt.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}