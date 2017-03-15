package com.novauc;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    /*******************************
     * Singleton methods and fields
     *******************************/
    private static Database database = new Database();

    private Database(){
        //private constructor ensures that you can't make a new database object
    }

    public static Database getInstance(){
        return database;
        //This is the only way you can get an instance of database
    }

    /*******************************
     * Database connection
     ******************************/

    public Connection getConnection() throws SQLException{
        Connection connection = DriverManager.getConnection("jdbc:h2:./main");
        return connection;
    }
    public void createTables() throws SQLException{
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS users(id IDENTITY, name VARCHAR, password VARCHAR)");
        statement.execute("CREATE TABLE IF NOT EXISTS posts(id IDENTITY, message VARCHAR, user_id INTEGER)");
    }

    /*******************************
     * User SQL methods
     *******************************/
    public boolean insertUser(String userName, String password) throws SQLException{
        Connection connection = getConnection();
        ArrayList<User> users = selectUser();
        for (User user: users){
            if (user.getUserName().equals(userName)) {
                return false;
            }
        }
        PreparedStatement statement = connection.prepareStatement("INSERT INTO users VALUES(NULL, ?, ?)");
        statement.setString(1, userName);
        statement.setString(2, password);
        statement.execute();
        return true;
    }
    public User selectUser(int userId) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
        statement.setInt(1, userId);
        ResultSet results = statement.executeQuery();

        User user = null;
        while(results.next()){
            user = new User(results.getString("name"), results.getInt("id"));
        }
        if (user != null){
            user.setPosts(selectUserPosts(user.getId()));
        }
        return user;
    }
    public ArrayList<User> selectUser() throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
        ResultSet results = statement.executeQuery();
        ArrayList<User> users = new ArrayList<>();
        while(results.next()){
            users.add(new User(results.getString("name"), results.getInt("id")));
        }
        return users;
    }
    public int verifyUser(String userName, String password) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE name = ?");
        statement.setString(1, userName);

        ResultSet results = statement.executeQuery();
        String storedPass = null, storedName = null;
        int userId = 0;
        while(results.next()){
            storedName = results.getString("name");
            storedPass = results.getString("password");
            userId = results.getInt("id");
        }
        if (storedName == null || storedPass == null){
            return -1;
        }
        if (storedName.equals(userName) && storedPass.equals(password)){
            return userId;
        }
        return -1;
    }

    /*******************************
     * Post SQL methods
     *******************************/

    public void insertPost(String message, int userId) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("INSERT INTO posts VALUES(NULL, ?, ?)");
        statement.setString(1, message);
        statement.setInt(2, userId);
        statement.execute();
    }
    public Post selectPost(int id) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts WHERE id = ?");
        statement.setInt(1,id);

        ResultSet results = statement.executeQuery();
        Post post = null;
        while(results.next()){
            post = new Post(results.getString("message"), results.getInt("id"), results.getInt("user_id"));
        }
        return post;
    }
    public ArrayList<Post> selectUserPosts(int userId) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts WHERE user_id = ?");
        statement.setInt(1,userId);

        ResultSet results = statement.executeQuery();
        ArrayList<Post> posts = new ArrayList<>();
        while(results.next()){
            posts.add(new Post(results.getString("message"), results.getInt("id"), results.getInt("user_id")));
        }
        return posts;
    }
    public ArrayList<Post> selectPost() throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM posts");

        ResultSet results = statement.executeQuery();
        ArrayList<Post> posts = new ArrayList<>();
        while(results.next()){
            posts.add(new Post(results.getString("message"), results.getInt("id"), results.getInt("user_id")));
        }
        return posts;
    }
    public void removePost(int id) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("DELETE FROM posts WHERE id = ? ");
        statement.setInt(1, id);
        statement.execute();
    }
    public void updatePost(int id, String message) throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("UPDATE posts SET message = ? WHERE id = ?");
        statement.setString(1, message);
        statement.setInt(2, id);
        statement.execute();
    }
    public ArrayList<Post> selectJoinPost() throws SQLException{
        Connection connection = getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT users.name, posts.message, posts.id FROM posts JOIN users ON posts.user_id = users.id");

        ResultSet results = statement.executeQuery();
        ArrayList<Post> posts = new ArrayList<>();
        while(results.next()){
            posts.add(new Post(results.getString("message"), results.getInt("id"), results.getString("name")));
        }
        return posts;
    }
}
