package model;

import entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountModel {
    public Account findByUsernameAndStatus(String username, Account.Status status) {
        try {
            PreparedStatement stt = DatabaseHelper.getConnection().prepareStatement("select * from `accounts` where `username` = ? and `status` = ?");
            stt.setString(1, username);
            stt.setInt(2, status.getStatus());
            ResultSet rs = stt.executeQuery();
            if (rs.next()) {
                return new Account(rs.getLong("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getLong("accountNumber"),
                        rs.getString("identityCard"),
                        rs.getDouble("balance"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("fullName"),
                        rs.getInt("gender"),
                        rs.getLong("createdAt"),
                        rs.getLong("updatedAt"),
                        rs.getInt("stauts")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean insertAccount(Account a) {
        try {
            PreparedStatement stt = DatabaseHelper.getConnection()
                    .prepareStatement("insert into `accounts` (id, username ,password, accountNumber, identityCard, balance, phone, email, fullName, gender, createdAt, updatedAt, status) values " +
                            "(?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stt.setLong(1, a.getId());
            stt.setString(2, a.getUsername());
            stt.setString(3, a.getPassword());
            stt.setLong(4, a.getAccountNumber());
            stt.setString(5, a.getIdentityCard());
            stt.setDouble(6, a.getBalance());
            stt.setString(7, a.getPhone());
            stt.setString(8, a.getEmail());
            stt.setString(9, a.getFullName());
            stt.setInt(10, Account.Gender.findByCode(a.getGender()).getGender());
            stt.setLong(11, a.getCreatedAt());
            stt.setLong(12, a.getUpdatedAt());
            stt.setInt(13, Account.Status.findByType(a.getStauts()).getStatus());
            stt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}