SET foreign_key_checks = 0;
/* TODO
Add FLags to incidcate primary contact for organization
Add fals to users table for org or volunteer (TRUE FALSE?)
*/

DROP TABLE IF EXISTS users;
CREATE TABLE users (
	user_id INT PRIMARY KEY NOT NULL,
	username VARCHAR(20),
	password VARCHAR(20)
);


DROP TABLE IF EXISTS volunteers;
CREATE TABLE volunteers (
	volunteer_id VARCHAR(100) PRIMARY KEY NOT NULL,
	volunteer_name VARCHAR(100),
	email VARCHAR(100),
	address VARCHAR(100),
	user_id INT NOT NULL, 
	CONSTRAINT `volunteer_user_fk` FOREIGN KEY (user_id) REFERENCES users(user_id)

);

DROP TABLE IF EXISTS orgs;
CREATE TABLE orgs (
	org_id VARCHAR(100) PRIMARY KEY NOT NULL,
	mission_id VARCHAR(100),
	org_name VARCHAR(100),
	email VARCHAR(100),
	address VARCHAR(100),
	user_id INT NOT NULL, 
	CONSTRAINT `orgs_user_fk` FOREIGN KEY (user_id) REFERENCES users(user_id)	
);

DROP TABLE IF EXISTS projects;
CREATE TABLE projects (
	project_id INT PRIMARY KEY NOT NULL,
	org_name VARCHAR(100),
	city VARCHAR(100),
	country VARCHAR(100),
	startDate DATE,
	endDate DATE,
	skill_id VARCHAR(100),
	address VARCHAR(100),
	org_id VARCHAR(100) NOT NULL,
	CONSTRAINT `projectOrg_fk` FOREIGN KEY (org_id) REFERENCES orgs (org_id)
);

DROP TABLE IF EXISTS skills;
CREATE TABLE skills (
	skill_id VARCHAR(100) PRIMARY KEY NOT NULL,
	skill_name VARCHAR(100),
	description VARCHAR(100)
);


DROP TABLE IF EXISTS volunteer_skills;
CREATE TABLE volunteer_skills(
	project_id VARCHAR(100) REFERENCES projects(project_id),
	volunteer_id VARCHAR(100) REFERENCES volunteers(volunteer_id),
	skill_id VARCHAR(100) REFERENCES skills(skill_id)
);

DROP TABLE IF EXISTS project_member;
CREATE TABLE project_member(
	project_id VARCHAR(100) REFERENCES projects(project_id),
	org_id VARCHAR(100) REFERENCES orgs(org_id),
	skill_id VARCHAR(100) REFERENCES skills(skill_id),
	CONSTRAINT PRIMARY KEY (project_id, org_id)
);
SET foreign_key_checks = 1;	
