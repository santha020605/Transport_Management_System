# 🚌 Transport Booking System (Desktop Application)

A robust desktop application for managing a transport service, allowing both **Administrators** and **Customers** to handle vehicle details, manage bookings, and check real-time availability.



---

## ✨ Features

### 🔑 Core Functionality

* **Secure Login/Registration:** Separate secure login portals for **Admin** and **Customer**.
* **User Management:** Admins can manage customer accounts.
* **Availability Checker:** Real-time checking of vehicle availability based on booking dates.
* **Booking Management:** Complete workflow from booking creation to confirmation/cancellation.

### ⚙️ Admin Module Features

* **Vehicle Management:**
    * Add, Update, Delete, and View transport vehicles (e.g., buses, cars, vans).
    * Define vehicle properties (model, capacity, route, price, license plate).
* **Route/Trip Management:** Define and manage available routes and trip schedules.
* **Booking Oversight:** View, confirm, or cancel all customer bookings.
* **Reporting:** Generate reports on bookings, vehicle utilization, and revenue.

### 👤 Customer Module Features

* **Vehicle Search:** Browse and search for available vehicles based on criteria like date, route, and capacity.
* **Booking:** Create new bookings for available transport.
* **Booking History:** View personal booking history and status.
* **Profile Management:** Update personal contact information.

---

## 🛠️ Technologies Used

| Category | Technology | Description |
| :--- | :--- | :--- |
| **Frontend** | **Java Swing** | Used for building the graphical user interface (GUI) of the desktop application. |
| **Backend Logic**| **Java (JDK)** | Core programming language for application logic, business rules, and event handling. |
| **Database** | **MySQL** | Relational database management system used for storing all application data (users, vehicles, bookings, etc.). |
| **Database Connectivity**| **JDBC** | Java Database Connectivity API for connecting the Java application to the MySQL database. |

---

## 🚀 Getting Started

### Prerequisites

* **Java Development Kit (JDK) 8 or higher**
* **MySQL Server** (e.g., XAMPP, WAMP, or standalone MySQL)
* **MySQL JDBC Driver** (Connector/J)

### Installation Steps

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/your-username/Transport-Booking-System.git
    cd transport-booking-system
    ```

2.  **Database Setup:**
    * Create a new database named `transportdb` in your MySQL server.
    * Execute the SQL script located in the `database/schema.sql` file to create the necessary tables (`admin`, `customer`, `vehicle`, `booking`, etc.).

    > 💡 **Note:** The database connection details (username, password, database name) are configured in the `src/config/DBConfig.java` file. You may need to update these credentials to match your local MySQL setup.

3.  **Add JDBC Driver:**
    * Download the **MySQL Connector/J** (`.jar` file).
    * Add this JAR file to your project's build path (e.g., in your IDE like IntelliJ IDEA or Eclipse, configure it as an external library).

4.  **Run the Application:**
    * Compile and run the main class file, typically `src/main/ui/Login_frame.java` or similar, from your IDE.

---

## 📄 Database Schema Overview

| Table | Purpose | Key Fields |
| :--- | :--- | :--- |
| `admin` | Stores administrative user credentials. | `admin_id`, `username`, `password` |
| `customer` | Stores customer details and login credentials. | `customer_id`, `name`, `email`, `password` |
| `vehicle` | Stores details of all transport vehicles. | `vehicle_id`, `model`, `capacity`, `license_plate`, `price` |
| `booking` | Stores all booking records made by customers. | `booking_id`, `customer_id (FK)`, `vehicle_id (FK)`, `start_date`, `end_date`, `status` |
| `route` | Stores available routes and associated pricing. | `route_id`, `source`, `destination`, `distance` |

---

## 📞 Contact

If you have any questions or suggestions, please open an issue in this repository or contact the developer at:

* **Developer:** *Santhakumar M*
* **Email:** [ santhakpr45@gmail.com ]
