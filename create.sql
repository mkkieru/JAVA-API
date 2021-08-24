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
