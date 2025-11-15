🚍 Transport Management System

A Java Swing + MySQL application for managing vehicles, customers, and bookings in a transport service.


---

✨ Features

🛠️ Admin Module

Add new vehicles

View / edit / delete vehicles

View all customer bookings

Cancel any booking

Dashboard for overall management


👤 Customer Module

Register & Login

View available vehicles added by admin

Book a vehicle

View booking history

Cancel their booking



---

🧰 Technologies Used

Java (Core + Swing)

MySQL Database

JDBC

Eclipse / IntelliJ IDEA



---

📁 Project Structure

Transport_Management_System/
 ├── src/
 │   ├── uiClass/
 │   ├── dbOperations/
 │   ├── models/
 │   └── MainFrame.java
 ├── lib/
 ├── transport_management_system.sql   ← Database file
 ├── .gitignore
 └── README.md


---

🛢️ Database Setup (MySQL)

1️⃣ Create the database:

CREATE DATABASE transportdb;
USE transportdb;

2️⃣ Import the SQL file
(Go to phpMyAdmin → Import → select transport_management_system.sql)

3️⃣ Update DB credentials in:

src/dbOperations/DBConnection.java

Example:

String url = "jdbc:mysql://localhost:3306/transportdb";
String username = "root";
String password = "yourpassword";


---

▶️ How to Run the Project

In Eclipse

1. Download or clone the project


2. Right-click → Build Path → Add External JARs…


3. Add mysql-connector.jar


4. Run LoginFrame.java




---

📸 Screenshots

(Add after uploading images)

/screenshots/login.png
/screenshots/admin.png
/screenshots/booking.png


---

🎯 Future Enhancements

Online booking with email OTP

GPS-based Live Bus Tracking (IoT)

Payment Integration (Razorpay)

Admin analytics dashboard



---

👨‍💻 Developer

Santhakumar M
Java Developer | Fresher
GitHub: https://github.com/santha020605


---
