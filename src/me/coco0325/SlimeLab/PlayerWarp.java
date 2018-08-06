package me.coco0325.SlimeLab;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import net.md_5.bungee.api.ChatColor;

public class PlayerWarp extends JavaPlugin {
	
	public static PlayerWarp plugin;
	private Connection connection;
	private String host, database, username, password;
	public int port;
	public FileConfiguration config;

	
	public void onEnable() {
		plugin = this;
		mysqlSetup();
	}
	public void onDisable() {
		
	}
	
	public void mysqlSetup() {
		try {
			synchronized (this) {
				if (connection != null && !connection.isClosed()) {
					return;
				}

				Class.forName("com.mysql.jdbc.Driver");
				MysqlDataSource dataSource = new MysqlDataSource();
				dataSource.setServerName(this.host);
				dataSource.setPort(this.port);
				dataSource.setDatabaseName(this.database);
				dataSource.setUser(this.username);
				dataSource.setPassword(this.password);
				dataSource.setAutoReconnect(true);
				connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement("CREATE TABLE IF NOT EXISTS BungeePlayerWarp (UUID VARCHAR(36), NAME VARCHAR(100), SERVER VARCHAR(20), WORLD VARCHAR(20), X INT, Y INT, Z INT, DATE BIGINT)");
				statement.executeUpdate();
				Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "MYSQL 已連接");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		mysqlSetup();
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}
}
