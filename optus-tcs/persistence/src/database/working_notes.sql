--- Clean tables ----
delete from Wurfl_Group_Capability;
delete from Wurfl_Group_Capability_AUD;
delete from WURFL_CAPABILITY;
delete from WURFL_CAPABILITY_AUD;
delete from Wurfl_Device_Group;
delete from Wurfl_Device_Group_AUD;
delete from WURFL_GROUP;
delete from WURFL_GROUP_AUD;
delete from WURFL_DEVICE;
delete from WURFL_DEVICE_AUD;
delete from WURFL_SOURCE;
commit;

select 'WURFL_CAPABILITY', count(*) from WURFL_CAPABILITY;
select 'WURFL_CAPABILITY_AUD', count(*) from WURFL_CAPABILITY_AUD;
select 'WURFL_GROUP', count(*) from WURFL_GROUP;
select 'WURFL_GROUP_AUD', count(*) from WURFL_GROUP_AUD;
select 'WURFL_DEVICE', count(*) from WURFL_DEVICE;
select 'WURFL_DEVICE_AUD', count(*) from WURFL_DEVICE_AUD;
select 'WURFL_SOURCE', count(*) from WURFL_SOURCE;