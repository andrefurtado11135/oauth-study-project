CREATE TABLE sch_authdemo.security_user(
	id BIGSERIAL not null,
	username VARCHAR not null,
	password VARCHAR not null,
	disable_date DATE,
	is_account_non_expired BOOLEAN,
	is_account_non_locked BOOLEAN,
	is_credentials_non_expired BOOLEAN,
	CONSTRAINT usuario_pk PRIMARY KEY(id)
);

CREATE TABLE sch_authdemo.authority(
	id BIGSERIAL not null,
	name VARCHAR not null,
	CONSTRAINT name_pk PRIMARY KEY(id)
);


CREATE TABLE sch_authdemo.user_authorities (
   user_id BIGINT NOT NULL,
   authority_id BIGINT NOT NULL,
   PRIMARY KEY (user_id, authority_id)
);

ALTER TABLE sch_authdemo.user_authorities ADD CONSTRAINT user_authorities_authority
   FOREIGN KEY (authority_id) REFERENCES sch_authdemo.authority(id);

ALTER TABLE sch_authdemo.user_authorities ADD CONSTRAINT user_authorities_security_user
   FOREIGN KEY (user_id) REFERENCES sch_authdemo.security_user(id);