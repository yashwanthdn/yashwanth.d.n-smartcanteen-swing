# 📄 SMART CANTEEN SYSTEM

### (Java Swing + JDBC + MySQL)

---

# 1. 📌 Project Overview

The Smart Canteen System is a desktop-based application developed using Java Swing for the graphical user interface, JDBC for database connectivity, and MySQL as the backend database.

The system allows customers to register, log in, view available food items, and place orders. Staff members can log in separately to manage food items and view customer orders. This application helps automate canteen operations and reduces manual work.

---

# 2. 🎯 Objectives

The main objective of this project is to digitize the canteen ordering system. It aims to make ordering faster, reduce human errors, and provide a user-friendly interface for both customers and staff.

---

# 3. 🛠️ Technologies Used

The project is built using Core Java. Swing is used to create the graphical interface. JDBC is used to connect Java with the MySQL database. The project can be developed and executed using IDEs like Eclipse or IntelliJ.

---

# 4. 🧱 System Architecture

The system follows a simple three-layer architecture. The top layer is the user interface built using Swing. The middle layer contains the business logic implemented using DAO classes. The bottom layer is the MySQL database where all data is stored.

---

# 5. 🗄️ Database Description

The application uses a MySQL database named `smart_canteen_gui`. It stores information about users, staff, food items, orders, and order details. Each entity is stored in a separate table, and relationships are maintained using IDs.

---

# 6. 📂 Project Structure

The project is organized into different Java classes. The main class is responsible for launching the application. Separate classes are used for user interface screens like login, registration, customer dashboard, and staff dashboard. DAO classes handle all database operations, and a DBConnection class manages the database connection.

---

# 7. ⚙️ Functional Modules

The system is divided into two main modules.

The customer module allows users to register, log in, view the menu, place orders, and check their order history.

The staff module allows staff members to log in, add new food items, update prices, delete items, and view all customer orders.

---

# 8. 🔑 Key Components

The DBConnection class is responsible for establishing a connection with the database.

The UserDAO class handles customer registration and login.

The StaffDAO class is used for staff authentication.

The FoodDAO class manages operations related to food items such as adding, updating, and deleting.

The OrderDAO class handles order placement and retrieving order details.

The MainFrame class is the entry point of the application and displays the login interface.

---

# 9. 🔄 System Workflow

When the application starts, the user is presented with a login screen. A new user can register, while existing users can log in. After logging in, customers can browse the menu and place orders. Staff members can manage food items and view orders. All actions are stored and retrieved from the database.

---

# 10. ▶️ How to Run the Project

First, set up the MySQL database and create the required tables. Then configure the database connection in the DBConnection class with your MySQL username and password. Add the MySQL connector library to your project. Finally, run the MainFrame class to start the application.

---

# 11. ⚠️ Limitations

The current system stores passwords in plain text and does not include advanced security features. The user interface is basic and can be improved. There is no online payment system or order tracking feature.

---

# 12. 🚀 Future Enhancements

The project can be improved by adding password encryption, better user interface design, and additional features like online payment and real-time order tracking. It can also be extended into a web or mobile application.

---

# 13. ✅ Conclusion

The Smart Canteen System is a simple and effective application that demonstrates how Java Swing, JDBC, and MySQL can be used together to build a real-world project. It improves efficiency and provides a structured way to manage canteen operations.

---

