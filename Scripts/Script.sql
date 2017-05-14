select * from title;



select * from title where tcode= (select max(tcode) from title );
select * from employee;

drop database ncs_erp_jsh;
use ncs_erp_jsh;