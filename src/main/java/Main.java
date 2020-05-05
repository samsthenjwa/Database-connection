import java.sql.*;

public class Main {
    public static void main(String[] args)throws ClassNotFoundException,IllegalAccessException{
        String url = "jdbc:pstgresql:localhost:5432/";// Database address
        String user = "posgres"; //Database user
        String password = ""; // password of a database

        //Declaring Queries
        String Query1,Query2,Query3,Query4,Query5,Query6,Query7,Query8,Query9,Query10,Query11,Query12,Query13,Query14,
                Query15,Query16,Query17;

        //Initializing Queries
         Query1 = "SELECT * FROM Customers";
         Query2 = "SELECT FirstName , LastName FROM Customers";
         Query3 = "SELECT FirstName, LastName FROM Customers WHERE CustomerID = 1";
         Query4 = "UPDATE Customers SET FirstName = 'Lerato', LastName = 'Mabitso'  WHERE CustomerID = 1";
         Query5 = "DELETE FROM Customers WHERE CustomerID = 2;";
         Query6 = "SELECT COUNT(Status) FROM Orders;";
         Query7 = "SELECT MAX(Amount) FROM Payments;";
         Query8 = "SELECT * FROM Customers ORDER BY Country;";
         Query9 = "SELECT * FROM Products WHERE BuyPrice BETWEEN 100 AND 600;";
         Query10 = "SELECT * FROM Customers WHERE City = 'Berlin' AND Country = 'Germany'";
         Query11 = "SELECT * FROM Customers WHERE City = 'Durban' OR City = 'Cape Town';";
         Query12 = "SELECT * FROM Products WHERE BuyPrice > 500;";
         Query13 = "SELECT SUM(Amount) FROM Payments;";
         Query14 = "SELECT COUNT(Status) FROM Orders WHERE Status = 'Shipped';";
         Query15 = "SELECT AVG(BuyPrice) AS Rands, AVG(BuyPrice * 12) AS  Dollars FROM Products;";
         Query16 = "SELECT * FROM Payments INNER JOIN Customers ON Payments.CustomerID = Customers.CustomerID;";
         Query17 = "SELECT * FROM Products WHERE Description LIKE 'Turnable front wheels%';";



        try { //opening of try and catch statement
            Class.forName("com.postgresql.jdbc.Driver");// calling postgresql driver
            Connection myCon = DriverManager.getConnection(url,user,password);

            Statement statement = myCon.createStatement();
            ResultSet results1 = statement.executeQuery(Query1);
            ResultSet results2 = statement.executeQuery(Query2);
            ResultSet results3 = statement.executeQuery(Query3);
            PreparedStatement preparedStatement1 = myCon.prepareStatement(Query4);
            PreparedStatement preparedStatement2 = myCon.prepareStatement(Query5);
            PreparedStatement preparedStatement3 = myCon.prepareStatement(Query6);
            PreparedStatement preparedStatement4 = myCon.prepareStatement(Query7);
            PreparedStatement preparedStatement5 = myCon.prepareStatement(Query8);
            PreparedStatement preparedStatement6 = myCon.prepareStatement(Query9);
            PreparedStatement preparedStatement7 = myCon.prepareStatement(Query10);
            PreparedStatement preparedStatement8 = myCon.prepareStatement(Query11);
            PreparedStatement preparedStatement9 = myCon.prepareStatement(Query12);
            PreparedStatement preparedStatement10 = myCon.prepareStatement(Query13);
            PreparedStatement preparedStatement11 = myCon.prepareStatement(Query14);
            PreparedStatement preparedStatement12 = myCon.prepareStatement(Query15);
            PreparedStatement preparedStatement13 = myCon.prepareStatement(Query16);
            PreparedStatement preparedStatement14 = myCon.prepareStatement(Query17);



            String data;
            String specificData;
            String whereClause;

            while (results1.next())
            {
                data = results1.getInt(1) + " | " + results1.getString(2)  + " | " + results1.getString(3)
                        + " | " + results1.getString(4)+ " | " + results1.getString(5)+ " | " + results1.getString(6)
                        + " | " + results1.getString(7)+ " | " + results1.getString(8)+ " | " + results1.getString(9);
                System.out.println(data);
            }


            while (results2.next()){
                specificData = results2.getString(2) + " | " + results1.getString(3);
                System.out.println(specificData);
            }

            while (results2.next()){
                if(results3.getInt(1) == 1){
                    whereClause = results2.getString(2) + " | " + results1.getString(3);
                    System.out.println(whereClause);
                }


                System.out.println(preparedStatement1);
                System.out.println(preparedStatement2);
                System.out.println(preparedStatement3);
                System.out.println(preparedStatement4);
                System.out.println(preparedStatement5);
                System.out.println(preparedStatement6);
                System.out.println(preparedStatement7);
                System.out.println(preparedStatement8);
                System.out.println(preparedStatement9);
                System.out.println(preparedStatement10);
                System.out.println(preparedStatement11);
                System.out.println(preparedStatement12);
                System.out.println(preparedStatement13);
                System.out.println(preparedStatement14);
            }
            results1.close();
            results2.close();
            results3.close();
            myCon.close();


        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
