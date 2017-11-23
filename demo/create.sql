create sequence test.contact_sequence start 1 increment 1
create sequence test.note_sequence start 1 increment 1
create sequence test.person_sequence start 1 increment 1
create table test.contact (id int4 not null, email varchar(255) not null, prmary_phone_number varchar(255) not null, secondary_phone_number varchar(255), primary key (id))
create table test.note (id int4 not null, created_by varchar(255), creation_date timestamp, last_modified_by varchar(255), last_modified_date timestamp, description varchar(255) not null, title varchar(255) not null, person_id int4, primary key (id))
create table test.person (id int4 not null, first_name varchar(255) not null, last_name varchar(255) not null, contact_id int4, primary key (id))
alter table if exists test.note add constraint fk_note_person foreign key (person_id) references test.person
alter table if exists test.person add constraint fk_person_contact foreign key (contact_id) references test.contact
