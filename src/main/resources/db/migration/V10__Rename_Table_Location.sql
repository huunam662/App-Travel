alter table provinces_location rename to location_provinces;
alter table districts_location rename to location_districts;
alter table wards_location rename to location_wards;

alter table location_wards rename column district_location_id to location_district_id;
alter table location_districts rename column province_location_id to location_province_id;