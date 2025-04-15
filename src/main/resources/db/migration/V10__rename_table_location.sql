alter table if exists provinces_location rename to location_provinces;
alter table if exists districts_location rename to location_districts;
alter table if exists wards_location rename to location_wards;

alter table if exists location_wards rename column district_location_id to location_district_id;
alter table if exists location_districts rename column province_location_id to location_province_id;