# mdCMS

## About

mdCMS is a content management system to create a simple websites (blogs, portfolios etc.). It was written in Java™ using Java Servlet Page, Spring Framework and Hibernate. It uses MySQL database.

## Features

- Secure login system
- Administrator and moderator accounts
- Admin Panel with all settings
- Fully responsive default and admin panel template
- Dynamically add, edit, delete, categorize posts with a posibility of comments
- Dynamic Pages System
- Dynamic Navigation Menu and Sidebars
- Photo Gallery
- Contact Form System

## Screenshots

![alt tag](http://dultzdev.com/images/mdcms_screenshot1.png)
![alt tag](http://dultzdev.com/images/mdcms_screenshot2.png)

## Used technologies and API

- Java™
- JSP
- Spring Framework (Spring MVC, Spring Security)
- Hibernate
- Maven
- Java Persistance API
- JSP
- CSS3
- Bootstrap

## Install

To install mdCMS to create your website you should: 
1. Install Apache Tomcat (8, 8.5 or 9) and MySQL in your server.
2. Upload .war or unpacked war to `.../tomcat/webapps` folder.
3. Create new MySQL database and import schema `mdcms_schema.sql`.
4. Edit `application.properties` to configure database connection:
```sh
jdbc.url = jdbc:mysql://localhost:3306/{your_database_name}
jdbc.username = username (for example: root)
jdbc.password = your password
```
5. If you using Linux Server (Debian, Ubuntu etc.) you should add to `my.cnf` this command:
```sh
lower_case_table_names=1
```
6. Website with example content should be installed.
