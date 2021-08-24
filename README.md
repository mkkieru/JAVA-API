#Organizational News Portal API, August 24 2021 
##By Mark kieru

###Description

This is an API that allows users to key in organizations departments, users in that department and news relating to that department.
It also allows fetching of the inputted data.

###Technologies Used

Java Spark.Java Gradle Maven
JSON

###Setup Instructions

For You to have a copy of this application, fork and clone this repository [https://github.com/mkkieru/JAVA-API.git] into your local machine.
Run the create.sql file using psql<create.sql to setup the psql databases locally.

To vies the Full working API, click on the following link: [https://organizational-news-portal-api.herokuapp.com/].

###Known Bugs

There are no known bugs currently. The page works as expected. 
Support and Contact Details For any comments,suggestions,feedback or inquiries, contact me via email:[mkkieru55@gmail.com]

###Database Tables

This is the database structure of the Organizational News Portal API inclusive of test database.

CREATE DATABASE organization_portal;
 \c organization_portal
CREATE TABLE departments(
    id SERIAL PRIMARY KEY,
    name VARCHAR,
    description VARCHAR,
    totalemployees VARCHAR
);

CREATE TABLE news(
    id SERIAL PRIMARY KEY,
    description VARCHAR,
    departmentid VARCHAR
);

CREATE TABLE users(id SERIAL PRIMARY KEY,
    name VARCHAR,
    department VARCHAR,
    departmentid VARCHAR,
    companyposition VARCHAR,
    roleplayed VARCHAR
);
CREATE DATABASE organization_portal_Test WITH TEMPLATE organization_portal;

The heroku databse is #postgresql-rugged-71171
 
###License 
This project is licensed under the MIT Open Source license Copyright (c) 2021. [Mark Kieru]