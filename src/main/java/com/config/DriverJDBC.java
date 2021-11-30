package com.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;

import com.dao.VilleDAO;
import com.dao.VilleDAOImpl;

public class DriverJDBC {
	
	private static final String loginRoot = "root";
	private static final String passwordRoot = "root";
	private static final String urlDb = "jdbc:mysql://localhost:8889/exercice1";
	
    private String url = "";
	private String username = "";
	private String password = "";
	
	DriverJDBC(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }
	
	public static DriverJDBC getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        DriverJDBC instance = new DriverJDBC(urlDb, loginRoot, passwordRoot);
        return instance;
    }

	@Bean
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public VilleDAO getVilleDao() {
        return new VilleDAOImpl(this);
    }
}
